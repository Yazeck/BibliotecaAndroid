package com.example.bibliotk.view.editorialesview;

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
import com.example.bibliotk.response.DataEditorial;
import com.example.bibliotk.view.autoresview.AdaptadorAutor;

import java.util.List;


public class AdaptadorEditorial extends RecyclerView.Adapter<AdaptadorEditorial.ViewHolder>{

    Context context;
    List<DataEditorial> listaEditorial;
    AdaptadorEditorial.OnItemClicked onClick;

    public AdaptadorEditorial( Context context,
                           List<DataEditorial> listaEditorial,
                           AdaptadorEditorial.OnItemClicked onClick) {
        this.context=context;
        this.listaEditorial=listaEditorial;
        this.onClick=onClick;
    }

    @NonNull
    @Override
    public AdaptadorEditorial.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista=
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.
                                item_rv_editoriales, parent,false);

        return new AdaptadorEditorial.ViewHolder(vista);

    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorEditorial.ViewHolder holder, int position) {
        DataEditorial editorial=listaEditorial.get(position);
        holder.tvNomEditorial.setText(editorial.getNomEditorial().toUpperCase());
        holder.ibtnEditar.setOnClickListener(view->{
            onClick.editarEditorial(editorial);
        });
        holder.ibtnBorrar.setOnClickListener(view-> {
            onClick.borrarEditorial(editorial);
        });
    }

    @Override
    public int getItemCount() {
        return listaEditorial.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNomEditorial;
        ImageButton ibtnEditar, ibtnBorrar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNomEditorial=itemView.findViewById(R.id.tvNomEditorial);
            ibtnEditar=itemView.findViewById(R.id.ibtnEditar);
            ibtnBorrar=itemView.findViewById(R.id.ibtnEliminar);
        }
    }

    public interface OnItemClicked {
        void editarEditorial(DataEditorial Editorial);

        void borrarEditorial(DataEditorial Editorial);
    }
}
