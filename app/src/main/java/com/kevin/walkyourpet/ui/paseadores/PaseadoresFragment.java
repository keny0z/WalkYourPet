package com.kevin.walkyourpet.ui.paseadores;

import static androidx.core.content.ContextCompat.getSystemService;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.kevin.walkyourpet.PaseadoresFavoritos;
import com.kevin.walkyourpet.PerfilPaseador;
import com.kevin.walkyourpet.databinding.FragmentPaseadoresBinding;



import java.util.List;


public class PaseadoresFragment extends Fragment {

    //private LocationManager ubicacion;


    ImageView imagen;

    //provicional
    TextView latitud;
    TextView longitud;
    //fin provicional

    com.google.android.material.floatingactionbutton.FloatingActionButton fabPaseadoresFavoritos;

    private PaseadoresViewModel paseadoresViewModel;
    private FragmentPaseadoresBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        paseadoresViewModel =
                new ViewModelProvider(this).get(PaseadoresViewModel.class);

        binding = FragmentPaseadoresBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        initComponents();
        //localizacion();


        //provicional
        latitud = binding.lat;
        longitud = binding.lon;

        //fin provicional

        imagen.setOnClickListener(v -> {
            iniciarPerfilPaseador();
        });

        fabPaseadoresFavoritos.setOnClickListener(v -> {
            iniciarPaseadoresFavoritos();
        });

        //final TextView textView = binding.textHome;
        /*
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

         */
        return root;
    }

    private void initComponents() {
        imagen = binding.imagen;
        fabPaseadoresFavoritos = binding.fabPaseadoresFavoritos;

    }

    private void iniciarPerfilPaseador() {
        Intent intent = new Intent(getActivity().getApplicationContext(), PerfilPaseador.class);
        startActivity(intent);
    }

    private void iniciarPaseadoresFavoritos() {
        Intent intent = new Intent(getActivity().getApplicationContext(), PaseadoresFavoritos.class);
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    /*
    private void localizacion() {
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(),new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION
            }, 1000);
        }
        ubicacion = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        Location localizacion = ubicacion.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if(ubicacion != null){
            Log.d("Latitud",String.valueOf(localizacion.getLatitude()));
            Log.d("Longitud",String.valueOf(localizacion.getLongitude()));
        }
    }

     */







}