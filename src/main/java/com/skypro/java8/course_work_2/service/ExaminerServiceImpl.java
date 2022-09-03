package com.skypro.java8.course_work_2.service;

import com.skypro.java8.course_work_2.repository.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private QuestionService questionService;

    public ExaminerServiceImpl (QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> questionsList = new HashSet<>();
       // questionsList.add(questionService.getRandomQuestion());
        return questionsList;
    }
}
