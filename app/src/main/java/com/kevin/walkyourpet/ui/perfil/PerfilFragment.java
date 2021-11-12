package com.kevin.walkyourpet.ui.perfil;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
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


    ImageView imagenUsuario;
    TextView tvUsuario;
    TextView tvNombre;
    TextView tvApellido;
    TextView tvCelular;
    Button btnEditar;
    TextView tvSalir;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        perfilViewModel =
                new ViewModelProvider(this).get(PerfilViewModel.class);

        binding = FragmentPerfilBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        initComponents();
        tvUsuario.setText(SesionUsuario.obtenerInstancia().getUsuario());
        tvNombre.setText("Nombre: "+SesionUsuario.obtenerInstancia().getNombre());
        tvApellido.setText("Apellido: "+SesionUsuario.obtenerInstancia().getApellido());
        tvCelular.setText("Celular: "+SesionUsuario.obtenerInstancia().getCelular());

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
        imagenUsuario = binding.imagenUsuario;
        tvUsuario = binding.tvUsuario;
        tvNombre= binding.tvNombre;
        tvApellido = binding.tvApellido;
        tvCelular = binding.tvCelular;
        btnEditar = binding.btnEditar;
        tvSalir = binding.tvSalir;
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