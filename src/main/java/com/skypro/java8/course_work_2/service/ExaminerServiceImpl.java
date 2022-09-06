package com.skypro.java8.course_work_2.service;

import com.skypro.java8.course_work_2.exception.IncorrectNumberForQuestions;
import com.skypro.java8.course_work_2.repository.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final JavaQuestionService javaQuestionService;
    private final MathQuestionService mathQuestionService;
    private final Random random = new Random();

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService, MathQuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }
//    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService questionService) {
//        this.questionService = questionService;
//    }

    private int maxQuestionsNumber() {
        int maxNumber = mathQuestionService.size() + javaQuestionService.size();
        return maxNumber;
    }

    private int randomGenerator() {
      return random.nextInt(2);
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > maxQuestionsNumber() || amount < 0) {
            throw new IncorrectNumberForQuestions();
        }
        Set<Question> questionsList = new HashSet<>();
        while (questionsList.size() != amount) {

            if (randomGenerator() > 0) {
                questionsList.add(javaQuestionService.getRandomQuestion());
            } else {
                questionsList.add(mathQuestionService.getRandomQuestion());
            }
        }
        return questionsList;
    }
}
