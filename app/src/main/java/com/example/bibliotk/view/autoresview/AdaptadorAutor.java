package com.example.bibliotk.view.autoresview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bibliotk.R;
import com.example.bibliotk.response.DataAutor;
import com.example.bibliotk.view.usuariosview.AdaptadorUsuario;


import java.util.List;

public class AdaptadorAutor extends RecyclerView.Adapter<AdaptadorAutor.ViewHolder>{

    Context context;
    List<DataAutor> listaAutor;
    OnItemClicked onClick;

    public AdaptadorAutor( Context context,
                             List<DataAutor> listaAutor,
                             AdaptadorAutor.OnItemClicked onClick) {
        this.context=context;
        this.listaAutor=listaAutor;
        this.onClick=onClick;
    }

    @NonNull
    @Override
    public AdaptadorAutor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vista=
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.
                item_rv_autores, parent,false);

        return new AdaptadorAutor.ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorAutor.ViewHolder holder, int position) {
        DataAutor autor=listaAutor.get(position);
        holder.tvNomAutor.setText(autor.getNomAutor().toUpperCase());
        holder.ibtnEditar.setOnClickListener(view->{
            onClick.editarAutor(autor);
        });
        holder.ibtnBorrar.setOnClickListener(view-> {
            onClick.borrarAutor(autor);
        });
    }

    @Override
    public int getItemCount() {
        return listaAutor.size();
    }

    public interface OnItemClicked {
        void editarAutor(DataAutor autor);

        void borrarAutor(DataAutor autor);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNomAutor;
        ImageButton ibtnEditar, ibtnBorrar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNomAutor=itemView.findViewById(R.id.tvNomAutor);
            ibtnEditar=itemView.findViewById(R.id.ibtnEditar);
            ibtnBorrar=itemView.findViewById(R.id.ibtnEliminar);
        }
    }
}
