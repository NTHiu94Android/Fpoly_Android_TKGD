package com.example.tkgd_android.Asm.Fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tkgd_android.Asm.Dao.KhoanThuChiDAO;
import com.example.tkgd_android.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;

public class AsmThongKeFragment extends Fragment implements OnChartValueSelectedListener {
    private PieChart pieChart;
    private KhoanThuChiDAO khoanThuChiDAO;
    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_asm_thong_ke, container, false);
        pieChart = view.findViewById(R.id.piechart_asm);
        pieChart.setRotationEnabled(true);
        pieChart.setDescription(new Description());
        pieChart.setHoleRadius(35f);
        pieChart.setTransparentCircleAlpha(0);
        pieChart.setCenterText("Thống kê");
        pieChart.setCenterTextSize(16);
        pieChart.setDrawEntryLabels(true);

        khoanThuChiDAO = new KhoanThuChiDAO(getActivity());

        addDataSet(pieChart);
        return view;
    }

    private void addDataSet(PieChart pieChart) {
        ArrayList<PieEntry> yEntrys = new ArrayList<>();
        ArrayList<String> xEntrys = new ArrayList<>();
        float[] yData = khoanThuChiDAO.getThongTinThuChi();
        String[] xData = { "Khoản thu", "Khoản chi" };

        for (int i = 0; i < yData.length;i++){
            yEntrys.add(new PieEntry(yData[i],i));
        }
        for (int i = 0; i < xData.length;i++){
            xEntrys.add(xData[i]);
        }

        PieDataSet pieDataSet = new PieDataSet(yEntrys,"Khoản thu/Khoản chi");
        pieDataSet.setSliceSpace(3);
        pieDataSet.setValueTextSize(14);

        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.GREEN);
        colors.add(Color.YELLOW);

        pieDataSet.setColors(colors);

        Legend legend=pieChart.getLegend();
        legend.setForm(Legend.LegendForm.SQUARE);
        legend.setFormSize(16);
        legend.setTextSize(16);
        legend.setTextColor(Color.BLACK);

        PieData pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);
        pieChart.invalidate();
    }
}