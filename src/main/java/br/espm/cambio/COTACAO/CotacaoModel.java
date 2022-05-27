package br.espm.cambio.COTACAO;

import java.sql.Date;

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
    private String data;

    @Column (name = "vr_valor")
    private double valor;

    public Cotacao to(){
        Cotacao cotacao = new Cotacao();
            cotacao.setData(this.data);
            cotacao.setId(this.idCotacao);
            cotacao.setMoeda(this.idMoeda);
            cotacao.setValor(this.valor);
        return cotacao; 
    }

    public CotacaoModel(){       
    }

    public CotacaoModel(Cotacao cotacao){
        this.data = cotacao.getData();
        this.valor = cotacao.getValor();
        this.idCotacao = cotacao.getId();
        this.idMoeda = cotacao.getMoeda();
    }

}
