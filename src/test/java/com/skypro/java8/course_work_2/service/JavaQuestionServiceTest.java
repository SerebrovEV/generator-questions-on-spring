package com.skypro.java8.course_work_2.service;

import com.skypro.java8.course_work_2.exception.ObjectNotFoundException;
import com.skypro.java8.course_work_2.exception.StorageIsEmptyException;
import com.skypro.java8.course_work_2.repository.JavaQuestionRepository;
import com.skypro.java8.course_work_2.model.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {

    @Mock
    JavaQuestionRepository javaQuestionRepository;
    @Mock
    ValidatorService validatorService;
    @InjectMocks
    JavaQuestionService out;


    @Test
    public void shouldAddQuestionAsString() {
        Question add1 = new Question("Example question 1", "Example answer 1");
        when(validatorService.checkQuestion(any(),any())).thenReturn(add1);
        when(javaQuestionRepository.add(add1)).thenReturn(add1);
        Question actual = out.add("Example question 1", "Example answer 1");
        Question expected = new Question("Example question 1", "Example answer 1");
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    public void shouldAddQuestionAsObject() {
        Question add1 = new Question("Example question 1", "Example answer 1");
        when(validatorService.checkQuestion(any(),any())).thenReturn(add1);
        when(javaQuestionRepository.add(add1)).thenReturn(add1);
        Question actual = out.add(add1);
        Question expected = new Question("Example question 1", "Example answer 1");
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    public void shouldRemoveQuestion() {
        Question remove = new Question("Example question 1", "Example answer 1");
        when(validatorService.checkQuestion(any(),any())).thenReturn(remove);
        when(javaQuestionRepository.remove(any())).thenReturn(remove);
        Question actual = out.remove(remove);
        Question expected = new Question("Example question 1", "Example answer 1");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldGetAll() {
        Set<Question> add = new HashSet<>();
        Question add1 = new Question("Example question 1", "Example answer 1");
        add.add(add1);
        when(javaQuestionRepository.getAll()).thenReturn(add);
        Collection<Question> actual = out.getAll();
        Collection<Question> expected = new HashSet<>();
        Question all = new Question("Example question 1", "Example answer 1");
        expected.add(all);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldReturnRandomQuestion() {
        Set<Question> add = new HashSet<>();
        Question add1 = new Question("Example question 1", "Example answer 1");
        add.add(add1);
        when(javaQuestionRepository.size()).thenReturn(1);
        when(javaQuestionRepository.getAll()).thenReturn(add);
        Question actual = out.getRandomQuestion();
        Question expected = new Question("Example question 1", "Example answer 1");
        assertThat(actual).isEqualTo(expected);
    }


    @Test
    public void shouldCallThrowExceptionInJavaQuestionServiceRemove() {
        Question remove = new Question("Example question 2", "Example answer 2");
        when(javaQuestionRepository.remove(remove)).thenThrow(new ObjectNotFoundException());
        assertThrows(StorageIsEmptyException.class, () -> out.getRandomQuestion());
        assertThrows(ObjectNotFoundException.class, () -> out.remove(remove));
    }


}
