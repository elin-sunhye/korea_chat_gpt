package com.korit.korit_gpt_java_springboot.controller.advice;

import com.korit.korit_gpt_java_springboot.dto.response.common.BadRequestResponseDto;
import com.korit.korit_gpt_java_springboot.dto.response.common.NotFoundResponseDto;
import com.korit.korit_gpt_java_springboot.exception.CustomDuplicateKeyException;
import com.sun.jdi.request.DuplicateRequestException;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalRestControllerAdvice {

//    요청한 조건에 대한 데이터가 없음!
    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<NotFoundResponseDto<?>> notFound(NotFoundException e) {
        return ResponseEntity.status(404).body(new NotFoundResponseDto<>(e.getMessage()));
    }

//    요청 자체가 잘못됨! 사용자 잘못
    @ExceptionHandler(value = CustomDuplicateKeyException.class)
    public  ResponseEntity<BadRequestResponseDto<?>> duplicateKey(CustomDuplicateKeyException e) {
        return ResponseEntity.status(400).body(new BadRequestResponseDto<>(e.getErrors()));
    }

//    Validation
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<BadRequestResponseDto<?>> validation(ConstraintViolationException e) {
        return ResponseEntity.status(400).body(new BadRequestResponseDto<>(
                e.getConstraintViolations()
                        .stream()
                        .map(constraintViolation -> Map.of(constraintViolation.getPropertyPath(), constraintViolation.getMessage()))
                        .collect(Collectors.toList())
        ));
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<BadRequestResponseDto<?>> validation(MethodArgumentNotValidException e) {
        List<Map<String, String>> errorMap = null;
        BindingResult bindingResult = e.getBindingResult();
        if(bindingResult.hasErrors()) {
            errorMap = bindingResult.getFieldErrors()
                    .stream()
                    .map(fieldError -> Map.of(fieldError.getField(), fieldError.getDefaultMessage()))
                    .collect(Collectors.toList());
        }
        return ResponseEntity.status(400).body(new BadRequestResponseDto<>(errorMap));
    }
}
