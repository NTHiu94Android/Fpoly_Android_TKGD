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

public class KhoanChiAdapter extends RecyclerView.Adapter<KhoanChiAdapter.KhoanChiViewHolder> {
    private ArrayList<KhoanThuChi> list;
    private KhoanThuChiDAO khoanThuChiDAO;

    public void setData(ArrayList<KhoanThuChi> list){
        this.list = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public KhoanChiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_asm_khoanchi, parent, false);
        return new KhoanChiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KhoanChiViewHolder holder, int position) {
        KhoanThuChi khoanThuChi = list.get(position);
        khoanThuChiDAO = new KhoanThuChiDAO(holder.context);
        if(khoanThuChi == null){
            return;
        }
        holder.tvMaLoaiChi.setText(String.valueOf(list.get(holder.getAdapterPosition()).getMaLoai()));
        holder.tvMaGiaoDichChi.setText(String.valueOf(list.get(holder.getAdapterPosition()).getMaGiaoDich()));
        holder.tvNgayChi.setText(list.get(holder.getAdapterPosition()).getNgay());
        holder.tvTieuDeChi.setText(list.get(holder.getAdapterPosition()).getTieuDe());
        holder.tvTienChi.setText(String.valueOf(list.get(holder.getAdapterPosition()).getTien()));

        holder.btnSuaKhoanChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //((AsmKhoanChi)holder.context).suads(holder.getAdapterPosition());
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.context);
                LayoutInflater inflater = ((FragmentActivity)holder.context).getLayoutInflater();
                View v = inflater.inflate(R.layout.dialog_asm_update_khoanchi, null);

                builder.setView(v);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

                TextView tvTieuDeCu = v.findViewById(R.id.tvTieuDeKhoanChiCuAsm);
                EditText edtTieuDeMoi = v.findViewById(R.id.edtTieuDeKhoanChiMoiAsm);
                EditText edtNgayKhoanChiMoi = v.findViewById(R.id.edtNgayKhoanChiMoiAsm);
                EditText edtTienKhoanChiMoi = v.findViewById(R.id.edtTienKhoanChiMoiAsm);

                Button btnClearUpdate = v.findViewById(R.id.btnClearUpdateKhoanChiAsm);
                Button btnUpdate = v.findViewById(R.id.btnUpdateKhoanChiAsm);

                tvTieuDeCu.setText(list.get(holder.getAdapterPosition()).getTieuDe());

                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(edtTieuDeMoi.getText().toString().isEmpty() ||
                                edtNgayKhoanChiMoi.getText().toString().isEmpty() ||
                                edtTienKhoanChiMoi.getText().toString().isEmpty()){
                            Toast.makeText(holder.context, "Nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        String TieuDeKhoanChiMoi = edtTieuDeMoi.getText().toString();
                        String NgayKhoanChiMoi = edtNgayKhoanChiMoi.getText().toString();
                        double TienKhoanChiMoi = Double.parseDouble(edtTienKhoanChiMoi.getText().toString());
                        KhoanThuChi khoanThuChi = new KhoanThuChi(list.get(holder.getAdapterPosition()).getMaGiaoDich(), TieuDeKhoanChiMoi,
                                NgayKhoanChiMoi, TienKhoanChiMoi, list.get(holder.getAdapterPosition()).getMaLoai());
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
                        edtNgayKhoanChiMoi.setText("");
                        edtTienKhoanChiMoi.setText("");
                    }
                });
            }
        });
        holder.btnXoaKhoanChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //((AsmKhoanChi)holder.context).xoads(holder.getAdapterPosition());
                khoanThuChiDAO.xoaKhoanThuChi(list.get(holder.getAdapterPosition()));
                loadDs();
                Toast.makeText(holder.context, "Xóa thành công!", Toast.LENGTH_SHORT).show();
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

    public class KhoanChiViewHolder extends RecyclerView.ViewHolder{
        private TextView tvMaGiaoDichChi, tvTieuDeChi, tvNgayChi, tvTienChi, tvMaLoaiChi;
        private Button btnXoaKhoanChi, btnSuaKhoanChi;
        private Context context;
        public KhoanChiViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMaGiaoDichChi = itemView.findViewById(R.id.tvMaGiaoDichChiAsm);
            tvTieuDeChi = itemView.findViewById(R.id.tvTieuDeKhoanChiAsm);
            tvNgayChi = itemView.findViewById(R.id.tvNgayGiaoDichChiAsm);
            tvTienChi = itemView.findViewById(R.id.tvTienGiaoDichChiAsm);
            tvMaLoaiChi = itemView.findViewById(R.id.tvMaLoaiGiaoDichChiAsm);
            btnXoaKhoanChi = itemView.findViewById(R.id.btnXoaKhoanChiAsm);
            btnSuaKhoanChi = itemView.findViewById(R.id.btnSuaKhoanChiAsm);
            context = itemView.getContext();
        }
    }
    private void loadDs(){
        list.clear();
        list = khoanThuChiDAO.getAllGDChi();
        notifyDataSetChanged();
    }
}
