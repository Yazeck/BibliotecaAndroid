package com.example.bibliotk.response;

import com.google.gson.annotations.SerializedName;

public class DataAdminUsuario {
    @SerializedName(value = "id_usuario")
    private String idusuario;

    @SerializedName(value = "nom_usuario")
    private String nomusuario;

    @SerializedName(value = "contrasena")
    private String contrasena;

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getNomusuario() {
        return nomusuario;
    }

    public void setNomusuario(String nomusuario) {
        this.nomusuario = nomusuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
