package com.example.tkgd_android.Asm.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tkgd_android.Asm.DBHelper.DBHelper;
import com.example.tkgd_android.Asm.Modul.KhoanThuChi;

import java.util.ArrayList;

public class KhoanThuChiDAO {
    private DBHelper helper;
    private SQLiteDatabase db;

    public KhoanThuChiDAO(Context context) {
        this.helper = new DBHelper(context);
    }
    public ArrayList<KhoanThuChi> getAllGDChi (){
        ArrayList<KhoanThuChi> list = new ArrayList<>();
        db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM GIAODICH GD INNER JOIN PHANLOAI PL " +
                "ON GD.MALOAI = PL.MALOAI WHERE PL.TRANGTHAI LIKE 'CHI'",null);
        if(cursor.getCount() != 0){
            cursor.moveToFirst();
            do {
                int maGiaoDich = cursor.getInt(0);
                String tieuDe = cursor.getString(1);
                String ngay = cursor.getString(2);
                double tien = cursor.getDouble(3);
                int maLoai = cursor.getInt(4);
                KhoanThuChi khoanThuChi = new KhoanThuChi(maGiaoDich, tieuDe, ngay, tien, maLoai);
                list.add(khoanThuChi);
            }while (cursor.moveToNext());
        }
        return list;
    }
    public ArrayList<KhoanThuChi> getAllGDThu (){
        ArrayList<KhoanThuChi> list = new ArrayList<>();
        db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM GIAODICH GD INNER JOIN PHANLOAI PL " +
                "ON GD.MALOAI = PL.MALOAI WHERE PL.TRANGTHAI LIKE 'THU'",null);
        if(cursor.getCount() != 0){
            cursor.moveToFirst();
            do {
                int maGiaoDich = cursor.getInt(0);
                String tieuDe = cursor.getString(1);
                String ngay = cursor.getString(2);
                double tien = cursor.getDouble(3);
                int maLoai = cursor.getInt(4);
                KhoanThuChi khoanThuChi = new KhoanThuChi(maGiaoDich, tieuDe, ngay, tien, maLoai);
                list.add(khoanThuChi);
            }while (cursor.moveToNext());
        }
        return list;
    }
    public void themKhoanThuChi(KhoanThuChi khoanThuChi){
        ContentValues values = new ContentValues();
        db = helper.getWritableDatabase();
        values.put("TIEUDE", khoanThuChi.getTieuDe());
        values.put("NGAY", khoanThuChi.getNgay());
        values.put("TIEN", khoanThuChi.getTien());
        values.put("MALOAI", khoanThuChi.getMaLoai());
        db.insert("GIAODICH", null, values);
    }
    public void suaKhoanThuChi(KhoanThuChi khoanThuChi){
        ContentValues values = new ContentValues();
        db = helper.getWritableDatabase();
        values.put("TIEUDE", khoanThuChi.getTieuDe());
        values.put("NGAY", khoanThuChi.getNgay());
        values.put("TIEN", khoanThuChi.getTien());
        values.put("MALOAI", khoanThuChi.getMaLoai());
        db.update("GIAODICH", values, "MAGIAODICH =?", new String[]{String.valueOf(khoanThuChi.getMaGiaoDich())});
    }
    public void xoaKhoanThuChi(KhoanThuChi khoanThuChi){
        db = helper.getWritableDatabase();
        db.delete("GIAODICH","MAGIAODICH =?",new String[]{String.valueOf(khoanThuChi.getMaGiaoDich())});
    }

    public float[] getThongTinThuChi() {
        db = helper.getReadableDatabase();
        int thu = 0, chi = 0;

        //select sum(tien)
        //from giaodich
        //where maloai in (select maloai from phanloai where thangthai = 'thu')
        Cursor cursorThu = db.rawQuery("select sum(TIEN) from GIAODICH where MALOAI " +
                "in (select MALOAI from PHANLOAI where TRANGTHAI = 'THU') ", null);

        if (cursorThu.getCount() != 0) {
            cursorThu.moveToFirst();
            thu = cursorThu.getInt(0);
        }

        //select sum(tien)
        //from giaodich
        //where maloai in (select maloai from phanloai where thangthai = 'chi')
        Cursor cursorChi = db.rawQuery("select sum(TIEN) from GIAODICH where MALOAI " +
                "in (select MALOAI from PHANLOAI where TRANGTHAI = 'CHI') ", null);

        if (cursorChi.getCount() != 0) {
            cursorChi.moveToFirst();
            chi = cursorChi.getInt(0);
        }

        float[] ketQua = new float[]{thu, chi};
        return ketQua;

    }
}
