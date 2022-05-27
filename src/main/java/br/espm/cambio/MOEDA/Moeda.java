package br.espm.cambio.MOEDA;

import java.util.UUID;

//Para rodar
// mvn clena install
// java -jar target/cambio-0.0.1-SNAPSHOT.jar

public class Moeda {
    
    private UUID id;
    private String nome;
    private String simbolo;

    public Moeda(){
    }

    public Moeda(String nome, String simbolo){
        this.nome = nome;
        this.simbolo = simbolo;
    }

    public String getNome() {
        return nome;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}