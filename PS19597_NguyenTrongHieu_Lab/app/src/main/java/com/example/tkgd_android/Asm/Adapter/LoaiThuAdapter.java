package com.example.tkgd_android.Asm.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.chauthai.swipereveallayout.SwipeRevealLayout;
import com.chauthai.swipereveallayout.ViewBinderHelper;
import com.example.tkgd_android.Asm.Dao.LoaiThuChiDAO;
import com.example.tkgd_android.Asm.Fragment.AsmLoaiThuFragment;
import com.example.tkgd_android.Asm.Modul.LoaiThuChi;
import com.example.tkgd_android.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class LoaiThuAdapter extends RecyclerView.Adapter<LoaiThuAdapter.LoaiThuViewHolder>{
    private ArrayList<LoaiThuChi> list;
    private LoaiThuChiDAO loaiThuChiDAO;
    private ViewBinderHelper viewBinderHelper = new ViewBinderHelper();
    public void setData(ArrayList<LoaiThuChi> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LoaiThuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_asm_loaithu2, parent,false);
        return new LoaiThuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoaiThuViewHolder holder, int position) {
        LoaiThuChi loaiThuChi = list.get(position);
        loaiThuChiDAO = new LoaiThuChiDAO(holder.context);
        if(loaiThuChi == null){
            return;
        }
        viewBinderHelper.bind(holder.swipeRevealLayout, String.valueOf(list.get(holder.getAdapterPosition()).getMaLoai()));
        holder.tvLoaiThu.setText(list.get(position).getTenLoai());
        holder.cimv.setImageResource(R.drawable.logo_poly);

        holder.tvEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //((AsmLoaiChi)holder.context).updateds(holder.getAdapterPosition());
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.context);
                LayoutInflater inflater = ((FragmentActivity)holder.context).getLayoutInflater();
                View v = inflater.inflate(R.layout.dialog_asm_update_loaithu, null);

                builder.setView(v);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

                TextView tvLoaiThuCuAsm = v.findViewById(R.id.tvLoaiThuCuAsm);
                EditText edtLoaiThuMoiAsm = v.findViewById(R.id.edtLoaiThuMoiAsm);

                Button btnClearUpdate = v.findViewById(R.id.btnClearUpdateLoaiThuAsm);
                Button btnUpdate = v.findViewById(R.id.btnUpdateLoaiThuAsm);

                tvLoaiThuCuAsm.setText(list.get(holder.getAdapterPosition()).getTenLoai());

                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(edtLoaiThuMoiAsm.getText().toString().isEmpty()){
                            Toast.makeText(holder.context, "Nhập đủ thông tin!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        String loaiThuMoi = edtLoaiThuMoiAsm.getText().toString();
                        LoaiThuChi loaiThuChi = new LoaiThuChi(list.get(holder.getAdapterPosition()).getMaLoai(), loaiThuMoi, "CHI");
                        loaiThuChiDAO.suaThuChi(loaiThuChi);
                        loadDs();
                        Toast.makeText(holder.context, "Sửa thành công", Toast.LENGTH_SHORT).show();
                        alertDialog.dismiss();
                    }
                });

                btnClearUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtLoaiThuMoiAsm.setText("");
                    }
                });

            }
        });
        holder.tvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //((AsmLoaiChi)holder.context).xoads(holder.getAdapterPosition());
                loaiThuChiDAO.xoaThuChi(list.get(holder.getAdapterPosition()));
                loadDs();
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

    public class LoaiThuViewHolder extends RecyclerView.ViewHolder{
        TextView tvEdit, tvDelete, tvLoaiThu;
        CircleImageView cimv;
        Context context;
        SwipeRevealLayout swipeRevealLayout;

        public LoaiThuViewHolder(@NonNull View itemView) {
            super(itemView);
            tvEdit = itemView.findViewById(R.id.tvEditLoaiThu2Asm);
            tvDelete = itemView.findViewById(R.id.tvDeleteLoaiThu2Asm);
            tvLoaiThu = itemView.findViewById(R.id.tvItemLoaiThu2Asm);
            cimv = itemView.findViewById(R.id.cimvLoaiThu2Asm);
            context = itemView.getContext();
            swipeRevealLayout = itemView.findViewById(R.id.swipeLayoutLoaiThu2Asm);
        }
    }
    public void loadDs(){
        list.clear();;
        list = loaiThuChiDAO.getAllPLThu();
        notifyDataSetChanged();
    }
}
