package com.skypro.java8.course_work_2.repository;

import com.skypro.java8.course_work_2.exception.ObjectNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class MathQuestionRepository implements QuestionRepository{

    Set<Question> mathQuestions = new HashSet<>();
    @Override
    public Question add(Question question) {
        mathQuestions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {

        if (mathQuestions.remove(question)) {
            return question;
        }
        throw new ObjectNotFoundException();
    }

    @Override
    public Collection<Question> getAll() {
        return mathQuestions;
    }

    @Override
    public int size() {
        return mathQuestions.size();
    }
}
