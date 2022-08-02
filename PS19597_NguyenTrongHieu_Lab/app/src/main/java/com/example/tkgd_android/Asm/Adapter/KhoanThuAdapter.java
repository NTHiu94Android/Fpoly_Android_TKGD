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

import com.example.tkgd_android.Asm.Dao.KhoanThuChiDAO;
import com.example.tkgd_android.Asm.Modul.KhoanThuChi;
import com.example.tkgd_android.R;
import java.util.ArrayList;

public class KhoanThuAdapter extends RecyclerView.Adapter<KhoanThuAdapter.KhoanThuViewHolder>{
    private ArrayList<KhoanThuChi> list;
    private KhoanThuChiDAO khoanThuChiDAO;

    public void setData(ArrayList<KhoanThuChi> list){
        this.list = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public KhoanThuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_asm_khoanthu, parent, false);
        return new KhoanThuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KhoanThuViewHolder holder, int position) {
        KhoanThuChi khoanThuChi = list.get(position);
        khoanThuChiDAO = new KhoanThuChiDAO(holder.context);
        if(khoanThuChi == null){
            return;
        }
        holder.tvTieuDeThu.setText(list.get(holder.getAdapterPosition()).getTieuDe());
        holder.tvNgayGiaoDichThu.setText(list.get(holder.getAdapterPosition()).getNgay());
        holder.tvMaGiaoDichThu.setText(String.valueOf(list.get(holder.getAdapterPosition()).getMaGiaoDich()));
        holder.tvMaLoaiThu.setText(String.valueOf(list.get(holder.getAdapterPosition()).getMaLoai()));
        holder.tvTienGiaoDichThu.setText(String.valueOf(list.get(holder.getAdapterPosition()).getTien()));

        holder.btnXoaKhoanThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                khoanThuChiDAO.xoaKhoanThuChi(list.get(holder.getAdapterPosition()));
                loadDs();
                Toast.makeText(holder.context, "Xóa thành công!", Toast.LENGTH_SHORT).show();
            }
        });
        holder.btnSuaKhoanThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.context);
                LayoutInflater inflater = ((FragmentActivity)holder.context).getLayoutInflater();
                View v = inflater.inflate(R.layout.dialog_asm_update_khoanthu, null);

                builder.setView(v);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

                TextView tvTieuDeCu = v.findViewById(R.id.tvTieuDeKhoanThuCuAsm);
                EditText edtTieuDeMoi = v.findViewById(R.id.edtTieuDeKhoanThuMoiAsm);
                EditText edtNgayKhoanThuMoi = v.findViewById(R.id.edtNgayKhoanThuMoiAsm);
                EditText edtTienKhoanThuMoi = v.findViewById(R.id.edtTienKhoanThuMoiAsm);

                Button btnClearUpdate = v.findViewById(R.id.btnClearUpdateKhoanThuAsm);
                Button btnUpdate = v.findViewById(R.id.btnUpdateKhoanThuAsm);

                tvTieuDeCu.setText(list.get(holder.getAdapterPosition()).getTieuDe());

                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(edtTieuDeMoi.getText().toString().isEmpty() ||
                                edtNgayKhoanThuMoi.getText().toString().isEmpty() ||
                                edtTienKhoanThuMoi.getText().toString().isEmpty()){
                            Toast.makeText(holder.context, "Nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        String TieuDeKhoanThuMoi = edtTieuDeMoi.getText().toString();
                        String NgayKhoanThuMoi = edtNgayKhoanThuMoi.getText().toString();
                        double TienKhoanThuMoi = Double.parseDouble(edtTienKhoanThuMoi.getText().toString());
                        KhoanThuChi khoanThuChi = new KhoanThuChi(list.get(holder.getAdapterPosition()).getMaGiaoDich(), TieuDeKhoanThuMoi,
                                NgayKhoanThuMoi, TienKhoanThuMoi, list.get(holder.getAdapterPosition()).getMaLoai());
                        khoanThuChiDAO.suaKhoanThuChi(khoanThuChi);
                        loadDs();
                        Toast.makeText(holder.context, "Sửa thành công!", Toast.LENGTH_SHORT).show();
                        alertDialog.dismiss();
                    }
                });

                btnClearUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtTieuDeMoi.setText("");
                        edtNgayKhoanThuMoi.setText("");
                        edtTienKhoanThuMoi.setText("");
                    }
                });
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

    public class KhoanThuViewHolder extends RecyclerView.ViewHolder{
        Context context;
        Button btnSuaKhoanThu, btnXoaKhoanThu;
        TextView tvMaGiaoDichThu, tvNgayGiaoDichThu, tvTienGiaoDichThu, tvMaLoaiThu, tvTieuDeThu;
        public KhoanThuViewHolder(@NonNull View itemView) {
            super(itemView);
            btnSuaKhoanThu = itemView.findViewById(R.id.btnSuaKhoanThuAsm);
            btnXoaKhoanThu = itemView.findViewById(R.id.btnXoaKhoanThuAsm);
            tvTieuDeThu = itemView.findViewById(R.id.tvTieuDeKhoanThuAsm);
            tvMaGiaoDichThu = itemView.findViewById(R.id.tvMaGiaoDichThuAsm);
            tvNgayGiaoDichThu = itemView.findViewById(R.id.tvNgayGiaoDichThuAsm);
            tvTienGiaoDichThu = itemView.findViewById(R.id.tvTienGiaoDichThuAsm);
            tvMaLoaiThu = itemView.findViewById(R.id.tvMaLoaiGiaoDichThuAsm);
            context = itemView.getContext();
        }
    }
    public void loadDs(){
        list.clear();
        list = khoanThuChiDAO.getAllGDThu();
        notifyDataSetChanged();
    }
}
