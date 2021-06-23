package com.example.api_crops;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cultura{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigoCultura;
    
    private String nome;
    
    // Getters and Setters
    
    public int getCodigoCultura() {
        return codigoCultura;
    }
    public void setCodigoCultura(int codigoCultura) {
        this.codigoCultura = codigoCultura;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}