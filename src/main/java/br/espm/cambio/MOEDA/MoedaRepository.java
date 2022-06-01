package br.espm.cambio.MOEDA;

import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MoedaRepository extends CrudRepository <MoedaModel ,String>{

    @Override
    Iterable<MoedaModel> findAll();

    @Override
    Optional <MoedaModel> findById(String id);
    
    @Query ("Select m from MoedaModel m WHERE UPPER(m.txSimbolo) = UPPER(:simbolo)")
    Optional<MoedaModel> findBySimbolo (@Param ("simbolo") String simbolo);
    
    @Query ("Select idMoeda from MoedaModel WHERE UPPER(txSimbolo) = UPPER(:simbolo)")
    Optional<UUID> findBySimboloId (@Param ("simbolo") String simbolo);
    

    @Transactional
    @Modifying
    @Query ("Delete from MoedaModel m WHERE UPPER(m.idMoeda) = UPPER(:id)")
    void deleteById (@Param ("id") String id);

}
