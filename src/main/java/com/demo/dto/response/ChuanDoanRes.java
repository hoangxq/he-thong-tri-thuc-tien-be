package com.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ChuanDoanRes {
    private Double doTuongDongMax;
    private List<CaseDataRes> listCaseDataRes;
    private CaseDataRes caseDataRes;
}
