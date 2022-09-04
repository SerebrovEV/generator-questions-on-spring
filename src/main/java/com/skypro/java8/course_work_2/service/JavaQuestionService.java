package com.skypro.java8.course_work_2.service;

import com.skypro.java8.course_work_2.exception.ArgumentQuestionRepeatsAnswer;
import com.skypro.java8.course_work_2.exception.IncorrectQuestionOrAnswer;
import com.skypro.java8.course_work_2.exception.ObjectNotFound;
import com.skypro.java8.course_work_2.exception.StorageIsEmpty;
import com.skypro.java8.course_work_2.repository.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();

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
        add(questionAdd);
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
        if (questions.remove(question)) {
            return question;
        }
        throw new ObjectNotFound();
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.size() == 0) {
            throw new StorageIsEmpty();
        }
        int value = random.nextInt(questions.size());
        List<Question> questionList = new ArrayList<>(questions);
        return questionList.get(value);
    }

    @Override
    public int size() {
        return questions.size();
    }
}
