package com.demo.dto.response;

import lombok.Data;

@Data
public class CaseDataRes {
    private Long id;
    private String gioiTinh;
    private Integer tuoi;
    private String tinhTrangNguc;
    private Integer huyetAp;
    private Integer nongDoCholesterol;
    private Boolean haDuongTrongMau;
    private String ketQuaDoDienTim;
    private Integer nhipTim;
    private Boolean viemHong;
    private float doLomSongDienTim;
    private String doDocDinhCaoNhatSongST;
    private Boolean ketQua;
    private String trangThai;
    private String chuanDoan;
}
