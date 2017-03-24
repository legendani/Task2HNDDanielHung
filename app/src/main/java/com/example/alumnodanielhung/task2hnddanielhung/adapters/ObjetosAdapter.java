package com.example.alumnodanielhung.task2hnddanielhung.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.alumnodanielhung.task2hnddanielhung.R;
import com.example.alumnodanielhung.task2hnddanielhung.beans.ObjetosBean;
import com.example.alumnodanielhung.task2hnddanielhung.beans.PersonajesBean;
import com.example.alumnodanielhung.task2hnddanielhung.beans.TipsBean;

import java.util.List;

/**
 * Created by ALUMNOS on 16/03/2017.
 */

public class ObjetosAdapter extends ArrayAdapter<ObjetosBean>{

    private Context context;
    private int resource;
    private List<ObjetosBean> objects;

    public ObjetosAdapter(Context context, int resource, List<ObjetosBean> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    class ViewHolder {
        TextView txtTituloObjetos;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder;

        if (view == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(resource, null);
            viewHolder.txtTituloObjetos = (TextView) view.findViewById(R.id.txtTituloObjetos);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        ObjetosBean objetosBean = objects.get(position);

        viewHolder.txtTituloObjetos.setText(objetosBean.getTitulo());
        return view;
    }
}
