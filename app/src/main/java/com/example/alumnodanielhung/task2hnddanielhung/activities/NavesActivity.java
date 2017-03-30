package com.example.alumnodanielhung.task2hnddanielhung.activities;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alumnodanielhung.task2hnddanielhung.R;
import com.example.alumnodanielhung.task2hnddanielhung.beans.PersonajesBean;
import com.example.alumnodanielhung.task2hnddanielhung.fragments.ListPersonajesFragment;

import static com.example.alumnodanielhung.task2hnddanielhung.fragments.ListPersonajesFragment.PERSONAJE_KEY;

public class NavesActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgNave;
    private TextView txtNombreNave, txtDescripNave;
    private Button btnCompartir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naves);

        PersonajesBean personajesBean = (PersonajesBean) getIntent().getSerializableExtra(ListPersonajesFragment.PERSONAJE_KEY);

        imgNave = (ImageView) findViewById(R.id.imgNave);

        txtNombreNave = (TextView) findViewById(R.id.txtNombreNave);
        txtDescripNave = (TextView) findViewById(R.id.txtDescripNave);

        btnCompartir = (Button) findViewById(R.id.btnCompartir);

        txtNombreNave.setText(String.valueOf(personajesBean.getTitulo()));
        txtDescripNave.setText(String.valueOf(personajesBean.getDescripcion()));

        imgNave.setImageDrawable(ContextCompat.getDrawable(this, personajesBean.getFoto()));

        btnCompartir.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, txtDescripNave.getText());
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }
}
