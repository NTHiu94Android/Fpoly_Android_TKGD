package com.example.tkgd_android.Asm.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tkgd_android.Asm.DBHelper.DBHelper;
import com.example.tkgd_android.Asm.Modul.LoaiThuChi;

import java.util.ArrayList;

public class LoaiThuChiDAO {
    private DBHelper dbHelper;
    private SQLiteDatabase db;

    public LoaiThuChiDAO(Context context) {
        this.dbHelper = new DBHelper(context);
    }

    public ArrayList<LoaiThuChi> getAllPLChi(){
        ArrayList<LoaiThuChi> list = new ArrayList<>();
        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM PHANLOAI WHERE TRANGTHAI = 'CHI'", null);
        if(cursor.getCount() != 0){
            cursor.moveToFirst();
            do {
                int maLoai = cursor.getInt(0);
                String tenLoai = cursor.getString(1);
                String trangThai = cursor.getString(2);
                LoaiThuChi loaiThuChi = new LoaiThuChi(maLoai, tenLoai, trangThai);
                list.add(loaiThuChi);
            }while (cursor.moveToNext());
        }
        return list;
    }
    public ArrayList<LoaiThuChi> getAllPLThu(){
        ArrayList<LoaiThuChi> list = new ArrayList<>();
        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM PHANLOAI WHERE TRANGTHAI = 'THU'", null);
        if(cursor.getCount() != 0){
            cursor.moveToFirst();
            do {
                int maLoai = cursor.getInt(0);
                String tenLoai = cursor.getString(1);
                String trangThai = cursor.getString(2);
                LoaiThuChi loaiThuChi = new LoaiThuChi(maLoai, tenLoai, trangThai);
                list.add(loaiThuChi);
            }while (cursor.moveToNext());
        }
        return list;
    }

    public void themThuChi(LoaiThuChi loaiThuChi){
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("TENLOAI", loaiThuChi.getTenLoai());
        values.put("TRANGTHAI", loaiThuChi.getTrangThai());
        db.insert("PHANLOAI", null, values);
    }
    public void suaThuChi(LoaiThuChi loaiThuChi){
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("TENLOAI", loaiThuChi.getTenLoai());
        values.put("TRANGTHAI", loaiThuChi.getTrangThai());
        db.update("PHANLOAI", values, "MALOAI =?", new String[]{String.valueOf(loaiThuChi.getMaLoai())});
    }
    public void xoaThuChi(LoaiThuChi loaiThuChi){
        db = dbHelper.getWritableDatabase();
        db.delete("PHANLOAI", "MALOAI =?", new String[]{String.valueOf(loaiThuChi.getMaLoai())});
    }
}
