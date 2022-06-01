package br.espm.cambio.COTACAO;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="cotacao")
public class CotacaoModel {
    
    @Id
    @Column (name = "id_cotacao")
    private String idCotacao;

    @Column (name = "id_moeda")
    private String idMoeda;

    @Column (name = "dt_data")
    private LocalDate data;

    @Column (name = "vr_valor")
    private double valor;

    public Cotacao to(){
        Cotacao cotacao = new Cotacao();
            cotacao.setData(this.data);
            cotacao.setId(UUID.fromString(this.idCotacao));
            cotacao.setMoeda(UUID.fromString(this.idMoeda));
            cotacao.setValor(this.valor);
        return cotacao; 
    }

    public CotacaoModel(){       
    }

    public CotacaoModel(Cotacao cotacao){
        this.data = cotacao.getData();
        this.valor = cotacao.getValor();
        this.idCotacao = cotacao.getId().toString();
        this.idMoeda = cotacao.getMoeda().toString();
    }

}
