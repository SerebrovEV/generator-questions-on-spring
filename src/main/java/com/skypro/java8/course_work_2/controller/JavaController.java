package com.skypro.java8.course_work_2.controller;

import com.skypro.java8.course_work_2.repository.Question;
import com.skypro.java8.course_work_2.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/java")
public class JavaController {
    private final QuestionService questionService;

    public JavaController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(path = "/add")
    public Question addQuestion(@RequestParam("question") String question,
                                @RequestParam ("answer")String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping(path = "/remove")
    public Question removeQuestion(@RequestParam("question") String question,
                                @RequestParam ("answer")String answer) {
        Question questionRemove = new Question(question, answer);
        return questionService.remove(questionRemove);
    }

    @GetMapping
    public Collection<Question> getQuestion() {
        return questionService.getAll();
    }

}
