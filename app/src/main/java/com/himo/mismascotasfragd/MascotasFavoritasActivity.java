package com.himo.mismascotasfragd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.himo.mismascotasfragd.adapter.MascotaAdaptador;
import com.himo.mismascotasfragd.pojo.Mascota;
import com.himo.mismascotasfragd.pojo.MisMascotas;

import java.util.ArrayList;
import java.util.Collections;

public class MascotasFavoritasActivity extends AppCompatActivity {

    //CÓDIGO GENERADO POR HECTOR IVAN MORALES OVANDO

    ArrayList<Mascota> mascotasFavoritas;
    private RecyclerView rvMascotasFavoritas;
    Context contexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);
        contexto = this;

        Toolbar miToolBar = (Toolbar) findViewById(R.id.miToolBar);
        if (miToolBar != null) {
            setSupportActionBar(miToolBar);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //muestra la flecha de regreso (se declara el parent en AndroidManifest)

        Button button_favoritos = (Button) findViewById(R.id.btn_favoritos);
        button_favoritos.setVisibility(View.INVISIBLE);

        rvMascotasFavoritas = (RecyclerView) findViewById(R.id.rvMascotasFavoritas);
        LinearLayoutManager llm = new LinearLayoutManager(contexto);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotasFavoritas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();

        assert miToolBar != null;
        miToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { finish(); }
        });
    }

    public void inicializarListaMascotas() {
        MisMascotas Mm = new MisMascotas();
        mascotasFavoritas = Mm.misMascotas(15);

        Collections.sort(mascotasFavoritas);
        if (mascotasFavoritas.size() >= 6) { mascotasFavoritas.remove(6); }
        if (mascotasFavoritas.size() >= 5) { mascotasFavoritas.remove(5); }
    }

    public void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotasFavoritas, this);
        rvMascotasFavoritas.setAdapter(adaptador);
    }

}