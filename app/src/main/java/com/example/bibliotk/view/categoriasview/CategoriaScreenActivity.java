package com.example.bibliotk.view.categoriasview;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.bibliotk.R;



import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.bibliotk.R;
import com.example.bibliotk.databinding.ActivityCategoriaScreenBinding;
import com.example.bibliotk.response.DataCategoria;

import java.util.ArrayList;
import java.util.List;

public class CategoriaScreenActivity extends AppCompatActivity implements AdaptadorCategoria.OnItemClicked {

    private ActivityCategoriaScreenBinding binding;
    AdaptadorCategoria adaptadorCategoria;
    List<DataCategoria> listaCategorias = new ArrayList<>();
    boolean isEditado = false;
    DataCategoria categoria = new DataCategoria();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoriaScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        cargarCategoriasSimuladas();

        binding.ibtnCategoriaAdd.setOnClickListener(v -> {
            categoria = new DataCategoria();
            isEditado = false;
            alertDialogAddUpdate();
        });
    }

    private void cargarCategoriasSimuladas() {
        DataCategoria c1 = new DataCategoria();
        c1.setIdcategoria("C001");
        c1.setNomcategoria("Novela");

        DataCategoria c2 = new DataCategoria();
        c2.setIdcategoria("C002");
        c2.setNomcategoria("Cuento");

        DataCategoria c3 = new DataCategoria();
        c3.setIdcategoria("C003");
        c3.setNomcategoria("Ciencia ficción");

        DataCategoria c4 = new DataCategoria();
        c4.setIdcategoria("C004");
        c4.setNomcategoria("Fantasía");

        listaCategorias.add(c1);
        listaCategorias.add(c2);
        listaCategorias.add(c3);
        listaCategorias.add(c4);

        adaptadorCategoria = new AdaptadorCategoria(this, listaCategorias, this);
        binding.rvCategorias.setLayoutManager(new LinearLayoutManager(this));
        binding.rvCategorias.setAdapter(adaptadorCategoria);
    }

    private void alertDialogAddUpdate() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.alert_dialog_add_update_categoria, null);
        builder.setView(view);
        AlertDialog dialog = builder.create();
        dialog.show();

        EditText etIdCategoria = view.findViewById(R.id.etIdCategoria);
        EditText etNomCategoria = view.findViewById(R.id.etNomCategoria);
        TextView tvTitulo = view.findViewById(R.id.tvTituloAlert);
        TextView tvBtnGuardar = view.findViewById(R.id.tvBtnGuardar);

        if (isEditado) {
            tvTitulo.setText("EDITAR CATEGORÍA");
            etIdCategoria.setText(categoria.getIdcategoria());
            etNomCategoria.setText(categoria.getNomcategoria());
        }

        tvBtnGuardar.setOnClickListener(v -> {
            categoria.setIdcategoria(etIdCategoria.getText().toString());
            categoria.setNomcategoria(etNomCategoria.getText().toString());

            if (!isEditado) {
                listaCategorias.add(categoria);
            }

            adaptadorCategoria.notifyDataSetChanged();
            dialog.dismiss();
        });
    }

    @Override
    public void editarCategoria(DataCategoria categoria) {
        this.categoria = categoria;
        isEditado = true;
        alertDialogAddUpdate();
    }

    @Override
    public void borrarCategoria(DataCategoria categoria) {
        listaCategorias.remove(categoria);
        adaptadorCategoria.notifyDataSetChanged();
    }
}

