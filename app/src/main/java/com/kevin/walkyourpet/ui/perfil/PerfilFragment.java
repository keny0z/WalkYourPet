package com.kevin.walkyourpet.ui.perfil;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.kevin.walkyourpet.MainActivity;
import com.kevin.walkyourpet.databinding.FragmentPerfilBinding;
import com.kevin.walkyourpet.sesion.SesionUsuario;

public class PerfilFragment extends Fragment {

    private PerfilViewModel perfilViewModel;
    private FragmentPerfilBinding binding;

    Button btnEditar;
    TextView tvSalir;
    TextView tvNombre;
    TextView tvCelular;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        perfilViewModel =
                new ViewModelProvider(this).get(PerfilViewModel.class);

        binding = FragmentPerfilBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        initComponents();
        tvNombre.setText(SesionUsuario.obtenerInstancia().getNombre());
        tvCelular.setText(SesionUsuario.obtenerInstancia().getCelular());

        tvSalir.setOnClickListener(v -> {
            iniciarLogin();
        });



        //final TextView textView = binding.textNotifications;
        /*
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        *
         */
        return root;
    }

    private void initComponents(){
        btnEditar = binding.btnEditar;
        tvSalir= binding.tvSalir;
        tvNombre = binding.tvNombre;
        tvCelular = binding.tvCelular;
    }

    private void iniciarLogin(){
        Intent intent = new Intent(getActivity().getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}