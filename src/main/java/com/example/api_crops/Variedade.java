package com.example.api_crops;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.lang.NonNull;

import javax.persistence.GenerationType;

@Entity
public class Variedade{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigoVariedade;
    
    @NonNull
    private String nomeVariedade;

    public int getCodigoVariedade() {
        return codigoVariedade;
    }

    public void setCodigoVariedade(int codigoVariedade) {
        this.codigoVariedade = codigoVariedade;
    }

    public String getNomeVariedade() {
        return nomeVariedade;
    }

    public void setNomeVariedade(String nomeVariedade) {
        this.nomeVariedade = nomeVariedade;
    }
}