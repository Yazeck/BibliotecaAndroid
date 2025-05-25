package com.example.bibliotk.response;

import com.google.gson.annotations.SerializedName;

public class DataLibro {
    @SerializedName("isbn")
    private String isbn;

    @SerializedName("portada")
    private String portada;

    @SerializedName("nom_libro")
    private String nomLibro;

    @SerializedName("autor")
    private String autor;

    @SerializedName("descripcion")
    private String descripcion;

    @SerializedName("editorial")
    private String nomeditorial;

    @SerializedName("anio_publicacion")
    private String anioPublicacion;

    @SerializedName("edicion")
    private String edicion;

    @SerializedName("existencias")
    private int existencias;

    @SerializedName("categorias")
    private String nomCategoria;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public String getNomLibro() {
        return nomLibro;
    }

    public void setNomLibro(String nomLibro) {
        this.nomLibro = nomLibro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNomeditorial() {
        return nomeditorial;
    }

    public void setNomeditorial(String nomeditorial) {
        this.nomeditorial = nomeditorial;
    }

    public String getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(String anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public String getNomCategoria() {
        return nomCategoria;
    }

    public void setNomCategoria(String nomCategoria) {
        this.nomCategoria = nomCategoria;
    }

    public void  resetData(){
        this.isbn="";
        this.portada="";
        this.autor="";
        this.descripcion="";
        this.nomeditorial="";
        this.anioPublicacion="";
        this.edicion="";
        this.existencias=-1;
        this.nomCategoria="";
    }
}
