package com.skypro.java8.course_work_2.service;

import com.skypro.java8.course_work_2.exception.StorageIsEmptyException;
import com.skypro.java8.course_work_2.repository.MathQuestionRepository;
import com.skypro.java8.course_work_2.repository.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MathQuestionService implements QuestionService {

    // private final Set<Question> mathQuestions = new HashSet<>();
    private final Random random = new Random();

    private final ValidatorService validatorService;

    private final MathQuestionRepository mathQuestions;

    public MathQuestionService(ValidatorService validatorService, MathQuestionRepository mathQuestions) {
        this.mathQuestions = mathQuestions;
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
        return mathQuestions.add(question);

    }

    @Override
    public Question remove(Question question) {
        validatorService.checkQuestion(question.getQuestion(), question.getAnswer());
        return mathQuestions.remove(question);
    }

//    @Override
//    public Question find(Question question) {
//        return mathQuestions.stream()
//                .filter(q -> q.equals(question))
//                .findFirst()
//                .orElseThrow(ObjectNotFoundException::new);
//    }

    @Override
    public Collection<Question> getAll() {
        return mathQuestions.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        if (size() == 0) {
            throw new StorageIsEmptyException();
        }
        int value = random.nextInt(size());
        List<Question> questionList = new ArrayList<>(mathQuestions.getAll());
        return questionList.get(value);
    }

    public int size() {
        return mathQuestions.size();
    }
}
