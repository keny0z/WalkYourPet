package com.kevin.walkyourpet.ui.mascotas;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kevin.walkyourpet.R;
import com.kevin.walkyourpet.RegistroMascota;
import com.kevin.walkyourpet.databinding.FragmentMascotaBinding;
import com.kevin.walkyourpet.entities.Mascota;
import com.kevin.walkyourpet.recyclerview.adapter.RecyclerAdapterMascota;
import com.kevin.walkyourpet.sesion.SesionUsuario;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MascotaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MascotaFragment extends Fragment {

    private RecyclerView rvMascotas;
    private RecyclerAdapterMascota adapter;
    private ArrayList<Mascota> mascotas;
    com.google.android.material.floatingactionbutton.FloatingActionButton fabPaseadoresFavoritos;

    private FragmentMascotaBinding binding;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MascotaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MascotaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MascotaFragment newInstance(String param1, String param2) {
        MascotaFragment fragment = new MascotaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    private void initComponents(){
        fabPaseadoresFavoritos = binding.fabPaseadoresFavoritos;
        rvMascotas = binding.rvMascotas;

    }

    private void iniciarRegistroMascota(){
        Intent intent = new Intent(getActivity().getApplicationContext(), RegistroMascota.class);
        startActivity(intent);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMascotaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        initComponents();
        LinearLayoutManager manager = new LinearLayoutManager(getActivity().getApplicationContext());
        rvMascotas.setLayoutManager(manager);
        mascotas= SesionUsuario.obtenerInstancia().getMascotas();

        /*
        //provicional
        Mascota mascotaProvicional = new Mascota();
        mascotaProvicional.setId(55);
        mascotaProvicional.setNombre("perry");
        mascotaProvicional.setRaza("pomerania");
        mascotaProvicional.setPeso("5");
        mascotaProvicional.setFechaNacimiento("2011");
        mascotaProvicional.setImagen(R.drawable.perro);
        mascotas.add(mascotaProvicional);
        //fin provicional
         */

        adapter= new RecyclerAdapterMascota(mascotas);
        rvMascotas.setAdapter(adapter);


        fabPaseadoresFavoritos.setOnClickListener(v -> {
            iniciarRegistroMascota();
        });


        // Inflate the layout for this fragment
        return root;

    }


}