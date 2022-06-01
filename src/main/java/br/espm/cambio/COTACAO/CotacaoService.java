package br.espm.cambio.COTACAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;
import java.util.stream.Collectors;

@Component
public class CotacaoService {
    
    @Autowired
    private CotacaoRepository cotacaoRepository;
     
    public List<Cotacao> listAll(UUID id){
        return StreamSupport
   
             //Transforma de iteravel para lista
             .stream(cotacaoRepository.findAll(id.toString()).spliterator(),false )
              .collect(Collectors.toList())

             //transforma de model para aoBJETO
             .stream().map(CotacaoModel::to)
             .collect(Collectors.toList());   
    }

    public Cotacao create(Cotacao cotacao){  
      cotacao.setId(UUID.randomUUID()); 
      return cotacaoRepository.save(new CotacaoModel(cotacao)).to();
    }

}
