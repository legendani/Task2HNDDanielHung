package com.example.alumnodanielhung.task2hnddanielhung.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alumnodanielhung.task2hnddanielhung.Preferencias;
import com.example.alumnodanielhung.task2hnddanielhung.R;
import com.example.alumnodanielhung.task2hnddanielhung.beans.UsuarioBean;

public class PerfilFragment extends Fragment {

    private TextView txtusuariofragment, txtNombrefragment, txtApellidosfragment, txtEmailfragment;
    private ImageView imgPerfil;
    private Button btnEditar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_perfil, container, false);

        txtNombrefragment = (TextView) rootView.findViewById(R.id.txtNombrefragment);
        txtApellidosfragment = (TextView) rootView.findViewById(R.id.txtApellidosfragment);
        txtusuariofragment = (TextView) rootView.findViewById(R.id.txtusuariofragment);
        txtEmailfragment = (TextView) rootView.findViewById(R.id.txtEmailfragment);

        imgPerfil = (ImageView) rootView.findViewById(R.id.imgPerfil);

        btnEditar = (Button) rootView.findViewById(R.id.btnEditar);

        Preferencias preferencias = new Preferencias(getActivity());
        UsuarioBean usuarioBean = preferencias.getUsuario();

        txtNombrefragment.setText("Nombre: " + usuarioBean.getNombre());
        txtApellidosfragment.setText("Apellidos: " + usuarioBean.getApellidos());
        txtusuariofragment.setText("Usuario: " + usuarioBean.getUser());
        txtEmailfragment.setText("Email: " + usuarioBean.getEmail());
        
        return rootView;
    }

    public static PerfilFragment newInstance() {
        return new PerfilFragment();
    }
}
