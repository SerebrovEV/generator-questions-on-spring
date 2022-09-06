package com.skypro.java8.course_work_2.controller;


import com.skypro.java8.course_work_2.repository.Question;
import com.skypro.java8.course_work_2.service.ExaminerService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/get")
public class ExamController {
private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }
@GetMapping()
    public Collection<Question> getQuestions(@RequestParam("amount") int amount) {
        return examinerService.getQuestions(amount);
    }
}
