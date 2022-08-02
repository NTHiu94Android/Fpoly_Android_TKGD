package com.example.tkgd_android.Lab3.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tkgd_android.Lab3.Class.ClassLab3Bai1;
import com.example.tkgd_android.R;

import java.util.ArrayList;

public class AdapterLab3Bai1 extends BaseAdapter {
    private ArrayList<ClassLab3Bai1> list;
    private Context context;

    public AdapterLab3Bai1(ArrayList<ClassLab3Bai1> list, Context context) {
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
        TextView tv1, tv2;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        LayoutInflater inflater = LayoutInflater.from(context);

        if(view == null){
            view = inflater.inflate(R.layout.item_lab3_bai1, viewGroup, false);
            holder = new ViewHolder();
            holder.imv = view.findViewById(R.id.imvLab3Bai1);
            holder.tv1 = view.findViewById(R.id.tv1Lab3Bai1);
            holder.tv2 = view.findViewById(R.id.tv2Lab3Bai1);
            view.setTag(holder);
        }else {
            holder = (ViewHolder)view.getTag();
        }

        holder.imv.setImageResource(list.get(i).getImage());
        holder.tv1.setText(list.get(i).getName());
        holder.tv2.setText(String.valueOf(list.get(i).getAge()));

        return view;
    }
}
