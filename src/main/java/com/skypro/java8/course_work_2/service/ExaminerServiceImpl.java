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
        if (amount > questionService.size()) {
            throw new IncorrectNumberForQuestions();
        }
        List<Question> questionsList = new ArrayList<>();
        int counter = 0;
        while (!(counter == amount)){
            if (!questionsList.contains(questionService.getRandomQuestion())) {
                questionsList.add(questionService.getRandomQuestion());
                counter ++;
            }
        }
        return questionsList;
    }
}
