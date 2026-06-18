package com.example.demo052701.controller;

import com.example.demo052701.entity.ExamRecord;
import com.example.demo052701.service.ExamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ExamController {

    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @GetMapping("/exams")
    public String exams(Integer userId, Model model) {
        List<ExamRecord> records = userId == null ? examService.findAll() : examService.findByUserId(userId);
        model.addAttribute("records", records);
        model.addAttribute("userId", userId);
        if (records.isEmpty()) {
            model.addAttribute("msg", userId == null ? "暂无考试记录" : "没有查到该学号的考试记录");
        }
        return "exams";
    }

    @GetMapping("/getExamByUserId")
    public String getExamByUserId(Integer userId, Model model) {
        return exams(userId, model);
    }
}
