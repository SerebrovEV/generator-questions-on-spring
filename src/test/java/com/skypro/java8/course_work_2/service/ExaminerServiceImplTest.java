package com.skypro.java8.course_work_2.service;

import com.skypro.java8.course_work_2.repository.Question;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    QuestionService questionService;
    @InjectMocks
    ExaminerServiceImpl out;

    @Test
    public void shouldGiveQuestion() {
        Question add = new Question("Example question 1", "Example answer 1");
        when(questionService.getRandomQuestion()).thenReturn(add);
        when(questionService.size()).thenReturn(1);
        Collection<Question> actual = new ArrayList<>();
        actual.add(add);
        assertEquals(out.getQuestions(1), actual);;
    }


}
