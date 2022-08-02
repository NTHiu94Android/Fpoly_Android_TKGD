package com.example.tkgd_android.Asm.DBHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "quanlythuchi.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE PHANLOAI (MALOAI INTEGER PRIMARY KEY AUTOINCREMENT, TENLOAI TEXT, TRANGTHAI TEXT)");

        sqLiteDatabase.execSQL("CREATE TABLE GIAODICH (MAGIAODICH INTEGER PRIMARY KEY AUTOINCREMENT, TIEUDE TEXT, NGAY TEXT" +
                ",TIEN REAL,MALOAI INTEGER REFERENCES PHANLOAI(MALOAI))");

        sqLiteDatabase.execSQL("INSERT INTO PHANLOAI(TENLOAI, TRANGTHAI) VALUES('Luong', 'THU'),('Thue', 'CHI'),('Giay', 'CHI')");

        sqLiteDatabase.execSQL("INSERT INTO GIAODICH(TIEUDE, NGAY, TIEN, MALOAI) VALUES('LUONG THANG 3', '15-03-2022', 1000, 1)," +
                "('Thue thu nhap', '15-03-2022', 100, 2), ('Giay the thao', '18-03-2022', 20, 3), ('Giay da bong', '11-03-2022', 20, 3)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS PHANLOAI");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS GIAODICH");
        onCreate(sqLiteDatabase);
    }
}
