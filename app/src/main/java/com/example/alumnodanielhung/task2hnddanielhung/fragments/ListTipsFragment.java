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
import com.example.alumnodanielhung.task2hnddanielhung.activities.TipsActivity;
import com.example.alumnodanielhung.task2hnddanielhung.adapters.TipsAdapter;
import com.example.alumnodanielhung.task2hnddanielhung.beans.TipsBean;
import com.example.alumnodanielhung.task2hnddanielhung.Contenido.Contenido;

import java.util.ArrayList;

public class ListTipsFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView listTips;
    private ArrayList tips;
    public static final String TIPS_KEY="TIPS_KEY";

    public ListTipsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_tips, container, false);
        listTips = (ListView) view.findViewById(R.id.listTips);
        tips = Contenido.getTips();
        TipsAdapter adapter = new TipsAdapter(getActivity(), R.layout.item_tips, tips);
        listTips.setAdapter(adapter);
        listTips.setOnItemClickListener(this);
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

    public static ListTipsFragment newInstance() {
        return new ListTipsFragment();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
        TipsBean tipsBean = (TipsBean) tips.get(posicion);
        Intent intent = new Intent(getActivity(), TipsActivity.class);

        intent.putExtra(TIPS_KEY, tipsBean);
        startActivity(intent);
    }
}
