package com.example.demo052701.controller;

import com.example.demo052701.entity.Score;
import com.example.demo052701.service.ScoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Comparator;
import java.util.List;

@Controller
public class ScoreController {

    private final ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @GetMapping("/getScoreByUserId")
    public String getScoreById(Integer userid, Model model) {
        List<Score> scoreResult = scoreService.findScoreByUserId(userid);
        model.addAttribute("ScoreResult", scoreResult);
        model.addAttribute("userid", userid);

        if (userid == null) {
            model.addAttribute("msg", "请输入学号");
            return "score";
        }
        if (scoreResult.isEmpty()) {
            model.addAttribute("msg", "没有查到该学号的成绩");
            return "score";
        }

        double total = scoreResult.stream().mapToDouble(Score::getScore).sum();
        double average = total / scoreResult.size();
        double max = scoreResult.stream().mapToDouble(Score::getScore).max().orElse(0);
        double min = scoreResult.stream().mapToDouble(Score::getScore).min().orElse(0);
        long excellentCount = scoreResult.stream().filter(item -> item.getScore() >= 90).count();
        long warningCount = scoreResult.stream().filter(item -> item.getScore() < 60).count();
        Score bestCourse = scoreResult.stream().max(Comparator.comparingDouble(Score::getScore)).orElse(null);
        Score weakestCourse = scoreResult.stream().min(Comparator.comparingDouble(Score::getScore)).orElse(null);

        model.addAttribute("totalScore", round(total));
        model.addAttribute("averageScore", round(average));
        model.addAttribute("highestScore", round(max));
        model.addAttribute("lowestScore", round(min));
        model.addAttribute("excellentCount", excellentCount);
        model.addAttribute("warningCount", warningCount);
        model.addAttribute("bestCourse", bestCourse);
        model.addAttribute("weakestCourse", weakestCourse);

        return "score";
    }

    private double round(double value) {
        return Math.round(value * 10) / 10.0;
    }
}
