package com.example.demo052701.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Score {
    private Integer id;
    private Integer userid;
    private String courseName;
    private Double score;
    private String remark;
    private LocalDateTime createTime;
}
