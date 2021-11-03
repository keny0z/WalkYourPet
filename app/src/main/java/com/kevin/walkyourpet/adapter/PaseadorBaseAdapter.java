package com.kevin.walkyourpet.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.kevin.walkyourpet.R;
import com.kevin.walkyourpet.entities.Paseador;

import java.util.ArrayList;
import java.util.List;

public class PaseadorBaseAdapter extends BaseAdapter implements Filterable {

    private List<Paseador> listaPaseadoresIn;
    private List<Paseador> listaPaseadoresOut;
    private final LayoutInflater inflater;

    private List<Paseador> listaPaseadores;
    public PaseadorBaseAdapter(Context contexto, List<Paseador> listaPaseadores){

        this.listaPaseadoresOut= listaPaseadores;
        this.listaPaseadoresIn = listaPaseadores;
        inflater = LayoutInflater.from(contexto);

    }
    @Override
    public int getCount() {
        return listaPaseadores.size();
    }

    @Override
    public Paseador getItem(int position) {
        return listaPaseadores.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.fragment_paseadores, null);
            holder.imagen = convertView.findViewById(R.id.imagen);
            holder.nombre = convertView.findViewById(R.id.nombre);
            holder.edad = convertView.findViewById(R.id.edad);
            holder.distancia = convertView.findViewById(R.id.distancia);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.imagen.setImageResource(listaPaseadoresOut.get(position).getImagen());
        holder.nombre.setText(listaPaseadoresOut.get(position).getNombre());
        holder.distancia.setText(listaPaseadoresOut.get(position).getDistancia());
        return convertView;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                listaPaseadoresOut = (List<Paseador>) results.values;
                notifyDataSetChanged();
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                List<Paseador> FilteredArrList = new ArrayList<>();
                if (listaPaseadoresIn == null) {
                    listaPaseadoresIn = new ArrayList<>(listaPaseadoresOut);
                }
                if (constraint == null || constraint.length() == 0) {
                    results.count = listaPaseadoresIn.size();
                    results.values = listaPaseadoresIn;
                } else {

                    constraint = constraint.toString().toLowerCase();
                    for (int i = 0; i < listaPaseadoresIn.size(); i++) {
                        String data = listaPaseadoresIn.get(i).getNombre();
                        if (data.toLowerCase().contains(constraint.toString())) {
                            FilteredArrList.add(listaPaseadoresIn.get(i));
                        }
                    }
                    results.count = FilteredArrList.size();
                    results.values = FilteredArrList;
                }
                return results;
            }
        };
        return filter;
    }


    class ViewHolder{
        ImageView imagen;
        TextView nombre;
        TextView edad;
        TextView distancia;

    }
}
