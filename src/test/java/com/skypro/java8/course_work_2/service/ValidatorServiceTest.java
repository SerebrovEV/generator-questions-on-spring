package com.skypro.java8.course_work_2.service;

import com.skypro.java8.course_work_2.exception.ArgumentQuestionRepeatsAnswer;
import com.skypro.java8.course_work_2.exception.IncorrectQuestionOrAnswer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidatorServiceTest {

    ValidatorService out = new ValidatorService();

    @Test
    public void shouldCallThrowExceptionInJavaQuestionServiceAdd() {
        assertThrows(ArgumentQuestionRepeatsAnswer.class, () -> out.checkQuestion("Example question 1", "Example question 1"));
        assertThrows(IncorrectQuestionOrAnswer.class, () -> out.checkQuestion("Example question 1", null));
        assertThrows(IncorrectQuestionOrAnswer.class, () -> out.checkQuestion(null, "Example answer 1"));
    }

}
