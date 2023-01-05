package com.demo.exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class ExceptionControllerAdvice {
    @ExceptionHandler({Exception.class})
    public ResponseEntity<String> unknownErrorHandler(Exception e) {
        log.error("Unexpected Exception", e);
        String errMsg = "Unknown error";
        return ResponseEntity.status(500).body(errMsg);
    }
}
