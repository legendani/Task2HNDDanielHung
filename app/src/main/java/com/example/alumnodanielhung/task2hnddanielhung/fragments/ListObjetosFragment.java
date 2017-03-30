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
import com.example.alumnodanielhung.task2hnddanielhung.activities.ObjetosActivity;
import com.example.alumnodanielhung.task2hnddanielhung.adapters.ObjetosAdapter;
import com.example.alumnodanielhung.task2hnddanielhung.beans.ObjetosBean;
import com.example.alumnodanielhung.task2hnddanielhung.Contenido.Contenido;

import java.util.ArrayList;

public class ListObjetosFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView listObjetos;
    private ArrayList objetos;
    public static final String OBJETOS_KEY="OBJETOS_KEY";

    public ListObjetosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_objetos, container, false);
        listObjetos = (ListView) view.findViewById(R.id.listObjetos);
        objetos = Contenido.getObjetos();
        ObjetosAdapter adapter = new ObjetosAdapter(getActivity(), R.layout.item_objetos, objetos);
        listObjetos.setAdapter(adapter);
        listObjetos.setOnItemClickListener(this);
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

    public static ListObjetosFragment newInstance() {
        return new ListObjetosFragment();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
        ObjetosBean objetosBean = (ObjetosBean) objetos.get(posicion);
        Intent intent = new Intent(getActivity(), ObjetosActivity.class);

        intent.putExtra(OBJETOS_KEY, objetosBean);
        startActivity(intent);
    }
}
