package com.example.bibliotk.view.autoresview;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.bibliotk.databinding.ActivityAutoresScreenBinding;
import com.example.bibliotk.response.DataAutor;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;

public class AutoresScreenActivity extends AppCompatActivity implements AdaptadorAutor.OnItemClicked {

    private ActivityAutoresScreenBinding binding;

    AdaptadorAutor adaptadorAutor;
    List<DataAutor> listaAutores = new ArrayList<>();
    DataAutor autor = new DataAutor();
    boolean isEditado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAutoresScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // PRUEBA: llena lista a la fuerza aquí mismo
        listaAutores = new ArrayList<>();
        Log.d("PRUEBA", "Autores cargados: " + listaAutores.size());
        DataAutor autor1 = new DataAutor();
        autor1.setIdAutor("A001");
        autor1.setNomAutor("Gabriel García Márquez");

        DataAutor autor2 = new DataAutor();
        autor2.setIdAutor("A002");
        autor2.setNomAutor("Isabel Allende");

        DataAutor autor3 = new DataAutor();
        autor3.setIdAutor("A003");
        autor3.setNomAutor("Julio Cortázar");

        listaAutores.add(autor1);
        listaAutores.add(autor2);
        listaAutores.add(autor3);

        setupRecyclerView();

        binding.ibtnAutorAdd.setOnClickListener(view -> {
            Toast.makeText(this, "Agregar autor", Toast.LENGTH_SHORT).show();
        });
    }

    private void obtenerAutores() {
        listaAutores.clear();

        DataAutor autor1 = new DataAutor();
        autor1.setIdAutor("A001");
        autor1.setNomAutor("Gabriel García Márquez");

        DataAutor autor2 = new DataAutor();
        autor2.setIdAutor("A002");
        autor2.setNomAutor("Isabel Allende");

        DataAutor autor3 = new DataAutor();
        autor3.setIdAutor("A003");
        autor3.setNomAutor("Jorge Luis Borges");

        listaAutores.add(autor1);
        listaAutores.add(autor2);
        listaAutores.add(autor3);

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.rvAutores.setLayoutManager(layoutManager);
        adaptadorAutor = new AdaptadorAutor(this, listaAutores, this);
        binding.rvAutores.setAdapter(adaptadorAutor);
    }

    private void alertDialogAddUpdate() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View vista = getLayoutInflater().inflate(com.example.bibliotk.R.layout.alert_dialog_add_update_autor, null);
        TextView tvTituloAlert = vista.findViewById(com.example.bibliotk.R.id.tvTituloAlert);
        EditText etIdAutor = vista.findViewById(com.example.bibliotk.R.id.etIdAutor);
        EditText etNomAutor = vista.findViewById(com.example.bibliotk.R.id.etNomAutor);

        if (isEditado) {
            tvTituloAlert.setText("ACTUALIZAR AUTOR");
            etIdAutor.setText(autor.getIdAutor());
            etIdAutor.setEnabled(false);
            etNomAutor.setText(autor.getNomAutor());
        }

        builder.setView(vista);
        builder.setPositiveButton("Aceptar", (dialogInterface, i) -> {
            if (etIdAutor.getText().toString().trim().isEmpty() ||
                    etNomAutor.getText().toString().trim().isEmpty()) {
                Toasty.error(this, "Se deben llenar los campos obligatorios", Toasty.LENGTH_SHORT).show();
                return;
            }

            autor.setIdAutor(etIdAutor.getText().toString().trim());
            autor.setNomAutor(etNomAutor.getText().toString().trim());

            if (isEditado) {
                for (int j = 0; j < listaAutores.size(); j++) {
                    if (listaAutores.get(j).getIdAutor().equals(autor.getIdAutor())) {
                        listaAutores.set(j, autor);
                        break;
                    }
                }
            } else {
                listaAutores.add(autor);
            }

            isEditado = false;
            autor = new DataAutor();
            setupRecyclerView();
        });

        builder.setNegativeButton("Cancelar", null);
        builder.setCancelable(false);
        builder.show();
    }

    @Override
    public void editarAutor(DataAutor autor) {
        isEditado = true;
        this.autor = autor;
        alertDialogAddUpdate();
    }

    @Override
    public void borrarAutor(DataAutor autor) {
        listaAutores.remove(autor);
        setupRecyclerView();
    }
}
