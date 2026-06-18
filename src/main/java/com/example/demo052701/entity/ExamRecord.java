package com.example.demo052701.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExamRecord {
    private Integer id;
    private Integer userId;
    private String examName;
    private String subject;
    private Double score;
    private Double totalScore;
    private String status;
    private LocalDateTime submitTime;
    private String remark;
}
