package com.skypro.java8.course_work_2.service;

import com.skypro.java8.course_work_2.exception.ArgumentQuestionRepeatsAnswer;
import com.skypro.java8.course_work_2.exception.IncorrectQuestionOrAnswer;
import com.skypro.java8.course_work_2.exception.ObjectNotFound;
import com.skypro.java8.course_work_2.exception.StorageIsEmpty;
import com.skypro.java8.course_work_2.repository.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JavaQuestionServiceTest {
    JavaQuestionService out = new JavaQuestionService();

    @BeforeEach
    public void setOut() {
        out.add("Example question 1", "Example answer 1");
    }

    @Test
    public void shouldAddQuestion() {
        Question actual = out.add("Example question 3", "Example answer 3");
        Question expected = new Question("Example question 3", "Example answer 3");
        assertThat(actual).isEqualTo(expected);

    }
    @Test
    public void shouldAddQuestionAsObject() {
        Question add = new Question("Example question 3", "Example answer 3");
        Question actual = out.add(add);
        Question expected = new Question("Example question 3", "Example answer 3");
        assertThat(actual).isEqualTo(expected);

    }


    @Test
    public void shouldRemoveQuestion() {
        Question remove = new Question("Example question 1", "Example answer 1");
        Question actual = out.remove(remove);
        Question expected = new Question("Example question 1", "Example answer 1");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldGetAll() {
        Collection<Question> actual = out.getAll();
        Collection<Question> expected = new HashSet<>();
        Question all = new Question("Example question 1", "Example answer 1");
        expected.add(all);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldReturnRandomQuestion() {
        Question actual = out.getRandomQuestion();
        Question expected = new Question("Example question 1", "Example answer 1");
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void shouldCallThrowExceptionInJavaQuestionServiceAdd() {
        assertThrows(ArgumentQuestionRepeatsAnswer.class, () -> out.add("Example question 1", "Example question 1"));
        assertThrows(IncorrectQuestionOrAnswer.class, () -> out.add("Example question 1", null));
        assertThrows(IncorrectQuestionOrAnswer.class, () -> out.add(null, "Example answer 1"));

    }
    @Test
    public void shouldCallThrowExceptionInJavaQuestionServiceRemove() {
        Question remove = new Question("Example question 1", "Example answer 1");
        out.remove(remove);
        assertThrows(StorageIsEmpty.class, () -> out.getRandomQuestion());
        assertThrows(ObjectNotFound.class, () -> out.remove(remove));
    }




}
