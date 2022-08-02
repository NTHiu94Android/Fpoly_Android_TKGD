package com.example.tkgd_android.Lab8.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tkgd_android.Lab8.Modul.SanPham;
import com.example.tkgd_android.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class Lab8Bai2Adapter extends RecyclerView.Adapter<Lab8Bai2Adapter.Lab8Bai2ViewHolder>{

    private ArrayList<SanPham> list = new ArrayList<>();
    public void setData(ArrayList<SanPham> list){
        this.list = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public Lab8Bai2ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lab8_rcv, parent, false);
        return new Lab8Bai2ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Lab8Bai2ViewHolder holder, int position) {
        holder.circleImageView.setImageResource(list.get(position).getImage());
        holder.textView.setText(list.get(position).getTitle());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.context, "Item " + holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.context, "Ảnh " + holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.context, holder.textView.getText().toString()+ " " + holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        if(list.size() != 0){
            return list.size();
        }
        return 0;
    }

    public class Lab8Bai2ViewHolder extends RecyclerView.ViewHolder{
        private CircleImageView circleImageView;
        private TextView textView;
        private LinearLayout linearLayout;
        private Context context;
        public Lab8Bai2ViewHolder(@NonNull View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.civLab8Ba2);
            textView = itemView.findViewById(R.id.tvLab8Bai2);
            linearLayout = itemView.findViewById(R.id.linearLayoutLab8Bai2);
            context = itemView.getContext();
        }
    }
}
