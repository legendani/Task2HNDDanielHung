package com.example.alumnodanielhung.task2hnddanielhung.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.alumnodanielhung.task2hnddanielhung.R;

import java.util.ArrayList;

public class ListTipsFragment extends Fragment {

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
        return inflater.inflate(R.layout.fragment_list_tips, container, false);
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
}
