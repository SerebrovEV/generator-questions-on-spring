package com.skypro.java8.course_work_2.service;

import com.skypro.java8.course_work_2.exception.IncorrectNumberForQuestions;
import com.skypro.java8.course_work_2.repository.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final Random random = new Random();
    private final List<QuestionService> questionServices;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService, MathQuestionService mathQuestionService) {
        this.questionServices = new ArrayList<>(List.of(javaQuestionService, mathQuestionService));
    }

    private int maxNumberQuestion() {
        return (10 + questionServices.get(0).size());
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > maxNumberQuestion() || amount < 0) {
            throw new IncorrectNumberForQuestions();
        }
        Set<Question> questionsList = new HashSet<>();
        while (questionsList.size() != amount) {
            if (questionServices.get(0).size() != 0) {
                questionsList.add(questionServices.get(random.nextInt(2)).getRandomQuestion());
            }else {
                questionsList.add(questionServices.get(1).getRandomQuestion());
            }
        }
        return questionsList;
    }
}
