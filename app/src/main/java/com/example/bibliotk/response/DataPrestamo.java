package com.example.bibliotk.response;


public class DataPrestamo {
    private String idprestamo;
    private String usuario;
    private String libro;
    private String fechaPrestamo;
    private String fechaEntrega;
    private String estatus;

    public DataPrestamo() {}

    public DataPrestamo(String idprestamo, String usuario, String libro, String fechaPrestamo, String fechaEntrega, String estatus) {
        this.idprestamo = idprestamo;
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntrega = fechaEntrega;
        this.estatus = estatus;
    }

    public String getIdprestamo() {
        return idprestamo;
    }

    public void setIdprestamo(String idprestamo) {
        this.idprestamo = idprestamo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
