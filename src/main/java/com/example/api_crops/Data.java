package com.example.api_crops;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Data{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigoData;
    
    private Date dataSemeadura;
    private Date dataColheita;
    // Construtor
    /*public Data(Date datasemeadura, Date datacolheita){
        this.dataSemeadura = datasemeadura;
        this.dataColheita = datacolheita;
    }*/
    // Getters and Setters
    public void setCodigoData(int codigoData) {
        this.codigoData = codigoData;
    }
    public int getCodigoData() {
        return codigoData;
    }
    public Date getDataSemeadura(){
        return dataSemeadura;
    }
    public void setDataSemeadura(Date datasemeadura){
            this.dataSemeadura = datasemeadura;
    }
    public Date getDataColheita() {
        return dataColheita;
    }
    public void setDataColheita(Date dataColheita) {
        this.dataColheita = dataColheita;
    }
}