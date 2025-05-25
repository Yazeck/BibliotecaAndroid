package com.example.bibliotk.view.categoriasview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bibliotk.R;
import com.example.bibliotk.response.DataCategoria;

import java.util.List;

public class AdaptadorCategoria extends RecyclerView.Adapter<AdaptadorCategoria.ViewHolder> {

    Context context;
    List<DataCategoria> listaCategorias;
    AdaptadorCategoria.OnItemClicked onClick;

    public interface OnItemClicked {
        void editarCategoria(DataCategoria categoria);
        void borrarCategoria(DataCategoria categoria);
    }

    public AdaptadorCategoria(Context context, List<DataCategoria> listaCategorias, OnItemClicked onClick) {
        this.context = context;
        this.listaCategorias = listaCategorias;
        this.onClick = onClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_categorias, parent, false);
        return new ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataCategoria categoria = listaCategorias.get(position);

        holder.tvNomCategoria.setText(categoria.getNomcategoria());
        holder.tvIdCategoria.setText(categoria.getIdcategoria());

        holder.ibtnEditar.setOnClickListener(v -> onClick.editarCategoria(categoria));
        holder.ibtnBorrar.setOnClickListener(v -> onClick.borrarCategoria(categoria));
    }

    @Override
    public int getItemCount() {
        return listaCategorias.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvIdCategoria, tvNomCategoria;
        ImageButton ibtnEditar, ibtnBorrar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvIdCategoria = itemView.findViewById(R.id.tvIdCategoria);
            tvNomCategoria = itemView.findViewById(R.id.tvNomCategoria);
            ibtnEditar = itemView.findViewById(R.id.ibtnEditar);
            ibtnBorrar = itemView.findViewById(R.id.ibtnBorrar);
        }
    }
}
