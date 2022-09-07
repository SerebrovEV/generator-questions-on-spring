package com.skypro.java8.course_work_2.service;

import com.skypro.java8.course_work_2.exception.ObjectNotFoundException;
import com.skypro.java8.course_work_2.exception.StorageIsEmptyException;
import com.skypro.java8.course_work_2.repository.MathQuestionRepository;
import com.skypro.java8.course_work_2.repository.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MathQuestionServiceTest {


    @Mock
    MathQuestionRepository mathQuestionRepository;
    @Mock
    ValidatorService validatorService;
    @InjectMocks
    MathQuestionService out;


    @Test
    public void shouldAddQuestionAsString() {
        Question add1 = new Question("Example question 11", "Example answer 11");
        when(validatorService.checkQuestion(any(), any())).thenReturn(add1);
        when(mathQuestionRepository.add(add1)).thenReturn(add1);
        Question actual = out.add("Example question 11", "Example answer 11");
        Question expected = new Question("Example question 11", "Example answer 11");
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    public void shouldAddQuestionAsObject() {
        Question add1 = new Question("Example question 11", "Example answer 11");
        when(validatorService.checkQuestion(any(), any())).thenReturn(add1);
        when(mathQuestionRepository.add(add1)).thenReturn(add1);
        Question actual = out.add(add1);
        Question expected = new Question("Example question 11", "Example answer 11");
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    public void shouldRemoveQuestion() {
        Question remove = new Question("Example question 11", "Example answer 11");
        when(validatorService.checkQuestion(any(), any())).thenReturn(remove);
        when(mathQuestionRepository.remove(any())).thenReturn(remove);
        Question actual = out.remove(remove);
        Question expected = new Question("Example question 11", "Example answer 11");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldGetAll() {
        Set<Question> add = new HashSet<>();
        Question add1 = new Question("Example question 11", "Example answer 11");
        add.add(add1);
        when(mathQuestionRepository.getAll()).thenReturn(add);
        Collection<Question> actual = out.getAll();
        Collection<Question> expected = new HashSet<>();
        Question all = new Question("Example question 11", "Example answer 11");
        expected.add(all);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldReturnRandomQuestion() {
        Set<Question> add = new HashSet<>();
        Question add1 = new Question("Example question 11", "Example answer 11");
        add.add(add1);
        when(mathQuestionRepository.size()).thenReturn(1);
        when(mathQuestionRepository.getAll()).thenReturn(add);
        Question actual = out.getRandomQuestion();
        Question expected = new Question("Example question 11", "Example answer 11");
        assertThat(actual).isEqualTo(expected);
    }


    @Test
    public void shouldCallThrowExceptionInJavaQuestionServiceRemove() {
        Question remove = new Question("Example question 22", "Example answer 22");
        when(mathQuestionRepository.remove(remove)).thenThrow(new ObjectNotFoundException());
        assertThrows(StorageIsEmptyException.class, () -> out.getRandomQuestion());
        assertThrows(ObjectNotFoundException.class, () -> out.remove(remove));
    }


}
