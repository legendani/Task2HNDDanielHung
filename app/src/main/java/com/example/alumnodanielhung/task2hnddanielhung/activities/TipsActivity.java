package com.example.alumnodanielhung.task2hnddanielhung.activities;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alumnodanielhung.task2hnddanielhung.R;
import com.example.alumnodanielhung.task2hnddanielhung.beans.ObjetosBean;
import com.example.alumnodanielhung.task2hnddanielhung.beans.TipsBean;
import com.example.alumnodanielhung.task2hnddanielhung.fragments.ListObjetosFragment;
import com.example.alumnodanielhung.task2hnddanielhung.fragments.ListTipsFragment;

import java.io.Serializable;

public class TipsActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgConsejo;
    private TextView txtConsejo, txtDescripConsejo;
    private Button btnCompartir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        TipsBean tipsBean = (TipsBean) getIntent().getSerializableExtra(ListTipsFragment.TIPS_KEY);

        imgConsejo = (ImageView) findViewById(R.id.imgConsejo);

        txtConsejo = (TextView) findViewById(R.id.txtConsejo);
        txtDescripConsejo = (TextView) findViewById(R.id.txtDescripConsejo);

        btnCompartir = (Button) findViewById(R.id.btnCompartir);

        txtConsejo.setText(String.valueOf(tipsBean.getTitulo()));
        txtDescripConsejo.setText(String.valueOf(tipsBean.getDescripcion()));

        imgConsejo.setImageDrawable(ContextCompat.getDrawable(this, tipsBean.getFoto()));

        btnCompartir.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, txtDescripConsejo.getText());
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }
}
