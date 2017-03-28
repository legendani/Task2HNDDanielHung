package com.example.alumnodanielhung.task2hnddanielhung.activities;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alumnodanielhung.task2hnddanielhung.R;
import com.example.alumnodanielhung.task2hnddanielhung.beans.ObjetosBean;
import com.example.alumnodanielhung.task2hnddanielhung.beans.TipsBean;
import com.example.alumnodanielhung.task2hnddanielhung.fragments.ListObjetosFragment;
import com.example.alumnodanielhung.task2hnddanielhung.fragments.ListTipsFragment;

public class TipsActivity extends AppCompatActivity {

    private ImageView imgConsejo;
    private TextView txtConsejo, txtDescripConsejo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        TipsBean tipsBean = (TipsBean) getIntent().getSerializableExtra(ListTipsFragment.TIPS_KEY);

        imgConsejo = (ImageView) findViewById(R.id.imgConsejo);

        txtConsejo = (TextView) findViewById(R.id.txtConsejo);
        txtDescripConsejo = (TextView) findViewById(R.id.txtDescripConsejo);

        txtConsejo.setText(String.valueOf(tipsBean.getTitulo()));
        txtDescripConsejo.setText(String.valueOf(tipsBean.getDescripcion()));

        imgConsejo.setImageDrawable(ContextCompat.getDrawable(this, tipsBean.getFoto()));
    }
}
