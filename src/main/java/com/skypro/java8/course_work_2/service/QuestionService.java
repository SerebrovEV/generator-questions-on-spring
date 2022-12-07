package com.skypro.java8.course_work_2.service;

import com.skypro.java8.course_work_2.model.Question;

import java.util.Collection;

//interface which CRUD method for question service
public interface QuestionService {

    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);


    Collection<Question> getAll();

    Question getRandomQuestion();

    int size();


}
