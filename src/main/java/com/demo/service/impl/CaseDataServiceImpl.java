package com.demo.service.impl;

import com.demo.dto.request.CaseDataReq;
import com.demo.dto.response.CaseDataRes;
import com.demo.dto.response.ChuanDoanRes;
import com.demo.model.CaseData;
import com.demo.model.TrangThai;
import com.demo.model.TrongSo;
import com.demo.repository.CaseDataRepository;
import com.demo.service.XuLyDoTuongDong;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CaseDataServiceImpl implements com.demo.service.CaseDataService {
    private final CaseDataRepository caseDataRepository;
    private final ModelMapper modelMapper;
    private final XuLyDoTuongDong xuLyDoTuongDong;

    @Override
    public List<CaseDataRes> getAllCaseDataDone() {
        return caseDataRepository.findAllByTrangThai(TrangThai.DA_XU_LY).stream()
                .map(e -> modelMapper.map(e, CaseDataRes.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CaseDataRes> getAllCaseDataPending() {
        return caseDataRepository.findAllByTrangThai(TrangThai.DANG_XU_LY).stream()
                .map(e -> modelMapper.map(e, CaseDataRes.class))
                .collect(Collectors.toList());
    }

    @Override
    public ChuanDoanRes chuanDoanBenh(CaseDataReq caseDataReq) {
        var listCaseDataRes = caseDataRepository.findAllByTrangThai(TrangThai.DA_XU_LY).stream()
                .filter(e -> e.equals(modelMapper.map(caseDataReq, CaseData.class)))
                .map(e -> modelMapper.map(e, CaseDataRes.class)).collect(Collectors.toList());
        if (listCaseDataRes.size() > 0)
            return new ChuanDoanRes(1.0, listCaseDataRes, listCaseDataRes.get(0));

        var listCase = caseDataRepository.findAllByTrangThai(TrangThai.DA_XU_LY);
        double doTuongDongMax = 0.0;
        List<CaseData> listCaseMax = new ArrayList<>();

        for (int i = 0; i < listCase.size(); i++){
            var item = listCase.get(i);
            double doTuongDongdoTuongDonggioiTinh = xuLyDoTuongDong.gioiTinh(caseDataReq.getGioiTinh(), item.getGioiTinh());
            double doTuongDongTuoi = xuLyDoTuongDong.tuoi(caseDataReq.getTuoi(), item.getTuoi());
            double doTuongDongTinhTrangNguc = xuLyDoTuongDong.tinhTrangNguc(caseDataReq.getTinhTrangNguc(), item.getTinhTrangNguc());
            double doTuongDongHuyetAp = xuLyDoTuongDong.huyetAp(caseDataReq.getHuyetAp(), item.getHuyetAp());
            double doTuongDongNongDoCholesterol = xuLyDoTuongDong.nongDoCholesterol(caseDataReq.getNongDoCholesterol(), item.getNongDoCholesterol());
            double doTuongDongHaDuongTrongMau = xuLyDoTuongDong.haDuongTrongMau(caseDataReq.getHaDuongTrongMau(), item.getHaDuongTrongMau());
            double doTuongDongKetQuaDoDienTim = xuLyDoTuongDong.ketQuaDoDienTim(caseDataReq.getKetQuaDoDienTim(), item.getKetQuaDoDienTim());
            double doTuongDongNhipTim = xuLyDoTuongDong.nhipTim(caseDataReq.getNhipTim(), item.getNhipTim());
            double doTuongDongViemHong = xuLyDoTuongDong.viemHong(caseDataReq.getViemHong(), item.getViemHong());
            double doTuongDongDoLomSongDienTim = xuLyDoTuongDong.doLomSongDienTim(caseDataReq.getDoLomSongDienTim(), item.getDoLomSongDienTim());
            double doTuongDongDoDocDinhCaoNhatSongST = xuLyDoTuongDong.doDocDinhCaoNhatSongST(caseDataReq.getDoDocDinhCaoNhatSongST(), item.getDoDocDinhCaoNhatSongST());

            double doTuongDongtrungBinh = (doTuongDongdoTuongDonggioiTinh * TrongSo.GIOI_TINH +
                    doTuongDongTuoi * TrongSo.TUOI +
                    doTuongDongTinhTrangNguc * TrongSo.TINH_TRANG_NGUC +
                    doTuongDongHuyetAp * TrongSo.HUYET_AP +
                    doTuongDongNongDoCholesterol * TrongSo.ONG_DO_CHOLESTEROL +
                    doTuongDongHaDuongTrongMau * TrongSo.HA_DUONG_TRONG_MAU +
                    doTuongDongKetQuaDoDienTim * TrongSo.KET_QUA_DIEN_TIM +
                    doTuongDongNhipTim * TrongSo.NHIP_TIM +
                    doTuongDongViemHong * TrongSo.VIEM_HONG +
                    doTuongDongDoLomSongDienTim * TrongSo.DO_LOM_SONG_DIEN_TIM +
                    doTuongDongDoDocDinhCaoNhatSongST * TrongSo.DUONG_DOC_SONG_DIEN_TIM) / TrongSo.TONG_TRONG_SO;

            if (doTuongDongtrungBinh > doTuongDongMax){
                doTuongDongMax = doTuongDongtrungBinh;
                if (listCaseMax.size() > 0) listCaseMax = new ArrayList<>();
                listCase.add(item);
            } else if (doTuongDongtrungBinh == doTuongDongMax && doTuongDongMax != 0)
                listCaseMax.add(item);
        }

        var caseHandle = modelMapper.map(caseDataReq, CaseData.class);
        caseHandle.setTrangThai(TrangThai.DANG_XU_LY);
        caseHandle.setKetQua(false);

        if (doTuongDongMax >= 0.9){
            if (listCaseMax.get(0).getKetQua()) {
                caseHandle.setChuanDoan("Chắc chắn mắc bệnh");
            } else caseHandle.setChuanDoan("Chắc chắn không mắc bệnh");
        } else if (doTuongDongMax >= 0.8){
            if (listCaseMax.get(0).getKetQua()) {
                caseHandle.setChuanDoan("Tỷ lệ cao mắc bệnh");
            } else caseHandle.setChuanDoan("Tỷ lệ cao không mắc bệnh");
        } else if (doTuongDongMax >= 0.5){
            if (listCaseMax.get(0).getKetQua()) {
                caseHandle.setChuanDoan("Nghi ngờ mắc bệnh");
            } else caseHandle.setChuanDoan("Có khả năng không mắc bệnh");
        } else if (doTuongDongMax > 0){
            caseHandle.setChuanDoan("Cần theo dõi thêm, nếu có triệu chứng khác thì quay lại.");
        } else {
            caseHandle.setChuanDoan("Không kết luận được");
        }
        caseDataRepository.save(caseHandle);

        return new ChuanDoanRes(doTuongDongMax, listCaseMax.stream()
                .map(e -> modelMapper.map(e, CaseDataRes.class)).collect(Collectors.toList()),
                modelMapper.map(caseHandle, CaseDataRes.class));
    }
}
