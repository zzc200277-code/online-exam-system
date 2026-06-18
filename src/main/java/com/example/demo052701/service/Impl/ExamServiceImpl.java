package com.example.demo052701.service.Impl;

import com.example.demo052701.entity.ExamRecord;
import com.example.demo052701.mapper.ExamMapper;
import com.example.demo052701.service.ExamService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    private final ExamMapper examMapper;

    public ExamServiceImpl(ExamMapper examMapper) {
        this.examMapper = examMapper;
    }

    @Override
    public List<ExamRecord> findAll() {
        return examMapper.findAll();
    }

    @Override
    public List<ExamRecord> findByUserId(Integer userId) {
        return userId == null ? List.of() : examMapper.findByUserId(userId);
    }
}
