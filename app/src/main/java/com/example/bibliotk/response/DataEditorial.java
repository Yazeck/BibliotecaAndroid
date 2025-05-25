package com.example.bibliotk.response;

import com.google.gson.annotations.SerializedName;

public class DataEditorial {
    @SerializedName("id_editorial")
    private String idEditorial;

    @SerializedName("nom_editorial")
    private String nomEditorial;

    public String getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(String idEditorial) {
        this.idEditorial = idEditorial;
    }

    public String getNomEditorial() {
        return nomEditorial;
    }

    public void setNomEditorial(String nomEditorial) {
        this.nomEditorial = nomEditorial;
    }

    public void resetData(){
        this.idEditorial="";
        this.nomEditorial="";
    }

    @Override
    public  String toString(){
        return this.idEditorial+","+this.nomEditorial;
    }

}
