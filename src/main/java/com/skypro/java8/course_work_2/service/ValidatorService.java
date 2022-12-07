package com.skypro.java8.course_work_2.service;

import com.skypro.java8.course_work_2.exception.ArgumentQuestionRepeatsAnswerException;
import com.skypro.java8.course_work_2.exception.IncorrectQuestionOrAnswerException;
import com.skypro.java8.course_work_2.model.Question;
import org.springframework.stereotype.Service;

//service for check question
@Service
public class ValidatorService {
    public Question checkQuestion(String question, String answer) {
        if (question == null || answer == null) {
            throw new IncorrectQuestionOrAnswerException();
        }
        if (question.equals(answer)) {
            throw new ArgumentQuestionRepeatsAnswerException();
        }
        return new Question(question, answer);
    }

}
