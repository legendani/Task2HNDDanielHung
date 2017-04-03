package com.example.alumnodanielhung.task2hnddanielhung.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alumnodanielhung.task2hnddanielhung.R;
import com.example.alumnodanielhung.task2hnddanielhung.beans.PersonajesBean;

import java.util.List;

/**
 * Created by ALUMNOS on 16/03/2017.
 */

public class PersonajesAdapter extends ArrayAdapter<PersonajesBean>{

    private Context context;
    private int resource;
    private List<PersonajesBean> objects;

    public PersonajesAdapter(Context context, int resource, List<PersonajesBean> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    class ViewHolder {
        TextView txtTitulo;
        ImageView imgNave;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder;

        if (view == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(resource, null);
            viewHolder.txtTitulo = (TextView) view.findViewById(R.id.txtTitulo);
            viewHolder.imgNave = (ImageView) view.findViewById(R.id.imgNave);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        PersonajesBean personajesBean = objects.get(position);

        viewHolder.txtTitulo.setText(personajesBean.getTitulo());
        viewHolder.imgNave.setImageDrawable(ContextCompat.getDrawable(context, personajesBean.getFoto()));
        return view;
    }
}
