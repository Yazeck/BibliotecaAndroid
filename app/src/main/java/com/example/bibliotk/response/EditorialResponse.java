package com.example.bibliotk.response;

import java.util.List;

public class EditorialResponse {
    private  String code;
    private String mensaje;
    private List<DataEditorial> data;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataEditorial> getData() {
        return data;
    }

    public void setData(List<DataEditorial> data) {
        this.data = data;
    }
}
