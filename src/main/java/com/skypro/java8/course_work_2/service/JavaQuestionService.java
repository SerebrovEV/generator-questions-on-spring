package com.skypro.java8.course_work_2.service;

import com.skypro.java8.course_work_2.exception.ArgumentQuestionRepeatsAnswer;
import com.skypro.java8.course_work_2.exception.IncorrectQuestionOrAnswer;
import com.skypro.java8.course_work_2.exception.StorageIsEmptyException;
import com.skypro.java8.course_work_2.repository.JavaQuestionRepository;
import com.skypro.java8.course_work_2.repository.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    // private final Set<Question> javaQuestions = new HashSet<>();
    private final Random random = new Random();

    private final JavaQuestionRepository javaQuestionRepository;
    @Autowired
    public JavaQuestionService(JavaQuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }


    private void checkQuestion(String question, String answer) {
        if (question == null || answer == null) {
            throw new IncorrectQuestionOrAnswer();
        }
        if (question.equals(answer)) {
            throw new ArgumentQuestionRepeatsAnswer();
        }
    }


    @Override
    public Question add(String question, String answer) {
        Question questionAdd = new Question(question, answer);
        return add(questionAdd);
    }

    @Override
    public Question add(Question question) {
        checkQuestion(question.getQuestion(), question.getAnswer());
        javaQuestionRepository.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        checkQuestion(question.getQuestion(), question.getAnswer());
        javaQuestionRepository.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return javaQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        if (javaQuestionRepository.size() == 0) {
            throw new StorageIsEmptyException();
        }
        int value = random.nextInt(javaQuestionRepository.size());
        List<Question> questionList = new ArrayList<>(javaQuestionRepository.getAll());
        return questionList.get(value);
    }

    public int size() {
      return  javaQuestionRepository.size();
    }

}
