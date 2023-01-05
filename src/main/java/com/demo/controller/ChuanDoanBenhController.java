package com.demo.controller;

import com.demo.dto.request.CaseDataReq;
import com.demo.service.CaseDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chuan-doan-benh")
@CrossOrigin("*")
@RequiredArgsConstructor
public class ChuanDoanBenhController {
    private final CaseDataService caseDataService;

    @GetMapping("/da-xu-ly")
    public ResponseEntity<?> getAllCaseDataDone(){
        return ResponseEntity.ok(caseDataService.getAllCaseDataDone());
    }

    @GetMapping("/dang-xu-ly")
    public ResponseEntity<?> getAllCaseDataPending(){
        return ResponseEntity.ok(caseDataService.getAllCaseDataPending());
    }

    @PostMapping
    public ResponseEntity<?> chuanDoanBenh(@RequestBody CaseDataReq caseDataReq){
        return ResponseEntity.ok(caseDataService.chuanDoanBenh(caseDataReq));
    }
}
