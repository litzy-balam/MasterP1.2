package com.example.litzy.masterp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.litzy.masterp.ModeloArticulo;

public class ActividadListaArticulos extends AppCompatActivity implements FragmentoListaArticulos.EscuchaFragmento{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_lista_articulos);
        ((Toolbar) findViewById(R.id.toolbar)).setTitle(getTitle());

        // Agregar fragmento de lista
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contenedor_lista, FragmentoListaArticulos.crear())
                .commit();
    }

    @Override
    public void alSeleccionarItem(String idArticulo) {

    }
}
