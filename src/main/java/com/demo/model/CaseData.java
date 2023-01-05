package com.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tbl_case_data")
@Data
public class CaseData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "gioi_tinh")
    private String gioiTinh;
    @Column(name = "tuoi")
    private Integer tuoi;
    @Column(name = "tinh_trang_nguc")
    private String tinhTrangNguc;
    @Column(name = "huyet_ap")
    private Integer huyetAp;
    @Column(name = "nong_do_cholesterol")
    private Integer nongDoCholesterol;
    @Column(name = "ha_duong_trong_mau")
    private Boolean haDuongTrongMau;
    @Column(name = "ket_qua_do_dien_tim")
    private String ketQuaDoDienTim;
    @Column(name = "nhip_tim")
    private Integer nhipTim;
    @Column(name = "viem_hong")
    private Boolean viemHong;
    @Column(name = "do_lom_song_dien_tim")
    private float doLomSongDienTim;
    @Column(name = "do_doc_dinh_cao_nhat_song_st")
    private String doDocDinhCaoNhatSongST;
    @Column(name = "bi_benh")
    private Boolean ketQua;
    @Column(name = "trang_thai")
    private String trangThai;
    @Column(name = "chuan_doan")
    private String chuanDoan;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaseData caseData = (CaseData) o;
        return Float.compare(caseData.doLomSongDienTim, doLomSongDienTim) == 0 && Objects.equals(gioiTinh, caseData.gioiTinh) && Objects.equals(tuoi, caseData.tuoi) && Objects.equals(tinhTrangNguc, caseData.tinhTrangNguc) && Objects.equals(huyetAp, caseData.huyetAp) && Objects.equals(nongDoCholesterol, caseData.nongDoCholesterol) && Objects.equals(haDuongTrongMau, caseData.haDuongTrongMau) && Objects.equals(ketQuaDoDienTim, caseData.ketQuaDoDienTim) && Objects.equals(nhipTim, caseData.nhipTim) && Objects.equals(viemHong, caseData.viemHong) && Objects.equals(doDocDinhCaoNhatSongST, caseData.doDocDinhCaoNhatSongST);
    }
}
