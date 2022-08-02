package com.example.tkgd_android.Asm.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tkgd_android.Asm.Adapter.KhoanChiAdapter;
import com.example.tkgd_android.Asm.Dao.KhoanThuChiDAO;
import com.example.tkgd_android.Asm.Dao.LoaiThuChiDAO;
import com.example.tkgd_android.Asm.Modul.KhoanThuChi;
import com.example.tkgd_android.Asm.Modul.LoaiThuChi;
import com.example.tkgd_android.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;
public class AsmKhoanChiFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private RecyclerView rvKhoanChi;
    private KhoanChiAdapter khoanChiAdapter;
    private ArrayList<KhoanThuChi> list = new ArrayList<>();
    private KhoanThuChiDAO khoanThuChiDAO;
    private FloatingActionButton floatingActionButton;
    private Spinner spn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_asm_khoan_chi, container, false);
        rvKhoanChi = view.findViewById(R.id.rcDanhSachKhoanChiAsm);
        floatingActionButton = view.findViewById(R.id.btnFloatTingKhoanChiAsm);

        khoanThuChiDAO = new KhoanThuChiDAO(getActivity());
        getData();

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogAddKhoanChi();
            }
        });

        rvKhoanChi.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                if(dy>0){
                    floatingActionButton.hide();
                }else{
                    floatingActionButton.show();
                }
                super.onScrolled(recyclerView, dx, dy);
            }
        });
        return view;
    }
    private void getData(){
        list.clear();
        list = khoanThuChiDAO.getAllGDChi();
        khoanChiAdapter = new KhoanChiAdapter();
        khoanChiAdapter.setData(list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvKhoanChi.setLayoutManager(layoutManager);

        rvKhoanChi.setAdapter(khoanChiAdapter);
    }
    private void getdataSpn(Spinner spn) {
        LoaiThuChiDAO loaiThuChiDAO = new LoaiThuChiDAO(getActivity());
        ArrayList<LoaiThuChi> listLoaiChi = loaiThuChiDAO.getAllPLChi();
        ArrayList<HashMap<String, String>> list = new ArrayList<>();
        for (LoaiThuChi loaiThuChi : listLoaiChi) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("MALOAI", String.valueOf(loaiThuChi.getMaLoai()));
            hashMap.put("TENLOAI", loaiThuChi.getTenLoai());
            list.add(hashMap);
        }

        SimpleAdapter adapter = new SimpleAdapter(getActivity(), list, R.layout.item_asm_spinner_chi,
                new String[]{"TENLOAI"}, new int[]{R.id.tvTenLoaiChiSpnAsm});
        spn.setAdapter(adapter);
    }
    private void dialogAddKhoanChi() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getLayoutInflater();
        View v = inflater.inflate(R.layout.dialog_asm_add_khoanchi, null);

        builder.setView(v);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        Button btnClear = v.findViewById(R.id.btnClearThemKhoanChiAsm);
        Button btnAdd = v.findViewById(R.id.btnAddThemKhoanChiAsm);
        EditText edtThemTieuDe = v.findViewById(R.id.edtThemTieuDeKhoanChiAsm);
        EditText edtThemTienChi = v.findViewById(R.id.edtThemTienKhoanChiAsm);
        EditText edtThemNgayChi = v.findViewById(R.id.edtThemNgayKhoanChiAsm);
        spn = v.findViewById(R.id.spnKhoanChiAsm);
        getdataSpn(spn);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String, String> hashMap = (HashMap<String, String>) spn.getSelectedItem();
                if(edtThemTieuDe.getText().toString().isEmpty() ||
                        edtThemTienChi.getText().toString().isEmpty() ||
                        edtThemNgayChi.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }
                int maLoai = Integer.parseInt(hashMap.get("MALOAI"));
                String tieude = edtThemTieuDe.getText().toString();
                double tien = Double.parseDouble(edtThemTienChi.getText().toString());
                String ngay = edtThemNgayChi.getText().toString();

                KhoanThuChi khoanThuChi = new KhoanThuChi(tieude, ngay, tien, maLoai);
                khoanThuChiDAO.themKhoanThuChi(khoanThuChi);
                getData();
                Toast.makeText(getActivity(), "Thêm mới thành công!", Toast.LENGTH_SHORT).show();
                alertDialog.dismiss();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtThemTieuDe.setText("");
                edtThemTienChi.setText("");
                edtThemNgayChi.setText("");
            }
        });
    }
}