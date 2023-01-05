package com.demo.service;

public interface XuLyDoTuongDong {
    double gioiTinh(String req, String source);
    double tuoi(int req, int source);
    double tinhTrangNguc(String req, String source);
    double huyetAp(int req, int source);
    double nongDoCholesterol(int req, int source);
    double haDuongTrongMau(boolean req, boolean source);
    double ketQuaDoDienTim(String req, String source);
    double nhipTim(int req, int source);
    double viemHong(boolean req, boolean source);
    double doLomSongDienTim(float req, float source);
    double doDocDinhCaoNhatSongST(String req, String source);
}