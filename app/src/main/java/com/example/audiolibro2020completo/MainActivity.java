package com.example.audiolibro2020completo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import Entidades.Libro;
import fragments.DetalleLibro;
import fragments.fragment_libros;

public class MainActivity extends AppCompatActivity implements IComunicaFragments {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    DetalleLibro detalleLibro;

    Libro libro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.contenedor, new fragment_libros()).commit();
    }

    @Override
    public void enviarLibro(Libro libro) {
        detalleLibro=new DetalleLibro();
        Bundle bundlenvio=new Bundle();
        bundlenvio.putSerializable("objeto",libro);
        detalleLibro.setArguments(bundlenvio);
        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.contenedor, detalleLibro).commit();

    }
}