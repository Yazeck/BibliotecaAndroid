package com.example.bibliotk.view.loginscreenview;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bibliotk.databinding.ActivityLoginScreenBinding;
import com.example.bibliotk.response.AdminUsuarioResponse;
import com.example.bibliotk.response.DataAdminUsuario;
import com.example.bibliotk.retrofit.RetrofitClient;
import com.example.bibliotk.utils.Utils;
import com.example.bibliotk.view.navegacionview.NavegacionScreenActivity;
import com.example.bibliotk.webservice.WebService;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginScreenActivity extends AppCompatActivity {
    private ActivityLoginScreenBinding binding;

    Utils utils=new Utils();

    DataAdminUsuario usuario=new DataAdminUsuario();

    Retrofit retrofit=new RetrofitClient().getRetrofit();
    WebService webService=retrofit.create(WebService.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding=ActivityLoginScreenBinding.inflate(getLayoutInflater());
       setContentView(binding.getRoot());
        binding.btnLogin.setOnClickListener(view -> {
            // No importa el valor del usuario ni la contraseña
            Toasty.success(this, "Bienvenido", Toasty.LENGTH_SHORT).show();
            Intent intent = new Intent(this, NavegacionScreenActivity.class);
            startActivity(intent);
            finish();
        });


    }

    private void login() {
        //usuario.setIdusuario(binding.etUsuario.getText().toString().trim());
        usuario.setContrasena(binding.etContrasena.getText().toString().trim());

        //Enviamos la peticion
        Call<AdminUsuarioResponse> call = webService.login(usuario);
        call.enqueue(new Callback<AdminUsuarioResponse>(){
            @Override
            public void onResponse(Call<AdminUsuarioResponse> call, Response<AdminUsuarioResponse> response){
                //Guardamos la respuesta en el dispositivo
                if (response.body().getCode().equals("200")){
                    utils.guardarSharedPreferences(LoginScreenActivity.this,
                            response.body().getData().get(0));
                    /*Toasty.success(LoginScreenActivity.this,
                            response.body().getMensaje(), Toasty.LENGTH_SHORT,
                            true).show();*/
                    Intent intent= new Intent(LoginScreenActivity
                            .this,NavegacionScreenActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toasty.error(LoginScreenActivity.this,response.body().getMensaje(),
                            Toasty.LENGTH_SHORT,true).show();
                }
            }

            @Override
            public void onFailure(Call<AdminUsuarioResponse> call, Throwable t) {

            }

        });
    }
}