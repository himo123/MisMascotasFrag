package com.himo.mismascotasfragd.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.himo.mismascotasfragd.R;
import com.himo.mismascotasfragd.adapter.MascotaAdaptador;
import com.himo.mismascotasfragd.adapter.PerfilAdaptador;
import com.himo.mismascotasfragd.pojo.Mascota;
import com.himo.mismascotasfragd.pojo.MisMascotas;

import java.util.ArrayList;
import java.util.Collections;

import static android.widget.Toast.LENGTH_SHORT;

public class PerfilFragment extends Fragment {

    //CÓDIGO GENERADO POR HECTOR IVAN MORALES OVANDO

    ArrayList<Mascota> unaMascota = new ArrayList<>();
    private RecyclerView rvPerfilMascota;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        rvPerfilMascota = v.findViewById(R.id.rvPerfilMascota);
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        rvPerfilMascota.setLayoutManager(glm);

//        inicializarListaMascotas();
//        inicializarAdaptador();

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        inicializarListaMascotas();
        inicializarAdaptador();
    }

    public void inicializarListaMascotas() {
        MisMascotas Mm = new MisMascotas();
        unaMascota = Mm.soloUnaMascota(100);

        Collections.sort(unaMascota);
    }

    public void inicializarAdaptador() {
        PerfilAdaptador adaptador = new PerfilAdaptador(unaMascota, getActivity());
        rvPerfilMascota.setAdapter(adaptador);
    }
}
