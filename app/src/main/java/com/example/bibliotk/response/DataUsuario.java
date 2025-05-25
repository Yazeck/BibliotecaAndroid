package com.example.bibliotk.response;

import com.google.gson.annotations.SerializedName;

public class DataUsuario {
    @SerializedName("id_usuario")
    private String idusuario;

    @SerializedName("nom_usuario")
    private String nomusuario;

    @SerializedName("estado_usuario")
    private String estado_Usuario;

    @SerializedName("contrasena")
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

    public String getEstado_Usuario() {
        return estado_Usuario;
    }

    public void setEstado_Usuario(String estado_Usuario) {
        this.estado_Usuario = estado_Usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public void resetData(){
        this.idusuario="";
        this.nomusuario="";
        this.estado_Usuario="";
        this.contrasena="";
    }
    @Override
    public  String toString(){
        return this.idusuario+","+this.nomusuario;
    }
}
