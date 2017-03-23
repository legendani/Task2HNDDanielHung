package com.example.alumnodanielhung.task2hnddanielhung.activities;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alumnodanielhung.task2hnddanielhung.R;
import com.example.alumnodanielhung.task2hnddanielhung.beans.PersonajesBean;
import com.example.alumnodanielhung.task2hnddanielhung.fragments.ListPersonajesFragment;

import static com.example.alumnodanielhung.task2hnddanielhung.fragments.ListPersonajesFragment.PERSONAJE_KEY;

public class NavesActivity extends AppCompatActivity {

    private ImageView imgNave;
    private TextView txtNombreNave, txtDescripNave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naves);

        PersonajesBean personajesBean = (PersonajesBean) getIntent().getSerializableExtra(ListPersonajesFragment.PERSONAJE_KEY);

        imgNave = (ImageView) findViewById(R.id.imgNave);

        txtNombreNave = (TextView) findViewById(R.id.txtNombreNave);
        txtDescripNave = (TextView) findViewById(R.id.txtDescripNave);

        txtNombreNave.setText(String.valueOf(personajesBean.getTitulo()));
        txtDescripNave.setText(String.valueOf(personajesBean.getDescripcion()));

        imgNave.setImageDrawable(ContextCompat.getDrawable(this, personajesBean.getFoto()));
    }
}
