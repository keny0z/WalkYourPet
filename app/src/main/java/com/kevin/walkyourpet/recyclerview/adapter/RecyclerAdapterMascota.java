package com.kevin.walkyourpet.recyclerview.adapter;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kevin.walkyourpet.R;
import com.kevin.walkyourpet.entities.Mascota;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class RecyclerAdapterMascota extends RecyclerView.Adapter<RecyclerAdapterMascota.RecyclerHolder> {
    private List<Mascota> mascotas;
    private List<Mascota> originalItems;
    private RecyclerItemClick itemClick;

    public RecyclerAdapterMascota(List<Mascota> mascotas, RecyclerItemClick itemClick) {
        this.mascotas = mascotas;
        this.itemClick = itemClick;
        this.originalItems = new ArrayList<>();
        originalItems.addAll(mascotas);
    }

    public RecyclerAdapterMascota(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mascota, parent, false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerHolder holder, final int position) {
        final Mascota item = mascotas.get(position);
        holder.imagen.setImageResource(item.getImagen());
        holder.tvNombre.setText(item.getNombre());
        holder.tvPeso.setText(item.getPeso());
        holder.tvRaza.setText(item.getRaza());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick.itemClick(item);
            }
        });

        /*holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
                intent.putExtra("itemDetail", item);
                holder.itemView.getContext().startActivity(intent);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public void filter(final String strSearch) {
        if (strSearch.length() == 0) {
            mascotas.clear();
            mascotas.addAll(originalItems);
        }
        else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                mascotas.clear();
                List<Mascota> collect = originalItems.stream()
                        .filter(i -> i.getNombre().toLowerCase().contains(strSearch))
                        .collect(Collectors.toList());

                mascotas.addAll(collect);
            }
            else {
                mascotas.clear();
                for (Mascota i : originalItems) {
                    if (i.getNombre().toLowerCase().contains(strSearch)) {
                        mascotas.add(i);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }


    public class RecyclerHolder extends RecyclerView.ViewHolder {
        private ImageView imagen;
        private TextView tvNombre;
        private TextView tvPeso;
        private TextView tvRaza;


        public RecyclerHolder(@NonNull View itemView_1) {
            super(itemView_1);

            imagen = itemView.findViewById(R.id.imagen);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvPeso = itemView.findViewById(R.id.tvPeso);
            tvRaza = itemView.findViewById(R.id.tvRaza);
        }
    }

    public interface RecyclerItemClick {
        void itemClick(Mascota item);
    }
}
