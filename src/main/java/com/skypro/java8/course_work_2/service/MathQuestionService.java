package com.skypro.java8.course_work_2.service;

import com.skypro.java8.course_work_2.exception.ArgumentQuestionRepeatsAnswer;
import com.skypro.java8.course_work_2.exception.IncorrectQuestionOrAnswer;
import com.skypro.java8.course_work_2.exception.ObjectNotFoundException;
import com.skypro.java8.course_work_2.exception.StorageIsEmptyException;
import com.skypro.java8.course_work_2.repository.MathQuestionRepository;
import com.skypro.java8.course_work_2.repository.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MathQuestionService implements QuestionService {

    // private final Set<Question> mathQuestions = new HashSet<>();
    private final Random random = new Random();

    private final MathQuestionRepository mathQuestions;

    public MathQuestionService(MathQuestionRepository mathQuestions) {
        this.mathQuestions = mathQuestions;
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
        mathQuestions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        checkQuestion(question.getQuestion(), question.getAnswer());
        mathQuestions.remove(question);
        return question;
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
        return  mathQuestions.size();
    }
}
