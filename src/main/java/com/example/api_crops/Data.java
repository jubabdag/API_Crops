package com.example.api_crops;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Data{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigoData;
    
    private String dataSemeadura;
    private String dataColheita;
    
    // Getters and Setters
    public void setCodigoData(int codigoData) {
        this.codigoData = codigoData;
    }
    public int getCodigoData() {
        return codigoData;
    }
    public String getDataSemeadura(){
        return dataSemeadura;
    }
    public void setDataSemeadura(String datasemeadura){
            this.dataSemeadura = datasemeadura;
    }
    public String getDataColheita() {
        return dataColheita;
    }
    public void setDataColheita(String dataColheita) {
        this.dataColheita = dataColheita;
    }
}