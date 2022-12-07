package com.skypro.java8.course_work_2.service;

import com.skypro.java8.course_work_2.exception.IncorrectNumberForQuestionsException;
import com.skypro.java8.course_work_2.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

//service for receiving user questions
@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final JavaQuestionService javaQuestionService;
    private final MathQuestionService mathQuestionService;
    private final Random random = new Random();

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService, MathQuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    //max number question
    private int maxQuestionsNumber() {
        int maxNumber = mathQuestionService.size() + javaQuestionService.size();
        return maxNumber;
    }

    private int randomGenerator() {
        return random.nextInt(2);
    }

    //method for get question with user number from controller
    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > maxQuestionsNumber() || amount < 0) {
            throw new IncorrectNumberForQuestionsException();
        }
        Set<Question> questionsList = new HashSet<>();
        while (questionsList.size() != amount) {
            if (randomGenerator() > 0 && javaQuestionService.size() > 0) {
                questionsList.add(javaQuestionService.getRandomQuestion());
            } else if (mathQuestionService.size() > 0) {
                questionsList.add(mathQuestionService.getRandomQuestion());
            }
        }
        return questionsList;
    }
}
