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
import com.example.tkgd_android.Asm.Adapter.KhoanThuAdapter;
import com.example.tkgd_android.Asm.Dao.KhoanThuChiDAO;
import com.example.tkgd_android.Asm.Dao.LoaiThuChiDAO;
import com.example.tkgd_android.Asm.Modul.KhoanThuChi;
import com.example.tkgd_android.Asm.Modul.LoaiThuChi;
import com.example.tkgd_android.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AsmKhoanThuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AsmKhoanThuFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AsmKhoanThuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AsmKhoanThuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AsmKhoanThuFragment newInstance(String param1, String param2) {
        AsmKhoanThuFragment fragment = new AsmKhoanThuFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private RecyclerView rvKhoanThu;
    private KhoanThuAdapter khoanThuAdapter;
    private ArrayList<KhoanThuChi> list = new ArrayList<>();
    private KhoanThuChiDAO khoanThuChiDAO;
    private FloatingActionButton floatingActionButton;
    private Spinner spn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_asm_khoan_thu, container, false);
        rvKhoanThu = view.findViewById(R.id.rcDanhSachKhoanThuAsm);
        floatingActionButton = view.findViewById(R.id.btnFloatTingKhoanThuAsm);

        khoanThuChiDAO = new KhoanThuChiDAO(getActivity());
        getData();

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogAddKhoanThu();
            }
        });

        rvKhoanThu.addOnScrollListener(new RecyclerView.OnScrollListener() {
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
        list = khoanThuChiDAO.getAllGDThu();
        khoanThuAdapter = new KhoanThuAdapter();
        khoanThuAdapter.setData(list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvKhoanThu.setLayoutManager(layoutManager);

        rvKhoanThu.setAdapter(khoanThuAdapter);
    }
    private void getdataSpn(Spinner spn) {
        LoaiThuChiDAO loaiThuChiDAO = new LoaiThuChiDAO(getActivity());
        ArrayList<LoaiThuChi> listLoaiThu = loaiThuChiDAO.getAllPLThu();
        ArrayList<HashMap<String, String>> list = new ArrayList<>();
        for (LoaiThuChi loaiThuThu : listLoaiThu) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("MALOAI", String.valueOf(loaiThuThu.getMaLoai()));
            hashMap.put("TENLOAI", loaiThuThu.getTenLoai());
            list.add(hashMap);
        }

        SimpleAdapter adapter = new SimpleAdapter(getActivity(), list, R.layout.item_asm_spinner_thu,
                new String[]{"TENLOAI"}, new int[]{R.id.tvTenLoaiThuSpnAsm});
        spn.setAdapter(adapter);
    }
    private void dialogAddKhoanThu() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getLayoutInflater();
        View v = inflater.inflate(R.layout.dialog_asm_add_khoanthu, null);

        builder.setView(v);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        Button btnClear = v.findViewById(R.id.btnClearThemKhoanThuAsm);
        Button btnAdd = v.findViewById(R.id.btnAddThemKhoanThuAsm);
        EditText edtThemTieuDe = v.findViewById(R.id.edtThemTieuDeKhoanThuAsm);
        EditText edtThemTienThu = v.findViewById(R.id.edtThemTienKhoanThuAsm);
        EditText edtThemNgayThu = v.findViewById(R.id.edtThemNgayKhoanThuAsm);
        spn = v.findViewById(R.id.spnKhoanThuAsm);
        getdataSpn(spn);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String, String> hashMap = (HashMap<String, String>) spn.getSelectedItem();
                if(edtThemTieuDe.getText().toString().isEmpty() ||
                        edtThemTienThu.getText().toString().isEmpty() ||
                        edtThemNgayThu.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }
                int maLoai = Integer.parseInt(hashMap.get("MALOAI"));
                String tieude = edtThemTieuDe.getText().toString();
                double tien = Double.parseDouble(edtThemTienThu.getText().toString());
                String ngay = edtThemNgayThu.getText().toString();

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
                edtThemTienThu.setText("");
                edtThemNgayThu.setText("");
            }
        });
    }
}