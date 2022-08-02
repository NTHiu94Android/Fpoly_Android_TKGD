package com.example.tkgd_android.Lab3.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tkgd_android.Lab3.Class.ClassLab3Bai4;
import com.example.tkgd_android.R;

import java.util.ArrayList;

public class AdapterLab3Bai4 extends BaseAdapter {
    private ArrayList<ClassLab3Bai4> list;
    private Context context;

    public AdapterLab3Bai4(ArrayList<ClassLab3Bai4> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private static class ViewHolder{
        ImageView imv;
        TextView tv;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        LayoutInflater inflater = LayoutInflater.from(context);

        if(view == null){
            view = inflater.inflate(R.layout.item_lab3_bai4, viewGroup, false);
            holder = new ViewHolder();
            holder.imv = view.findViewById(R.id.imvLab3Bai4);
            holder.tv = view.findViewById(R.id.tvLab3Bai4);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        holder.imv.setImageResource(list.get(i).getImg());
        holder.tv.setText(list.get(i).getName());

        return view;
    }
}
