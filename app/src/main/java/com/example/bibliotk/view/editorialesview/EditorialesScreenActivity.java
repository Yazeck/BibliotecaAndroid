package com.example.bibliotk.view.editorialesview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bibliotk.R;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.bibliotk.R;
import com.example.bibliotk.databinding.ActivityEditorialesScreenBinding;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.bibliotk.databinding.ActivityEditorialesScreenBinding;
import com.example.bibliotk.response.DataEditorial;
import com.example.bibliotk.R;

import java.util.ArrayList;
import java.util.List;

public class EditorialesScreenActivity extends AppCompatActivity implements AdaptadorEditorial.OnItemClicked {

    private ActivityEditorialesScreenBinding binding;
    AdaptadorEditorial adaptadorEditorial;
    List<DataEditorial> listaEditoriales = new ArrayList<>();
    boolean isEditado = false;
    DataEditorial editorial = new DataEditorial();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditorialesScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        cargarEditorialesSimuladas();

        binding.ibtnEditorialAdd.setOnClickListener(v -> {
            editorial = new DataEditorial();
            isEditado = false;
            alertDialogAddUpdate();
        });
    }

    private void cargarEditorialesSimuladas() {
        DataEditorial e1 = new DataEditorial();
        e1.setIdEditorial("E001");
        e1.setNomEditorial("Alfaguara");

        DataEditorial e2 = new DataEditorial();
        e2.setIdEditorial("E002");
        e2.setNomEditorial("Planeta");

        DataEditorial e3 = new DataEditorial();
        e3.setIdEditorial("E003");
        e3.setNomEditorial("Penguin Random House");

        DataEditorial e4 = new DataEditorial();
        e4.setIdEditorial("E004");
        e4.setNomEditorial("Fondo de Cultura Económica");

        listaEditoriales.add(e1);
        listaEditoriales.add(e2);
        listaEditoriales.add(e3);
        listaEditoriales.add(e4);

        adaptadorEditorial = new AdaptadorEditorial(this, listaEditoriales, this);
        binding.rvEditoriales.setLayoutManager(new LinearLayoutManager(this));
        binding.rvEditoriales.setAdapter(adaptadorEditorial);
    }

    private void alertDialogAddUpdate() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.alert_dialog_add_update_editorial, null);
        builder.setView(view);
        AlertDialog dialog = builder.create();
        dialog.show();

        EditText etIdEditorial = view.findViewById(R.id.etIdEditorial);
        EditText etNomEditorial = view.findViewById(R.id.etNomEditorial);
        TextView tvTitulo = view.findViewById(R.id.tvTituloAlert);
        TextView tvBtnGuardar = view.findViewById(R.id.tvBtnGuardar);

        if (isEditado) {
            tvTitulo.setText("EDITAR EDITORIAL");
            etIdEditorial.setText(editorial.getIdEditorial());
            etNomEditorial.setText(editorial.getNomEditorial());
        }

        tvBtnGuardar.setOnClickListener(v -> {
            editorial.setIdEditorial(etIdEditorial.getText().toString());
            editorial.setNomEditorial(etNomEditorial.getText().toString());

            if (!isEditado) {
                listaEditoriales.add(editorial);
            }

            adaptadorEditorial.notifyDataSetChanged();
            dialog.dismiss();
        });
    }

    @Override
    public void editarEditorial(DataEditorial editorial) {
        this.editorial = editorial;
        isEditado = true;
        alertDialogAddUpdate();
    }

    @Override
    public void borrarEditorial(DataEditorial editorial) {
        listaEditoriales.remove(editorial);
        adaptadorEditorial.notifyDataSetChanged();
    }
}
