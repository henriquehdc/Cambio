package br.espm.cambio.COTACAO;

import java.sql.Date;
import java.util.UUID;

import javax.print.DocFlavor.STRING;

public class Cotacao {
    
    private UUID id;
    private UUID moeda;
    private String data;
    private Double valor;

    public Cotacao(){
    }

    public Cotacao(UUID moeda , String data, Double valor){
        this.moeda = moeda;
        this.data = data;
        this.valor = valor;
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public UUID getMoeda() {
        return moeda;
    }
    public void setMoeda(UUID moeda) {
        this.moeda = moeda;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }

    
}
