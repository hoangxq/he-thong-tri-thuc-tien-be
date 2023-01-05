package com.demo.dto.request;

import lombok.Data;

@Data
public class CaseDataReq {
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
}
