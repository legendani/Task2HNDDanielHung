package com.example.alumnodanielhung.task2hnddanielhung.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.alumnodanielhung.task2hnddanielhung.R;


public class DescripcionFragment extends Fragment implements View.OnClickListener {

    private Button btnCompartir;
    private TextView txtDescripcion;

    public DescripcionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_descripcion, container, false);
        txtDescripcion = (TextView) view.findViewById(R.id.txtDescripcion);
        btnCompartir = (Button) view.findViewById(R.id.btnCompartir);

        btnCompartir.setOnClickListener(this);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public static DescripcionFragment newInstance() {
        return new  DescripcionFragment();
    }

    @Override
    public void onClick(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, txtDescripcion.getText());
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }
}
