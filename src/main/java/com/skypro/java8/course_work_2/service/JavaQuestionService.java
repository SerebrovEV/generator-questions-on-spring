package com.skypro.java8.course_work_2.service;

import com.skypro.java8.course_work_2.exception.IncorrectQuestionOrAnswer;
import com.skypro.java8.course_work_2.repository.Question;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class JavaQuestionService implements QuestionService {

    private Set<Question> questions = new HashSet<>();

    private void checkQuestion(String question, String answer) {
        if (question == null || answer == null) {
            throw new IncorrectQuestionOrAnswer();
        }
    }


    @Override
    public Question add(String question, String answer) {
        checkQuestion(question, answer);
        Question questionAdd = new Question(question, answer);
        questions.add(questionAdd);
        return questionAdd;
    }

    @Override
    public Question add(Question question) {
        checkQuestion(question.getQuestion(), question.getAnswer());
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        checkQuestion(question.getQuestion(), question.getAnswer());
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int value = random.nextInt(questions.size());
        List<Question> questionList = new ArrayList<>(questions.stream().collect(Collectors.toList()));
        Question randomQuestion = questionList.get(value);
        return randomQuestion;
    }

    @Override
    public int size() {
        return questions.size();
    }
}
