package com.skypro.java8.course_work_2.service;

import com.skypro.java8.course_work_2.exception.ArgumentQuestionRepeatsAnswer;
import com.skypro.java8.course_work_2.exception.IncorrectNumberForQuestions;
import com.skypro.java8.course_work_2.exception.IncorrectQuestionOrAnswer;
import com.skypro.java8.course_work_2.repository.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JavaQuestionServiceTest {
    JavaQuestionService out = new JavaQuestionService();
    JavaQuestionService out2 = new JavaQuestionService();

    @BeforeEach
    public void setOut() {
        out.add("Example question 1", "Example answer 1");
        out2.add("Example question 2", "Example answer 2");
    }
    @Test
    public void shouldAddQuestion() {
        Question expected = out.add("Example question 3", "Example answer 3");
        Question actual = new Question("Example question 3", "Example answer 3");
        assertEquals(expected, actual);

    }
    @Test
    public void shouldAddQuestionAsObject() {
        Question add = new Question("Example question 3", "Example answer 3");
        Question expected = out.add(add);
        Question actual = new Question("Example question 3", "Example answer 3");
        assertEquals(expected, actual);

    }


    @Test
    public void shouldRemoveQuestion() {
        Question remove = new Question("Example question 3", "Example answer 3");
        Question expected = out.remove(remove);
        Question actual = new Question("Example question 3", "Example answer 3");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetAll() {
        Collection<Question> expected = out.getAll();
        Collection<Question> actual = new HashSet<>();
        Question all = new Question("Example question 1", "Example answer 1");
        actual.add(all);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnRandomQuestion() {
        Question expected = out.getRandomQuestion();
        Question actual = new Question("Example question 1", "Example answer 1");
        assertEquals(expected, actual);
    }
    @Test
    public void shouldCallThrowExceptionInEmployeeService() {
        assertThrows(ArgumentQuestionRepeatsAnswer.class, () -> out.add("Example question 1", "Example question 1"));
        assertThrows(IncorrectQuestionOrAnswer.class, () -> out.add("Example question 1", null));
        assertThrows(IncorrectQuestionOrAnswer.class, () -> out.add(null, "Example answer 1"));
    }

}
