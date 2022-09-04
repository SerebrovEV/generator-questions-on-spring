package com.skypro.java8.course_work_2.service;

import com.skypro.java8.course_work_2.exception.IncorrectNumberForQuestions;
import com.skypro.java8.course_work_2.repository.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.size()|| amount < 0) {
            throw new IncorrectNumberForQuestions();
        }
        Set<Question> questionsList = new HashSet<>();
        while (!(questionsList.size() == amount)){
            questionsList.add(questionService.getRandomQuestion());
        }
        return questionsList;
    }
}
