package com.example.bibliotk.view.usuariosview;

import static android.app.ProgressDialog.show;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.bibliotk.R;
import com.example.bibliotk.databinding.ActivityUsuariosScreenBinding;
import com.example.bibliotk.response.DataAdminUsuario;
import com.example.bibliotk.response.DataUsuario;
import com.example.bibliotk.response.UsuariosResponse;
import com.example.bibliotk.retrofit.RetrofitClient;
import com.example.bibliotk.utils.Utils;
import com.example.bibliotk.view.navegacionview.AdaptadorMenu;
import com.example.bibliotk.webservice.WebService;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UsuariosScreenActivity extends AppCompatActivity implements AdaptadorUsuario.OnItemClicked {

    private ActivityUsuariosScreenBinding binding;
    AdaptadorUsuario adaptadorUsuario;
    List<DataUsuario> listaUsuarios = new ArrayList<>();
    boolean isEditado = false;
    DataUsuario usuario = new DataUsuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUsuariosScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        cargarUsuariosSimulados();

        binding.ibtnUsuarioAdd.setOnClickListener(view -> {
            usuario = new DataUsuario(); // Nuevo usuario
            isEditado = false;
            alertDialogAddUpdate();
        });
    }

    private void cargarUsuariosSimulados() {
        listaUsuarios = new ArrayList<>();

        DataUsuario u1 = new DataUsuario();
        u1.setNomusuario("Erick Nungaray");
        u1.setEstado_Usuario("Activo");
        u1.setContrasena("123");

        DataUsuario u2 = new DataUsuario();
        u2.setNomusuario("Lucía Martínez");
        u2.setEstado_Usuario("Inactivo");
        u2.setContrasena("456");

        DataUsuario u3 = new DataUsuario();
        u3.setNomusuario("Monse Alvarez");
        u3.setEstado_Usuario("Activo");
        u3.setContrasena("423");

        listaUsuarios.add(u1);
        listaUsuarios.add(u2);
        listaUsuarios.add(u3);

        adaptadorUsuario = new AdaptadorUsuario(this, listaUsuarios, this);
        binding.rvUsuarios.setLayoutManager(new LinearLayoutManager(this));
        binding.rvUsuarios.setAdapter(adaptadorUsuario);
    }

    private void alertDialogAddUpdate() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(
                com.example.bibliotk.R.layout.alert_dialog_add_update_usuario, null);
        builder.setView(view);
        AlertDialog dialog = builder.create();
        dialog.show();

        EditText etIdUsuario = view.findViewById(com.example.bibliotk.R.id.etIdUsuario);
        EditText etNomUsuario = view.findViewById(com.example.bibliotk.R.id.etNomUsuario);
        EditText etPassword = view.findViewById(com.example.bibliotk.R.id.etContrasena);
        TextView tvTitulo = view.findViewById(com.example.bibliotk.R.id.tvTituloAlert);

        if (isEditado) {
            tvTitulo.setText("EDITAR USUARIO");
            etIdUsuario.setText(usuario.getIdusuario());
            etNomUsuario.setText(usuario.getNomusuario());
            etPassword.setText(usuario.getContrasena());
        }
        TextView tvBtnGuardar = view.findViewById(R.id.tvBtnGuardar);

        tvBtnGuardar.setOnClickListener(v -> {
            usuario.setIdusuario(etIdUsuario.getText().toString());
            usuario.setNomusuario(etNomUsuario.getText().toString());
            usuario.setContrasena(etPassword.getText().toString());
            usuario.setEstado_Usuario("Activo");

            if (!isEditado) {
                listaUsuarios.add(usuario);
            }

            adaptadorUsuario.notifyDataSetChanged();
            dialog.dismiss();
        });


        // Guardar (usa el botón de "aceptar" en el diálogo o crea uno)
        view.findViewById(com.example.bibliotk.R.id.tvTituloAlert).setOnClickListener(v -> {
            usuario.setIdusuario(etIdUsuario.getText().toString());
            usuario.setNomusuario(etNomUsuario.getText().toString());
            usuario.setContrasena(etPassword.getText().toString());
            usuario.setEstado_Usuario("Activo");

            if (!isEditado) {
                listaUsuarios.add(usuario);
            }

            adaptadorUsuario.notifyDataSetChanged();
            dialog.dismiss();
        });
    }


    @Override
    public void editarUsuario(DataUsuario usuario) {
        this.usuario = usuario;
        isEditado = true;
        alertDialogAddUpdate();
    }

    @Override
    public void borrarUsuario(DataUsuario usuario) {
        listaUsuarios.remove(usuario);
        adaptadorUsuario.notifyDataSetChanged();
    }
}