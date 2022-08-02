package com.example.tkgd_android.Asm.Modul;

public class KhoanThuChi {
    private int maGiaoDich;
    private String tieuDe;
    private String ngay;
    private double tien;
    private int maLoai;

    public KhoanThuChi(int maGiaoDich, String tieuDe, String ngay, double tien, int maLoai) {
        this.maGiaoDich = maGiaoDich;
        this.tieuDe = tieuDe;
        this.ngay = ngay;
        this.tien = tien;
        this.maLoai = maLoai;
    }
    public KhoanThuChi(String tieuDe, String ngay, double tien, int maLoai) {
        this.tieuDe = tieuDe;
        this.ngay = ngay;
        this.tien = tien;
        this.maLoai = maLoai;
    }

    public int getMaGiaoDich() {
        return maGiaoDich;
    }

    public void setMaGiaoDich(int maGiaoDich) {
        this.maGiaoDich = maGiaoDich;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public double getTien() {
        return tien;
    }

    public void setTien(double tien) {
        this.tien = tien;
    }

    public int getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }
}
