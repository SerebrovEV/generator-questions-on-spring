package com.skypro.java8.course_work_2.repository;


import com.skypro.java8.course_work_2.model.Question;

import java.util.Collection;

public interface QuestionRepository {


    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    int size();
}
