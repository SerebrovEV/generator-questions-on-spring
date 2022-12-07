package com.skypro.java8.course_work_2.controller;


import com.skypro.java8.course_work_2.model.Question;
import com.skypro.java8.course_work_2.service.ExaminerService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
//controller for user
@RestController
@RequestMapping("/get")
public class ExamController {
private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }
@GetMapping("/{amount}")
    public Collection<Question> getQuestions(@PathVariable ("amount")int amount) {
        return examinerService.getQuestions(amount);
    }
}
