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
import com.example.alumnodanielhung.task2hnddanielhung.beans.TipsBean;

import java.util.List;

/**
 * Created by ALUMNOS on 16/03/2017.
 */

public class TipsAdapter extends ArrayAdapter<TipsBean> {

    private Context context;
    private int resource;
    private List<TipsBean> objects;

    public TipsAdapter(Context context, int resource, List<TipsBean> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    class ViewHolder {
        TextView txtTituloTips;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        TipsAdapter.ViewHolder viewHolder;

        if (view == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(resource, null);
            viewHolder.txtTituloTips = (TextView) view.findViewById(R.id.txtTituloTips);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        TipsBean tipsBean = objects.get(position);

        viewHolder.txtTituloTips.setText(tipsBean.getTitulo());
        return view;
    }
}
