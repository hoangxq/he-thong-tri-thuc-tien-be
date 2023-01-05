package com.demo.service;

import com.demo.dto.request.CaseDataReq;
import com.demo.dto.response.CaseDataRes;
import com.demo.dto.response.ChuanDoanRes;

import java.util.List;

public interface CaseDataService {
    List<CaseDataRes> getAllCaseDataDone();
    List<CaseDataRes> getAllCaseDataPending();
    ChuanDoanRes chuanDoanBenh(CaseDataReq caseDataReq);
}
