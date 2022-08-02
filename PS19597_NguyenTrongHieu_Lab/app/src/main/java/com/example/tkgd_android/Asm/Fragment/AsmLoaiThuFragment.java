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
import com.example.tkgd_android.Asm.Adapter.LoaiThuAdapter;
import com.example.tkgd_android.Asm.Dao.LoaiThuChiDAO;
import com.example.tkgd_android.Asm.Modul.LoaiThuChi;
import com.example.tkgd_android.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

public class AsmLoaiThuFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AsmLoaiThuFragment() {
        // Required empty public constructor
    }
    // TODO: Rename and change types and number of parameters
    public static AsmLoaiThuFragment newInstance(String param1, String param2) {
        AsmLoaiThuFragment fragment = new AsmLoaiThuFragment();
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

    private FloatingActionButton flButton;
    private RecyclerView rvLoaiThu;
    private LoaiThuChiDAO loaiThuChiDAO;
    private LoaiThuAdapter loaiThuAdapter;
    private ArrayList<LoaiThuChi> list = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_asm_loai_thu, container, false);
        flButton = view.findViewById(R.id.btnFloatTingLoaiThuAsm);
        rvLoaiThu = view.findViewById(R.id.rcLoaiThuAsm);

        loaiThuChiDAO = new LoaiThuChiDAO(getActivity());
        getData();

        rvLoaiThu.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                if(dy>0){
                    flButton.hide();
                }else{
                    flButton.show();
                }
                super.onScrolled(recyclerView, dx, dy);
            }
        });
        flButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogThemLoaiThu();
            }
        });
        return view;
    }

    private void getData(){
        list.clear();
        list = loaiThuChiDAO.getAllPLThu();
        loaiThuAdapter = new LoaiThuAdapter();
        loaiThuAdapter.setData(list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvLoaiThu.setLayoutManager(layoutManager);

        rvLoaiThu.setAdapter(loaiThuAdapter);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        rvLoaiThu.addItemDecoration(itemDecoration);
    }

    private void dialogThemLoaiThu() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getLayoutInflater();
        View v = inflater.inflate(R.layout.dialog_asm_add_loaithu, null);

        builder.setView(v);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        EditText edtLoaiThuMoiAsm = v.findViewById(R.id.edtThemTenLoaiThuAsm);

        Button btnClear = v.findViewById(R.id.btnClearThemLoaiThuAsm);
        Button btnAdd = v.findViewById(R.id.btnAddThemLoaiThuAsm);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtLoaiThuMoiAsm.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Điền đủ thông tin!", Toast.LENGTH_SHORT).show();
                    return;
                }
                String loaiThuMoi = edtLoaiThuMoiAsm.getText().toString();
                LoaiThuChi loaiThuChi = new LoaiThuChi(loaiThuMoi, "THU");
                loaiThuChiDAO.themThuChi(loaiThuChi);
                getData();
                Toast.makeText(getActivity(), "Thêm mới thành công!", Toast.LENGTH_SHORT).show();
                alertDialog.dismiss();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtLoaiThuMoiAsm.setText("");
            }
        });
    }
}