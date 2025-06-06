package com.example.bibliotk.view.usuariosview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bibliotk.R;
import com.example.bibliotk.response.DataAdminUsuario;
import com.example.bibliotk.response.DataUsuario;

import java.util.List;

public class AdaptadorUsuario extends RecyclerView.Adapter<AdaptadorUsuario.ViewHolder> {
    Context context;
    List<DataUsuario> listaUsuarios;
    OnItemClicked onClick;


    public AdaptadorUsuario( Context context,
                             List<DataUsuario> listaUsuarios,
                             OnItemClicked onClick) {
        this.context=context;
        this.listaUsuarios=listaUsuarios;
        this.onClick=onClick;
    }



    @NonNull
    @Override
    public AdaptadorUsuario.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista= LayoutInflater.from(parent.getContext()).inflate(R.layout.
                item_rv_usuarios, parent,false);
        return new ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorUsuario.ViewHolder holder, int position) {
        DataUsuario usuario = listaUsuarios.get(position);
        if(usuario.getEstado_Usuario()==null){
            holder.cvUsuario.setCardBackgroundColor(context.getResources()
                    .getColor(R.color.verde_oscuro));
        }else {
            holder.cvUsuario.setCardBackgroundColor(context.getResources()
                    .getColor(R.color.verde_oscuro));
        }
        holder.tvNomUsuario.setText(usuario.getNomusuario());
        holder.ibtnEditar.setOnClickListener(view->{
           onClick.editarUsuario(usuario);
        });
        holder.ibtnBorrar.setOnClickListener(view->{
            onClick.borrarUsuario(usuario);
        });
    }

    @Override
    public int getItemCount() {
        return listaUsuarios.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cvUsuario;
        TextView tvNomUsuario;
        ImageButton ibtnEditar, ibtnBorrar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cvUsuario=itemView.findViewById(R.id.cvUsuario);
            tvNomUsuario=itemView.findViewById(R.id.tvNomUsuario);
            ibtnEditar=itemView.findViewById(R.id.ibtnEditar);
            ibtnBorrar=itemView.findViewById(R.id.ibtnEliminar);
            
        }
    }
    public interface OnItemClicked{
        void editarUsuario(DataUsuario usuario);
        void borrarUsuario(DataUsuario usuario);
    }

}
