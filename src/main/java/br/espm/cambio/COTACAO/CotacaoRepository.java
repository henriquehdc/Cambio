package br.espm.cambio.COTACAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CotacaoRepository extends CrudRepository <CotacaoModel , String>{
    
    @Override
    Iterable<CotacaoModel> findAll();

    @Override
    Optional<CotacaoModel> findById(String id);

    @Query ("SELECT m.idMoeda from cotacao c inner join moeda m on c.idMoeda=m.idMoeda WHERE m.txSimbolo = simbolo")
    Optional<CotacaoModel> findBySimbolo (@Param ("simbolo") String simbolo);
    // da um return no id moeda puxando pelo simbolo 

}
