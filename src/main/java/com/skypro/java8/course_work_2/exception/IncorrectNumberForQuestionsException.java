package com.skypro.java8.course_work_2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class IncorrectNumberForQuestionsException extends RuntimeException{
}
