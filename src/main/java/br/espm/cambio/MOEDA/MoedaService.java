package br.espm.cambio.MOEDA;
import java.util.List;
import java.util.Spliterator;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Esse é o microserviço de moeda

@Component
public class MoedaService {

    @Autowired
    private MoedaRepository moedaRepository;
    
        public List<Moeda> listAll(){
            return StreamSupport

                //Transforma de iteravel para lista
                .stream(moedaRepository.findAll().spliterator(),false )
                .collect(Collectors.toList())

                //transforma de model para aoBJETO
                .stream().map(MoedaModel::to)
                .collect(Collectors.toList());                
                        
        }

        public Moeda create(Moeda vo){
          vo.setId(UUID.randomUUID()); 
          return moedaRepository.save(new MoedaModel(vo)).to();
        }

        public Moeda findBySimbolo(String simbolo){
          return  moedaRepository.findBySimbolo(simbolo)
                        .map(MoedaModel::to)
                        .orElse(null);
        }     

        public UUID findBySimboloId(String simbolo){
          return  moedaRepository.findBySimboloId(simbolo).orElse(null);
        } 


        public Moeda findById(UUID id) {
          return moedaRepository.findById(id.toString())
                      .map(MoedaModel::to)
                      .orElse(null);
      }

      public void DeleteById(UUID id){
        moedaRepository.deleteById(id.toString());
      }

}
