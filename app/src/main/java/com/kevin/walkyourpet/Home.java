package com.kevin.walkyourpet;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.kevin.walkyourpet.databinding.ActivityHomeBinding;
import com.kevin.walkyourpet.sesion.SesionUsuario;

import java.util.List;

public class Home extends AppCompatActivity {

    private LocationManager ubicacion;

    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        //localizacion();
        //registrarLocalizacion();



        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_buscar_paseadores, R.id.navigation_chat, R.id.navigation_perfil, R.id.navegation_mascota)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_home);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    private void localizacion() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION
            }, 1000);
        }
        ubicacion = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location localizacion = ubicacion.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (localizacion != null) {
            Log.d("Latitud", String.valueOf(localizacion.getLatitude()));
            Log.d("Longitud", String.valueOf(localizacion.getLongitude()));

            SesionUsuario.obtenerInstancia().setLatitud(localizacion.getLatitude());
            SesionUsuario.obtenerInstancia().setLongitud(localizacion.getLongitude());
        } else {
            ubicacion.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 0, new milocalizacionListener());

        }
    }

    //metodo que lista los diferentes metodos disponibles para obtener las coordenadas
    private void listaProviders() {
        ubicacion = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        List<String> listaProvider = ubicacion.getAllProviders();

        String mejorProvider = ubicacion.getBestProvider(obtenerMejorCriterio(), false);
        System.out.println(mejorProvider);

        LocationProvider provider = ubicacion.getProvider(listaProvider.get(0));
        System.out.println(provider.getAccuracy());
        System.out.println(provider.getPowerRequirement());
        System.out.println(provider.supportsAltitude());
    }

    //metodo para determinar cual es la mejor opcion posible para obtener las coordenadas
    //mejorProvider: "gps"
    private Criteria obtenerMejorCriterio() {
        Criteria requerimiento = new Criteria();
        requerimiento.setAccuracy(Criteria.ACCURACY_FINE);
        requerimiento.setAltitudeRequired(true);
        return requerimiento;
    }

    private void registrarLocalizacion() {
        ubicacion = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        ubicacion.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 0, new milocalizacionListener());
    }

    private class milocalizacionListener implements LocationListener{

        @Override
        public void onLocationChanged(@NonNull Location location) {
            Log.d("Latitud", String.valueOf(location.getLatitude()));
            Log.d("Longitud", String.valueOf(location.getLongitude()));

            SesionUsuario.obtenerInstancia().setLatitud(location.getLatitude());
            SesionUsuario.obtenerInstancia().setLongitud(location.getLongitude());
        }
    }

}