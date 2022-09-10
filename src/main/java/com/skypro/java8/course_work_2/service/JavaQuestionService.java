package com.skypro.java8.course_work_2.service;

import com.skypro.java8.course_work_2.exception.StorageIsEmptyException;
import com.skypro.java8.course_work_2.repository.JavaQuestionRepository;
import com.skypro.java8.course_work_2.repository.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Random random = new Random();

    private final ValidatorService validatorService;

    private final JavaQuestionRepository javaQuestionRepository;
    public JavaQuestionService(ValidatorService validatorService, JavaQuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
        this.validatorService = validatorService;
    }

    @Override
    public Question add(String question, String answer) {
        Question questionAdd = new Question(question, answer);
        return add(questionAdd);
    }

    @Override
    public Question add(Question question) {
        validatorService.checkQuestion(question.getQuestion(), question.getAnswer());
        return javaQuestionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        validatorService.checkQuestion(question.getQuestion(), question.getAnswer());
        return javaQuestionRepository.remove(question);
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
        return javaQuestionRepository.size();
    }

}
