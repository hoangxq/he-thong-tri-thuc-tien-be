package com.demo.repository;

import com.demo.model.CaseData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CaseDataRepository extends JpaRepository<CaseData, Long> {
    List<CaseData> findAllByTrangThai(String trangThai);
}
