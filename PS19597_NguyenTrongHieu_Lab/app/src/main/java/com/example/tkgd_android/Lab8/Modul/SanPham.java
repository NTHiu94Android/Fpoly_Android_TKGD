package com.example.tkgd_android.Lab8.Modul;

public class SanPham {
    private String title;
    private int image;

    public SanPham(String title, int image) {
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
