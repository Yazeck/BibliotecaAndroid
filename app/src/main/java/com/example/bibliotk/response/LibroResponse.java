package com.example.bibliotk.response;

import java.util.List;

public class LibroResponse {
    private  String code;
    private String mensaje;
    private List<DataLibro> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<DataLibro> getData() {
        return data;
    }

    public void setData(List<DataLibro> data) {
        this.data = data;
    }
}
