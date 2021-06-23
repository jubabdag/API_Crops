package com.example.api_crops;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.GenerationType;

@Entity
public class Variedade{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigoVariedade;
    
    private String nomeVariedade;

    @ManyToOne
    private Cultura cultura;

    @ManyToOne
    private Data data;
    
    @ManyToOne
    private Dicas dica;

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

    public Cultura getCultura() {
        return cultura;
    }

    public void setCultura(Cultura cultura) {
        this.cultura = cultura;
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