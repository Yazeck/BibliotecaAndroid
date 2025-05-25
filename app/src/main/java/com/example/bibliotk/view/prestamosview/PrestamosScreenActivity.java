package com.example.bibliotk.view.prestamosview;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.bibliotk.R;
import com.example.bibliotk.databinding.ActivityPrestamosScreenBinding;
import com.example.bibliotk.response.DataPrestamo;

import java.util.ArrayList;
import java.util.List;

public class PrestamosScreenActivity extends AppCompatActivity implements AdaptadorPrestamo.OnItemClicked {

    private ActivityPrestamosScreenBinding binding;
    AdaptadorPrestamo adaptadorPrestamo;
    List<DataPrestamo> listaPrestamos = new ArrayList<>();
    boolean isEditado = false;
    DataPrestamo prestamo = new DataPrestamo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPrestamosScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        cargarPrestamosSimulados();

        binding.ibtnPrestamoAdd.setOnClickListener(v -> {
            prestamo = new DataPrestamo();
            isEditado = false;
            alertDialogAddUpdate();
        });
    }

    private void cargarPrestamosSimulados() {
        DataPrestamo p1 = new DataPrestamo("PR001", "Erick Nungaray", "Cien años de soledad", "2025-05-01", "2025-05-15", "Activo");
        DataPrestamo p2 = new DataPrestamo("PR002", "Lucía Martínez", "Rayuela", "2025-05-02", "2025-05-16", "Devuelto");
        DataPrestamo p3 = new DataPrestamo("PR003", "Luis Torres", "El Principito", "2025-05-03", "2025-05-17", "Activo");
        DataPrestamo p4 = new DataPrestamo("PR004", "Monse Álvarez", "La sombra del viento", "2025-05-04", "2025-05-18", "Devuelto");

        listaPrestamos.add(p1);
        listaPrestamos.add(p2);
        listaPrestamos.add(p3);
        listaPrestamos.add(p4);

        adaptadorPrestamo = new AdaptadorPrestamo(this, listaPrestamos, this);
        binding.rvPrestamos.setLayoutManager(new LinearLayoutManager(this));
        binding.rvPrestamos.setAdapter(adaptadorPrestamo);
    }

    private void alertDialogAddUpdate() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.alert_dialog_add_update_prestamo, null);
        builder.setView(view);
        AlertDialog dialog = builder.create();
        dialog.show();

        EditText etId = view.findViewById(R.id.etIdPrestamo);
        EditText etUsuario = view.findViewById(R.id.etUsuario);
        EditText etLibro = view.findViewById(R.id.etLibro);
        EditText etFechaPrestamo = view.findViewById(R.id.etFechaPrestamo);
        EditText etFechaEntrega = view.findViewById(R.id.etFechaEntrega);
        EditText etEstatus = view.findViewById(R.id.etEstatus);
        TextView tvTitulo = view.findViewById(R.id.tvTituloAlert);
        TextView tvBtnGuardar = view.findViewById(R.id.tvBtnGuardar);

        if (isEditado) {
            tvTitulo.setText("EDITAR PRÉSTAMO");
            etId.setText(prestamo.getIdprestamo());
            etUsuario.setText(prestamo.getUsuario());
            etLibro.setText(prestamo.getLibro());
            etFechaPrestamo.setText(prestamo.getFechaPrestamo());
            etFechaEntrega.setText(prestamo.getFechaEntrega());
            etEstatus.setText(prestamo.getEstatus());
        }

        tvBtnGuardar.setOnClickListener(v -> {
            prestamo.setIdprestamo(etId.getText().toString());
            prestamo.setUsuario(etUsuario.getText().toString());
            prestamo.setLibro(etLibro.getText().toString());
            prestamo.setFechaPrestamo(etFechaPrestamo.getText().toString());
            prestamo.setFechaEntrega(etFechaEntrega.getText().toString());
            prestamo.setEstatus(etEstatus.getText().toString());

            if (!isEditado) {
                listaPrestamos.add(prestamo);
            }

            adaptadorPrestamo.notifyDataSetChanged();
            dialog.dismiss();
        });
    }

    @Override
    public void editarPrestamo(DataPrestamo prestamo) {
        this.prestamo = prestamo;
        isEditado = true;
        alertDialogAddUpdate();
    }

    @Override
    public void borrarPrestamo(DataPrestamo prestamo) {
        listaPrestamos.remove(prestamo);
        adaptadorPrestamo.notifyDataSetChanged();
    }
}
