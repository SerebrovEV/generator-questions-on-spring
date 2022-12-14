package com.skypro.java8.course_work_2.repository;

import com.skypro.java8.course_work_2.exception.ObjectNotFoundException;
import com.skypro.java8.course_work_2.model.Question;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

//repository for java questions
@Repository
public class JavaQuestionRepository implements QuestionRepository {

    //collection questions
    private final Set<Question> javaQuestions = new HashSet<>();

    @Override
    public Question add(Question question) {
        javaQuestions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (javaQuestions.remove(question)) {
            return question;
        }
        throw new ObjectNotFoundException();
    }

    @Override
    public Set<Question> getAll() {
        return javaQuestions;
    }

    @Override
    public int size() {
        return javaQuestions.size();
    }
}
