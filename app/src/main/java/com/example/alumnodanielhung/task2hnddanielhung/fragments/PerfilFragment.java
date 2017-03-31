package com.example.alumnodanielhung.task2hnddanielhung.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
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
import com.example.alumnodanielhung.task2hnddanielhung.activities.LoginActivity;
import com.example.alumnodanielhung.task2hnddanielhung.beans.UsuarioBean;

import java.io.IOException;
import java.io.InputStream;

public class PerfilFragment extends Fragment implements View.OnClickListener {

    private final int SELECT_PHOTO = 1;

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

        imgPerfil.setImageURI(Uri.parse(usuarioBean.getPhoto()));

        btnEditar.setOnClickListener(this);
        
        return rootView;
    }

    public static PerfilFragment newInstance() {
        return new PerfilFragment();
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
// Show only images, no videos or anything else
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
// Always show the chooser (if there are multiple options available)
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PHOTO);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SELECT_PHOTO && resultCode == Activity.RESULT_OK && data != null && data.getData() != null) {

            Uri uri = data.getData();

            Preferencias preferencias = new Preferencias(getActivity());
            UsuarioBean usuarioBean = preferencias.getUsuario();

            usuarioBean.setPhoto(uri.toString());

            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), uri);
                imgPerfil.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
