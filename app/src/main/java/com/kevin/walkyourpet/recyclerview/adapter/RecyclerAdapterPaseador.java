package com.kevin.walkyourpet.recyclerview.adapter;

import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kevin.walkyourpet.PerfilPaseador;
import com.kevin.walkyourpet.R;
import com.kevin.walkyourpet.entities.Paseador;
import com.kevin.walkyourpet.gps.Distancia;
import com.kevin.walkyourpet.sesion.CoordenadasUsuario;
import com.kevin.walkyourpet.sesion.SesionUsuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RecyclerAdapterPaseador extends RecyclerView.Adapter<RecyclerAdapterPaseador.RecyclerHolder>{
    private List<Paseador> paseadores;
    private List<Paseador> originalItems;
    private RecyclerAdapterPaseador.RecyclerItemClick itemClick;

    public RecyclerAdapterPaseador(List<Paseador> paseadores, RecyclerAdapterPaseador.RecyclerItemClick itemClick) {
        this.paseadores = paseadores;
        this.itemClick = itemClick;
        this.originalItems = new ArrayList<>();
        originalItems.addAll(paseadores);
    }
    public RecyclerAdapterPaseador(List<Paseador> paseadores) {
        this.paseadores = paseadores;
    }
    @NonNull
    @Override
    public RecyclerAdapterPaseador.RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_paseador, parent, false);
        return new RecyclerAdapterPaseador.RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerAdapterPaseador.RecyclerHolder holder, final int position) {
        final Paseador item = paseadores.get(position);
        holder.imagenPaseador.setImageResource(item.getImagen());
        holder.tvNombrePaseador.setText(item.getNombre());






        holder.tvDistancia.setText(String.valueOf(Distancia.distanciaCoord(CoordenadasUsuario.obtenerInstancia().getLatitud(), CoordenadasUsuario.obtenerInstancia().getLongitud(), item.getLatitud(),item.getLongitud()))+" km");



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick.itemClick(item);
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), PerfilPaseador.class);
                //intent.putExtra("itemDetail", item);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return paseadores.size();
    }

    public void filter(final String strSearch) {
        if (strSearch.length() == 0) {
            paseadores.clear();
            paseadores.addAll(originalItems);
        }
        else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                paseadores.clear();
                List<Paseador> collect = originalItems.stream()
                        .filter(i -> i.getNombre().toLowerCase().contains(strSearch))
                        .collect(Collectors.toList());

                paseadores.addAll(collect);
            }
            else {
                paseadores.clear();
                for (Paseador i : originalItems) {
                    if (i.getNombre().toLowerCase().contains(strSearch)) {
                        paseadores.add(i);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }


    public class RecyclerHolder extends RecyclerView.ViewHolder {
        private ImageView imagenPaseador;
        private TextView tvNombrePaseador;
        private TextView tvDistancia;



        public RecyclerHolder(@NonNull View itemView_1) {
            super(itemView_1);

            imagenPaseador = itemView.findViewById(R.id.imagenPaseador);
            tvNombrePaseador = itemView.findViewById(R.id.tvNombrePaseador);
            tvDistancia = itemView.findViewById(R.id.tvDistancia);

        }
    }

    public interface RecyclerItemClick {
        void itemClick(Paseador item);
    }
}
