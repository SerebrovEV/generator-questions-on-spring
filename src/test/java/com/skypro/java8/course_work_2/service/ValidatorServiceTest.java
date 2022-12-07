package com.skypro.java8.course_work_2.service;

import com.skypro.java8.course_work_2.exception.ArgumentQuestionRepeatsAnswerException;
import com.skypro.java8.course_work_2.exception.IncorrectQuestionOrAnswerException;
import com.skypro.java8.course_work_2.model.Question;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidatorServiceTest {

    ValidatorService out = new ValidatorService();

    @Test
    public void shouldCheckQuestion() {
       Question actual = out.checkQuestion("Example question 1","Example answer 1");
       Question expected = new Question("Example question 1","Example answer 1");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldCallThrowExceptionInValidatorServiceAdd() {
        assertThrows(ArgumentQuestionRepeatsAnswerException.class, () -> out.checkQuestion("Example question 1", "Example question 1"));
        assertThrows(IncorrectQuestionOrAnswerException.class, () -> out.checkQuestion("Example question 1", null));
        assertThrows(IncorrectQuestionOrAnswerException.class, () -> out.checkQuestion(null, "Example answer 1"));
    }

}
