package com.example.api_crops;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dicas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigoDicas;
    
    private String nomeDicas;
    private String descricaoDicas;
    
    public int getCodigoDicas() {
        return codigoDicas;
    }
    public void setCodigoDicas(int codigoDicas) {
        this.codigoDicas = codigoDicas;
    }
    public String getNomeDicas() {
        return nomeDicas;
    }
    public void setNomeDicas(String nomeDicas) {
        this.nomeDicas = nomeDicas;
    }
    public String getDescricaoDicas() {
        return descricaoDicas;
    }
    public void setDescricaoDicas(String descricaoDicas) {
        this.descricaoDicas = descricaoDicas;
    }

    // Construtor
    /*public Dicas(String nomedicas, String descricaodicas){
        this.nomeDicas = nomedicas;
        this.descricaoDicas = descricaodicas;
    }*/
}