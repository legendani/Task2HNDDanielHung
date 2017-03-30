package com.example.alumnodanielhung.task2hnddanielhung.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.alumnodanielhung.task2hnddanielhung.R;
import com.example.alumnodanielhung.task2hnddanielhung.activities.NavesActivity;
import com.example.alumnodanielhung.task2hnddanielhung.adapters.PersonajesAdapter;
import com.example.alumnodanielhung.task2hnddanielhung.beans.PersonajesBean;
import com.example.alumnodanielhung.task2hnddanielhung.Contenido.Contenido;

import java.util.ArrayList;

public class ListPersonajesFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView listPersonajes;
    private ArrayList personajes;
    public static final String PERSONAJE_KEY="PERSONAJE_KEY";


    public ListPersonajesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_personajes, container, false);
        listPersonajes = (ListView) view.findViewById(R.id.listPersonajes);
        personajes = Contenido.getPersonajes();
        PersonajesAdapter adapter = new PersonajesAdapter(getActivity(), R.layout.item_nave, personajes);
        listPersonajes.setAdapter(adapter);
        listPersonajes.setOnItemClickListener(this);
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

    public static ListPersonajesFragment newInstance() {
        return new ListPersonajesFragment();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
        PersonajesBean personajesBean = (PersonajesBean) personajes.get(posicion);
        Intent intent = new Intent(getActivity(), NavesActivity.class);

        intent.putExtra(PERSONAJE_KEY, personajesBean);
        startActivity(intent);
    }
}
