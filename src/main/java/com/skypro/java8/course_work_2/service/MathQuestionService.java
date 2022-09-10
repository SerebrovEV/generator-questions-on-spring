package com.skypro.java8.course_work_2.service;

import com.skypro.java8.course_work_2.exception.MetodNotFoundException;
import com.skypro.java8.course_work_2.repository.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MathQuestionService implements QuestionService {

    private final List<Question> questions = new ArrayList<>(List.of(
            new Question("Сотая часть числа?","Процент."),
            new Question("Что легче: 1 кг ваты или 1 кг железа?","Одинаково."),
            new Question("Может ли при умножении получиться ноль?","Да."),
            new Question("Чему равна четверть часа?","15 мин."),
            new Question("Сумма углов треугольника?","180."),
            new Question("График функции у = kx + b?","Прямая."),
            new Question("Утка получила 9 долларов, паук — 36 долларов, пчела — 27 долларов." +
                    " Основываясь на этой информации, сколько денег дадут кошке?","18 долларов (4,50 доллара за лапу)."),
            new Question("Наука, изучающая свойства фигур на плоскости?","Планиметрия."),
            new Question("Где можно прибавить 2 к 11 и получить 1?","На часах."),
            new Question("Прибор для измерения углов?","Транспортир.")));
    private final Random random = new Random();


    @Override
    public Question add(String question, String answer) {
        throw new MetodNotFoundException();
    }

    @Override
    public Question add(Question question) {
        throw new MetodNotFoundException();

    }

    @Override
    public Question remove(Question question) {
        throw new MetodNotFoundException();
    }


    @Override
    public Collection<Question> getAll() {
        throw new MetodNotFoundException();
    }

    @Override
    public Question getRandomQuestion() {
        int value = random.nextInt(size());
        return questions.get(value);
    }

    @Override
    public int size() {
      return questions.size();
    }

}
