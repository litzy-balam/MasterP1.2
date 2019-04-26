package com.example.litzy.masterp;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.litzy.masterp.ModeloArticulo;

import java.util.List;
public class AdaptadorArticulos extends RecyclerView.Adapter<AdaptadorArticulos.ViewHolder> {
    private final List<ModeloArticulo.Articulo> valores;


    public AdaptadorArticulos(List<ModeloArticulo.Articulo> items,
                              AdapterView.OnItemClickListener escuchaClicksExterna) {
        valores = items;
        this.escuchaClicksExterna = (OnItemClickListener) escuchaClicksExterna;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista_articulos, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.item = valores.get(position);
        holder.viewTitulo.setText(valores.get(position).titulo);
        holder.viewResumen.setText(valores.get(position).descripcion);
        holder.viewFecha.setText(valores.get(position).fecha);
        Glide.with(holder.itemView.getContext())
                .load(holder.item.urlMiniatura)
                .thumbnail(0.1f)
                .centerCrop()
                .into(holder.viewMiniatura);

    }

    @Override
    public int getItemCount() {
            if (valores != null) {
                return valores.size() > 0 ? valores.size() : 0;
            } else {
                return 0;
            }
    }
    private String obtenerIdArticulo(int posicion) {
            if (posicion != RecyclerView.NO_POSITION) {
                return valores.get(posicion).id;
            } else {
                return null;
            }
        }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView viewTitulo;
        public final TextView viewResumen;
        public final TextView viewFecha;
        public final ImageView viewMiniatura;

        public ModeloArticulo.Articulo item;

        public ViewHolder(@NonNull View view) {
            super(view);
            view.setClickable(true);
            viewTitulo = (TextView) view.findViewById(R.id.titulo);
            viewResumen = (TextView) view.findViewById(R.id.resumen);
            viewFecha = (TextView) view.findViewById(R.id.fecha);
            viewMiniatura = (ImageView) view.findViewById(R.id.miniatura);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            escuchaClicksExterna.onClick(this, obtenerIdArticulo(getAdapterPosition()));
        }
    }
        public interface OnItemClickListener {
            public void onClick(ViewHolder viewHolder, String idArticulo);
        }
    private final OnItemClickListener escuchaClicksExterna;
}

