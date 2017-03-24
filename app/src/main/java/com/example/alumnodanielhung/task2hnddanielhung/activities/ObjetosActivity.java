package com.example.alumnodanielhung.task2hnddanielhung.activities;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alumnodanielhung.task2hnddanielhung.R;
import com.example.alumnodanielhung.task2hnddanielhung.beans.ObjetosBean;
import com.example.alumnodanielhung.task2hnddanielhung.beans.PersonajesBean;
import com.example.alumnodanielhung.task2hnddanielhung.fragments.ListObjetosFragment;
import com.example.alumnodanielhung.task2hnddanielhung.fragments.ListPersonajesFragment;

public class ObjetosActivity extends AppCompatActivity {

    private ImageView imgObjeto;
    private TextView txtNombreObjeto, txtDescripObjeto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objetos);

        ObjetosBean objetosBean = (ObjetosBean) getIntent().getSerializableExtra(ListObjetosFragment.OBJETOS_KEY);

        imgObjeto = (ImageView) findViewById(R.id.imgObjeto);

        txtNombreObjeto = (TextView) findViewById(R.id.txtNombreObjeto);
        txtDescripObjeto = (TextView) findViewById(R.id.txtDescripObjeto);

        txtNombreObjeto.setText(String.valueOf(objetosBean.getTitulo()));
        txtDescripObjeto.setText(String.valueOf(objetosBean.getDescripcion()));

        imgObjeto.setImageDrawable(ContextCompat.getDrawable(this, objetosBean.getFoto()));
    }
}
