package com.example.bibliotk.view.prestamosview;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bibliotk.R;
import com.example.bibliotk.response.DataPrestamo;

import java.util.List;

public class AdaptadorPrestamo extends RecyclerView.Adapter<AdaptadorPrestamo.ViewHolder> {

    Context context;
    List<DataPrestamo> listaPrestamos;
    AdaptadorPrestamo.OnItemClicked onClick;

    public interface OnItemClicked {
        void editarPrestamo(DataPrestamo prestamo);
        void borrarPrestamo(DataPrestamo prestamo);
    }

    public AdaptadorPrestamo(Context context, List<DataPrestamo> listaPrestamos, OnItemClicked onClick) {
        this.context = context;
        this.listaPrestamos = listaPrestamos;
        this.onClick = onClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_prestamos, parent, false);
        return new ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataPrestamo prestamo = listaPrestamos.get(position);

        holder.tvIdPrestamo.setText(prestamo.getIdprestamo());
        holder.tvUsuario.setText(prestamo.getUsuario());
        holder.tvLibro.setText(prestamo.getLibro());
        holder.tvFechaPrestamo.setText(prestamo.getFechaPrestamo());
        holder.tvFechaEntrega.setText(prestamo.getFechaEntrega());
        holder.tvEstatus.setText(prestamo.getEstatus());

        holder.ibtnEditar.setOnClickListener(v -> onClick.editarPrestamo(prestamo));
        holder.ibtnBorrar.setOnClickListener(v -> onClick.borrarPrestamo(prestamo));
    }

    @Override
    public int getItemCount() {
        return listaPrestamos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvIdPrestamo, tvUsuario, tvLibro, tvFechaPrestamo, tvFechaEntrega, tvEstatus;
        ImageButton ibtnEditar, ibtnBorrar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvIdPrestamo = itemView.findViewById(R.id.tvIdPrestamo);
            tvUsuario = itemView.findViewById(R.id.tvUsuario);
            tvLibro = itemView.findViewById(R.id.tvLibro);
            tvFechaPrestamo = itemView.findViewById(R.id.tvFechaPrestamo);
            tvFechaEntrega = itemView.findViewById(R.id.tvFechaEntrega);
            tvEstatus = itemView.findViewById(R.id.tvEstatus);
            ibtnEditar = itemView.findViewById(R.id.ibtnEditar);
            ibtnBorrar = itemView.findViewById(R.id.ibtnBorrar);
        }
    }
}
