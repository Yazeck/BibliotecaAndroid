package com.example.bibliotk.view.navegacionview;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.bibliotk.R;
import com.example.bibliotk.databinding.ActivityNavegacionScreenBinding;
import com.example.bibliotk.response.DataAdminUsuario;
import com.example.bibliotk.utils.Utils;
import com.example.bibliotk.view.loginscreenview.LoginScreenActivity;

public class NavegacionScreenActivity extends AppCompatActivity {
    private ActivityNavegacionScreenBinding binding;
    DataAdminUsuario usuario;
    Utils utils= new Utils();

    String[]listaMenu;
    AdaptadorMenu adaptadorMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityNavegacionScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        usuario=utils.leerSharedPreferences(NavegacionScreenActivity.this);
        binding.tvUsuario.setText(usuario.getNomusuario());
        setupRecyclerView();
        binding.ibtnCerrarSesion.setOnClickListener(view->{
            utils.borrarSharedPreference(this);
            Intent intent=new Intent(this,
                    LoginScreenActivity.class);
            startActivity(intent);
            finish();
        });

    }

    private void setupRecyclerView() {
        GridLayoutManager layoutManager=
                new GridLayoutManager(this,2);
        binding.rvMenu.setLayoutManager(layoutManager);
        listaMenu=getResources().getStringArray(R.array.lista_menu);
        adaptadorMenu=new AdaptadorMenu(this,listaMenu);
        binding.rvMenu.setAdapter(adaptadorMenu);
    }
}