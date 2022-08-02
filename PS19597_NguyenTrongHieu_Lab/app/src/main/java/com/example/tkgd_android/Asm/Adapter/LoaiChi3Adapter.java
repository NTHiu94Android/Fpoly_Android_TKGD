package com.example.tkgd_android.Asm.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tkgd_android.Asm.Modul.LoaiThuChi;
import com.example.tkgd_android.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class LoaiChi3Adapter extends RecyclerView.Adapter<LoaiChi3Adapter.LoaiChiViewHolder> {
    private ArrayList<LoaiThuChi> list;
    public void setData(ArrayList<LoaiThuChi> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LoaiChiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_asm_loaichi, parent, false);
        return new LoaiChiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoaiChiViewHolder holder, int position) {
        LoaiThuChi loaiThuChi = list.get(position);
        if(loaiThuChi == null){
            return;
        }
        holder.tvLoaiChi.setText(list.get(position).getTenLoai());
        holder.cimv.setImageResource(R.drawable.new_product);

        holder.btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //((AsmLoaiChi)holder.context).updateds(holder.getAdapterPosition());
                notifyItemChanged(holder.getAdapterPosition());
            }
        });
        holder.btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //((AsmLoaiChi)holder.context).xoads(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
                Toast.makeText(holder.context, "Xóa thành công", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        if(list != null){
            return list.size();
        }
        return 0;
    }

    public class LoaiChiViewHolder extends RecyclerView.ViewHolder{
        private TextView tvLoaiChi;
        private Button btnXoa, btnSua;
        private CircleImageView cimv;
        private Context context;

        public LoaiChiViewHolder(@NonNull View itemView) {
            super(itemView);
            tvLoaiChi = itemView.findViewById(R.id.tvTenLoaiKhoanChiItemAsm);
            btnSua = itemView.findViewById(R.id.btnSuaLoaiChiAsm);
            btnXoa = itemView.findViewById(R.id.btnXoaLoaiChiAsm);
            cimv = itemView.findViewById(R.id.cimvLoaiChiAsm);
            context = itemView.getContext();
        }
    }
}
