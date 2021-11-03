package com.kevin.walkyourpet.ui.paseadores;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.kevin.walkyourpet.PaseadoresFavoritos;
import com.kevin.walkyourpet.PerfilPaseador;
import com.kevin.walkyourpet.databinding.FragmentPaseadoresBinding;

public class PaseadoresFragment extends Fragment {

    ImageView imagen;

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

    private void initComponents(){
        imagen = binding.imagen;
        fabPaseadoresFavoritos= binding.fabPaseadoresFavoritos;

    }
    private void iniciarPerfilPaseador(){
        Intent intent = new Intent(getActivity().getApplicationContext(), PerfilPaseador.class);
        startActivity(intent);
    }

    private void iniciarPaseadoresFavoritos(){
        Intent intent = new Intent(getActivity().getApplicationContext(), PaseadoresFavoritos.class);
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}