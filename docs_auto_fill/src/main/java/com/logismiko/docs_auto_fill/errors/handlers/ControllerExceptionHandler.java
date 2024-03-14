package com.logismiko.docs_auto_fill.errors.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * Служит для перехвата и обработки ошибок в контроллерах, для этого
 * контроллер должен реализовать данный интерфейс.
 */
public interface ControllerExceptionHandler {
    /**
     * Перехватывает ошибки валидации входящих ДТО и выводим их описание из ДТО.
     * @param argumentNotValidException Ошибка валидации.
     * @return HashMap, где ключ - имя параметра не прошедшего валидацию, а
     * значение - сообщение описывающее ошибку валидации.
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    default Map<String, String> handleValidationExceptions(
        MethodArgumentNotValidException argumentNotValidException
    ) {
        Map<String, String> errors = new HashMap<>();
        argumentNotValidException
            .getBindingResult()
            .getAllErrors()
            .forEach(error -> {
                String fieldName = ((FieldError) error).getField();
                String errorMassage = error.getDefaultMessage();
                errors.put(fieldName, errorMassage);
            });
        return errors;
    }
}
