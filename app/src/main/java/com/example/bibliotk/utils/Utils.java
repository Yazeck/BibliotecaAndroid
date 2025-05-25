package com.example.bibliotk.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.bibliotk.response.DataAdminUsuario;
import com.example.bibliotk.view.navegacionview.NavegacionScreenActivity;

public class Utils {
    //tiempo de duracion 4 seg
    private static final int DURACION_SPLASH_SCREEN=400;

    public  int getDuracionSplashScreen(){
        return  DURACION_SPLASH_SCREEN;
    }
    public  boolean validarCamposLogin(String idUsuario, String contrasena){
        if(idUsuario.isEmpty() || contrasena.isEmpty()){
            return  false;
        }else {
            return  true;
        }
    }
    public void guardarSharedPreferences(Context context, DataAdminUsuario usuario){
        SharedPreferences preferences=context.getSharedPreferences("data_usuario",
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("idUsuario", usuario.getIdusuario());
        editor.putString("nomUsuario", usuario.getNomusuario());
        editor.apply();
    }
    public DataAdminUsuario leerSharedPreferences(Context context){
        SharedPreferences preferences= context
                .getSharedPreferences("data_usuario",Context.MODE_PRIVATE);
        DataAdminUsuario usuario= new DataAdminUsuario();
        usuario.setIdusuario(preferences.getString("idUsuario",""));
        usuario.setNomusuario(preferences.getString("nomUsuario",""));
        return usuario;
    }

    public void borrarSharedPreference(Context context) {
            SharedPreferences preferences= context
                    .getSharedPreferences("data_usuario", Context.MODE_PRIVATE);
            preferences.edit().clear().apply();
    }

    public boolean validarCamposAddUpdateUsuario(String idUsuario, String nomUsuario, String constrasena){
        if(idUsuario.isEmpty() || constrasena.isEmpty()){
            return false;
        }else{
            return true;
        }
    }

    public boolean validarCamposAddUpdateAutor(String idAutor, String nomAutor){
        if(idAutor.isEmpty() || nomAutor.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
}
