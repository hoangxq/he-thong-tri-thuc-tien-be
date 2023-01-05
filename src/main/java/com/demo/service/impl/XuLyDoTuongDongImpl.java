package com.demo.service.impl;

import com.demo.service.XuLyDoTuongDong;
import org.springframework.stereotype.Service;

@Service
public class XuLyDoTuongDongImpl implements XuLyDoTuongDong {

    @Override
    public double ketQuaDoDienTim(String req, String source) {
        if(req.equals(source)) return 1;
        switch (req) {
            case "Bình thường" : {
                return 0;
            }
            case "Có sóng ST-T bất thường" : {
                if ("Phì đại thất trái".equals(source)) {
                    return 0.4;
                }
                return 0;
            }
            case "Phì đại thất trái" : {
                if ("Có sóng ST-T bất thường".equals(source)) {
                    return 0.4;
                }
                return 0;
            }
            default: return 0;
        }
    }

    @Override
    public double doDocDinhCaoNhatSongST(String req, String source) {
        if (req.equals(source)) return 1;
        switch (req) {
            case "Dốc lên" :
            case "Dốc xuống" : {
                if ("Bằng phẳng".equals(source)) {
                    return 0.2;
                }
                return 0;
            }
            case "Bằng phẳng" : {
                switch (source) {
                    case "Dốc lên" : return 0.1;
                    case "Dốc xuống" : return 0.2;
                    default: return 0;
                }
            }
            default: return 0;
        }
    }

    @Override
    public double tinhTrangNguc(String req, String source) {
        if (req.equals(source)) return 1;
        switch (req) {
            case "Đau thắt ngực ổn định": {
                switch (source) {
                    case "Đau thắt ngực không ổn định": return 0.3;
                    case "Đau thắt ngực prinzmetal": return 0.2;
                    default: return 0;
                }
                
            }
            case "Đau thắt ngực không ổn định": {
                switch (source) {
                    case "Đau thắt ngực ổn định": return 0.3;
                    case "Đau thắt ngực prinzmetal": return 0.4;
                    default: return 0;
                }
            }
            case "Đau thắt ngực prinzmetal": {
                switch (source) {
                    case "Đau thắt ngực ổn định": return 0.2;
                    case "Đau thắt ngực không ổn định": return 0.4;
                    default: return 0;
                }
            }
            default: return 0;
        }
    }

    @Override
    public double gioiTinh(String req, String source) {
        return req.equals(source) ? 1 : 0;
    }

    @Override
    public double tuoi(int req, int source) {
        return req == source ? 1 : 0;
    }

    @Override
    public double huyetAp(int req, int source) {
        return req == source ? 1 : 0;
    }

    @Override
    public double nongDoCholesterol(int req, int source) {
        return req == source ? 1 : 0;
    }

    @Override
    public double haDuongTrongMau(boolean req, boolean source) {
        return req == source ? 1 : 0;
    }

    @Override
    public double nhipTim(int req, int source) {
        return req == source ? 1 : 0;
    }

    @Override
    public double viemHong(boolean req, boolean source) {
        return req == source ? 1 : 0;
    }

    @Override
    public double doLomSongDienTim(float req, float source) {
        return req == source ? 1 : 0;
    }

}