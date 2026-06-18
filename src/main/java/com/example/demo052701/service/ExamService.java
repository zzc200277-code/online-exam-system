package com.example.demo052701.service;

import com.example.demo052701.entity.ExamRecord;

import java.util.List;

public interface ExamService {
    List<ExamRecord> findAll();

    List<ExamRecord> findByUserId(Integer userId);
}
