package com.example.demo052701.service.Impl;

import com.example.demo052701.entity.Score;
import com.example.demo052701.mapper.ScoreMapper;
import com.example.demo052701.service.ScoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    private final ScoreMapper scoreMapper;

    public ScoreServiceImpl(ScoreMapper scoreMapper) {
        this.scoreMapper = scoreMapper;
    }

    @Override
    public List<Score> findScoreByUserId(Integer userId) {
        return userId == null ? List.of() : scoreMapper.findByUserId(userId);
    }
}
