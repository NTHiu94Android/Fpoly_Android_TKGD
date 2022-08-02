package com.example.tkgd_android.Asm.Fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.tkgd_android.Asm.Adapter.LoaiChi2Adapter;
import com.example.tkgd_android.Asm.Dao.LoaiThuChiDAO;
import com.example.tkgd_android.Asm.Modul.LoaiThuChi;
import com.example.tkgd_android.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

public class AsmLoaiChiFragment extends Fragment {
    private RecyclerView rvLoaiChi;
    private FloatingActionButton floatingActionButton;
    private LoaiThuChiDAO loaiThuChiDAO;
    private LoaiChi2Adapter loaiChi2Adapter;
    private ArrayList<LoaiThuChi> list = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_asm_loai_chi, container, false);
        rvLoaiChi = view.findViewById(R.id.rcLoaiChiAsm);
        floatingActionButton = view.findViewById(R.id.btnFloatTingLoaiChiAsm);

        loaiThuChiDAO = new LoaiThuChiDAO(getActivity());
        getData();

        rvLoaiChi.addOnScrollListener(new RecyclerView.OnScrollListener() {
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
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogThemLoaiChi();
            }
        });
        return view;
    }
    private void getData(){
        list.clear();
        list = loaiThuChiDAO.getAllPLChi();
        loaiChi2Adapter = new LoaiChi2Adapter();
        loaiChi2Adapter.setData(list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvLoaiChi.setLayoutManager(layoutManager);

        rvLoaiChi.setAdapter(loaiChi2Adapter);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        rvLoaiChi.addItemDecoration(itemDecoration);
    }

    private void dialogThemLoaiChi() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getLayoutInflater();
        View v = inflater.inflate(R.layout.dialog_asm_add_loaichi, null);

        builder.setView(v);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        EditText edtLoaiChiMoiAsm = v.findViewById(R.id.edtThemTenLoaiChiAsm);

        Button btnClear = v.findViewById(R.id.btnClearThemLoaiChiAsm);
        Button btnAdd = v.findViewById(R.id.btnAddThemLoaiChiAsm);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtLoaiChiMoiAsm.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }
                String loaiChiMoi = edtLoaiChiMoiAsm.getText().toString();

                LoaiThuChi loaiThuChi = new LoaiThuChi(loaiChiMoi, "CHI");
                loaiThuChiDAO.themThuChi(loaiThuChi);
                getData();
                Toast.makeText(getActivity(), "Thêm mới thành công!", Toast.LENGTH_SHORT).show();
                alertDialog.dismiss();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtLoaiChiMoiAsm.setText("");
            }
        });
    }
}