package com.example.bibliotk.webservice;

import com.example.bibliotk.response.AdminUsuarioResponse;
import com.example.bibliotk.response.AutorResponse;
import com.example.bibliotk.response.CategoriasResponse;
import com.example.bibliotk.response.DataAdminUsuario;
import com.example.bibliotk.response.DataAutor;
import com.example.bibliotk.response.DataCategoria;
import com.example.bibliotk.response.DataEditorial;
import com.example.bibliotk.response.DataUsuario;
import com.example.bibliotk.response.EditorialResponse;
import com.example.bibliotk.response.UsuariosResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface WebService {
    @POST("/adminlogin")
    Call<AdminUsuarioResponse> login(
            @Body DataAdminUsuario usuario
    );
    @GET("/usuarios")
    Call<UsuariosResponse> obtenerUsuarios();

    @POST("/usuarios/add")
    Call<UsuariosResponse> agregarUsuarios(
            @Body DataUsuario usuario
    );

    @POST("/usuarios/update")
    Call<UsuariosResponse> actualizarUsuarios(
            @Body DataUsuario usuario
    );

    @POST("/usuarios/delete")
    Call<UsuariosResponse> borrarUsuarios(
            @Body DataUsuario usuario
    );

    @GET("/autores")
    Call<AutorResponse> obtenerAutores();

    @POST("/autores/add")
    Call<AutorResponse> agregarAutor(
            @Body DataAutor autor
    );

    @POST("/autores/update")
    Call<AutorResponse> actualizarAutor(
            @Body DataAutor autor
    );

    @POST("/autores/delete")
    Call<AutorResponse> borrarAutor(
            @Body DataAutor autor
    );

    @GET("/editoriales")
    Call<EditorialResponse> obtenerEditoral();

    @POST("/editoriales/add")
    Call<EditorialResponse> agregarEditorial(
            @Body DataEditorial editorial
    );

    @POST("/editoriales/update")
    Call<EditorialResponse> actualizarEditorial(
            @Body DataEditorial editorial
    );

    @POST("/editoriales/delete")
    Call<EditorialResponse> borrarEditoral(
            @Body DataEditorial editorial
    );

    @GET("/categorias")
    Call<CategoriasResponse> obtenerCategorias();

    @POST("/categorias/add")
    Call<CategoriasResponse> agregarCategoria(
            @Body DataCategoria categoria
    );

    @POST("/categorias/update")
    Call<CategoriasResponse> actualizarCategoria(
            @Body DataCategoria categoria
    );

    @POST("/categorias/delete")
    Call<CategoriasResponse> borrarCategoria(
            @Body DataCategoria categoria
    );


}
