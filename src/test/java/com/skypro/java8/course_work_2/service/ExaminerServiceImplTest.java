package com.skypro.java8.course_work_2.service;

import com.skypro.java8.course_work_2.exception.IncorrectNumberForQuestionsException;
import com.skypro.java8.course_work_2.model.Question;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.HashSet;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    JavaQuestionService javaQuestionService;
    @Mock
    MathQuestionService mathQuestionService;
    @InjectMocks
    ExaminerServiceImpl out;

    @Test
    public void shouldGiveQuestion() {
        Question add = new Question("Example question 1", "Example answer 1");
        Question add2 = new Question("Example question 2", "Example answer 2");
        Question add3 = new Question("Example question 3", "Example answer 3");
        Question add4 = new Question("Example question 11", "Example answer 11");
        Question add5 = new Question("Example question 22", "Example answer 22");
        Question add6 = new Question("Example question 33", "Example answer 33");
        when(javaQuestionService.getRandomQuestion()).thenReturn(add, add2, add3);
        when(mathQuestionService.getRandomQuestion()).thenReturn(add4, add5, add6);
        when(javaQuestionService.size()).thenReturn(3);
        when(mathQuestionService.size()).thenReturn(3);
        Collection<Question> expected = new HashSet<>();
        expected.add(add);
        expected.add(add2);
        expected.add(add3);
        expected.add(add4);
        expected.add(add5);
        expected.add(add6);
        assertThat(out.getQuestions(6)).isEqualTo(expected);
        ;
    }

    @Test
    public void shouldCallThrowExceptionInExaminerService() {
        assertThatExceptionOfType(IncorrectNumberForQuestionsException.class).
                isThrownBy(() -> out.getQuestions(1));
    }
}
