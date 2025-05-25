package com.example.bibliotk.view.librosview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
import com.example.bibliotk.databinding.ActivityLibrosScreenBinding;
import com.example.bibliotk.response.DataLibro;

import java.util.ArrayList;
import java.util.List;
public class LibrosScreenActivity extends AppCompatActivity implements AdaptadorLibro.OnItemClicked  {

    private ActivityLibrosScreenBinding binding;
    AdaptadorLibro adaptadorLibro;
    List<DataLibro> listaLibros = new ArrayList<>();
    boolean isEditado = false;
    DataLibro libro = new DataLibro();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLibrosScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        cargarLibrosSimulados();

        binding.ibtnLibroAdd.setOnClickListener(v -> {
            libro = new DataLibro();
            isEditado = false;
            alertDialogAddUpdate();
        });
    }

    private void cargarLibrosSimulados() {
        DataLibro l1 = new DataLibro();
        l1.setIsbn("L001");
        l1.setNomLibro("Cien años de soledad");
        l1.setAutor("Gabriel García Márquez");
        l1.setNomeditorial("Planeta");

        DataLibro l2 = new DataLibro();
        l2.setIsbn("L002");
        l2.setNomLibro("La sombra del viento");
        l2.setAutor("Carlos Ruiz Zafón");
        l2.setNomeditorial("Penguin Random House");

        DataLibro l3 = new DataLibro();
        l3.setIsbn("L003");
        l3.setNomLibro("El Principito");
        l3.setAutor("Antoine de Saint-Exupéry");
        l3.setNomeditorial("Alfaguara");

        DataLibro l4 = new DataLibro();
        l4.setIsbn("L004");
        l4.setNomLibro("Rayuela");
        l4.setAutor("Julio Cortázar");
        l4.setNomeditorial("Fondo de Cultura Económica");

        listaLibros.add(l1);
        listaLibros.add(l2);
        listaLibros.add(l3);
        listaLibros.add(l4);

        adaptadorLibro = new AdaptadorLibro(this, listaLibros, this);
        binding.rvLibros.setLayoutManager(new LinearLayoutManager(this));
        binding.rvLibros.setAdapter(adaptadorLibro);
    }

    private void alertDialogAddUpdate() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.alert_dialog_add_update_libro, null);
        builder.setView(view);
        AlertDialog dialog = builder.create();
        dialog.show();

        EditText etIsbn = view.findViewById(R.id.etIsbn);
        EditText etTitulo = view.findViewById(R.id.etNomLibro);
        EditText etAutor = view.findViewById(R.id.etAutor);
        EditText etEditorial = view.findViewById(R.id.etEditorial);
        TextView tvTitulo = view.findViewById(R.id.tvTituloAlert);
        TextView tvBtnGuardar = view.findViewById(R.id.tvBtnGuardar);

        if (isEditado) {
            tvTitulo.setText("EDITAR LIBRO");
            etIsbn.setText(libro.getIsbn());
            etTitulo.setText(libro.getNomLibro());
            etAutor.setText(libro.getAutor());
            etEditorial.setText(libro.getNomeditorial());
        }

        tvBtnGuardar.setOnClickListener(v -> {
            libro.setIsbn(etIsbn.getText().toString());
            libro.setNomLibro(etTitulo.getText().toString());
            libro.setAutor(etAutor.getText().toString());
            libro.setNomeditorial(etEditorial.getText().toString());

            if (!isEditado) {
                listaLibros.add(libro);
            }

            adaptadorLibro.notifyDataSetChanged();
            dialog.dismiss();
        });
    }

    @Override
    public void onItemClicked(DataLibro libro) {
        this.libro = libro;
        isEditado = true;
        alertDialogAddUpdate();
    }

    @Override
    public void borrarLibro(DataLibro libro) {
        listaLibros.remove(libro);
        adaptadorLibro.notifyDataSetChanged();
    }
}