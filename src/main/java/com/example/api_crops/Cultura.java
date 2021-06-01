package com.example.api_crops;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cultura{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigoCultura;
    
    private String nome;
    @ManyToOne
    private Variedade variedade;

    @ManyToOne
    private Data data;
    
    @ManyToOne
    private Dicas dica;
    // Construtor
    /*public Cultura(String nome, Variedade variedade, Data data, Dicas dica){
        this.nome = nome;
        this.variedade = variedade;
        this.data = data;
        this.dica = dica;
    }*/

    // Getters and Setters
    public void setCodigo(int codigo) {
        this.codigoCultura = codigo;
    }
    public int getCodigo() {
        return codigoCultura;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Variedade getVariedade() {
        return variedade;
    }
    public void setVariedade(Variedade variedade) {
        this.variedade = variedade;
    }
    public Data getData() {
        return data;
    }
    public void setData(Data data) {
        this.data = data;
    }

    public Dicas getDica() {
        return dica;
    }
    public void setDica(Dicas dica) {
        this.dica = dica;
    }
}


/*
spring.jpa.hibernate.ddl-auto =update
spring.datasource.url =jdbc:mysql://127.0.0.1:8080/api
spring.datasource.username=root
spring.datasource.password=1234

*/