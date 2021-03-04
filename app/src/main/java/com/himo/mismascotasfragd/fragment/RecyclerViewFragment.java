package com.himo.mismascotasfragd.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.himo.mismascotasfragd.R;
import com.himo.mismascotasfragd.adapter.MascotaAdaptador;
import com.himo.mismascotasfragd.pojo.Mascota;
import com.himo.mismascotasfragd.pojo.MisMascotas;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {

    //CÓDIGO GENERADO POR HECTOR IVAN MORALES OVANDO

    ArrayList<Mascota> mascotas = new ArrayList<>();
    private RecyclerView rvMascotas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        rvMascotas = v.findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();

        return v;
    }

    public void inicializarListaMascotas() {
        //Inicializa el ArrayList con los datos de las mascotas
        MisMascotas Mm = new MisMascotas();
        mascotas = Mm.misMascotas();
    }

    public void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        rvMascotas.setAdapter(adaptador);
    }

}
