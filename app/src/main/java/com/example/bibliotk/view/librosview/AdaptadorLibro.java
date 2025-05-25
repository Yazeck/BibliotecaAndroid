package com.example.bibliotk.view.librosview;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bibliotk.R;
import com.example.bibliotk.response.DataLibro;

import java.util.List;

public class AdaptadorLibro extends RecyclerView.Adapter<AdaptadorLibro.ViewHolder> {

    Context context;
    List<DataLibro> listaLibros;
    AdaptadorLibro.OnItemClicked onClick;

    public AdaptadorLibro(Context context, List<DataLibro> listaLibros, AdaptadorLibro.OnItemClicked onClick) {
        this.context = context;
        this.listaLibros = listaLibros;
        this.onClick = onClick;
    }

    public interface OnItemClicked {
        void onItemClicked(DataLibro libro);
        void borrarLibro(DataLibro libro);
    }

    @NonNull
    @Override
    public AdaptadorLibro.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_libros, parent, false);
        return new ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorLibro.ViewHolder holder, int position) {
        DataLibro libro = listaLibros.get(position);

        holder.tvNomLibro.setText(libro.getNomLibro());
        holder.tvAutor.setText(libro.getAutor());

        holder.ibtnEditar.setOnClickListener(view -> onClick.onItemClicked(libro));
        holder.ibtnBorrar.setOnClickListener(view -> onClick.borrarLibro(libro));
    }

    @Override
    public int getItemCount() {
        return listaLibros.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNomLibro, tvAutor;
        ImageButton ibtnEditar, ibtnBorrar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNomLibro = itemView.findViewById(R.id.tvNomLibro);
            tvAutor = itemView.findViewById(R.id.tvAutor);
            ibtnEditar = itemView.findViewById(R.id.ibtnEditar);
            ibtnBorrar = itemView.findViewById(R.id.ibtnBorrar);

        }
    }
}
