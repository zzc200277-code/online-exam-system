package com.example.demo052701.service;

import com.example.demo052701.entity.Score;

import java.util.List;

public interface ScoreService {
    List<Score> findScoreByUserId(Integer userId);
}
