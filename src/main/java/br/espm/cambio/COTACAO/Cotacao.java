package br.espm.cambio.COTACAO;

import java.sql.Date;

import javax.print.DocFlavor.STRING;

public class Cotacao {
    
    private String id;
    private String moeda;
    private String data;
    private Double valor;

    public Cotacao(){
    }

    public Cotacao(String data, Double valor){
        this.data = data;
        this.valor = valor;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getMoeda() {
        return moeda;
    }
    public void setMoeda(String moeda) {
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
