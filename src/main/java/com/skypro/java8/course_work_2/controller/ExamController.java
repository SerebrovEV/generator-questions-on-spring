package com.skypro.java8.course_work_2.controller;


import com.skypro.java8.course_work_2.repository.Question;
import com.skypro.java8.course_work_2.service.ExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/get")
public class ExamController {
private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }
@GetMapping
    public Collection<Question> getQuestions(int amount) {
        return examinerService.getQuestions(amount);
    }
}
