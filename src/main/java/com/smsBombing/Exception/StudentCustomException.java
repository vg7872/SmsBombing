package com.smsBombing.Exception;

import com.smsBombing.DTO.Response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Map;
//etake custom exception bole jetar through te globallyu exception handle kora ay..
@ControllerAdvice
@Slf4j
public class StudentCustomException {

    @ExceptionHandler(StudentException.class)
    public ResponseEntity<ErrorResponse> handleStudentNotFound(StudentException ex) {
        log.info("Checking logs...");
        ErrorResponse errorResponse =  ErrorResponse.builder()
                .errorCode(1001)
                .errorMessage(ex.getMessage())
                .statusCode(1)
                .build();
        log.info("Checking logs...2...");
//        ex.getMessage()
        return  ResponseEntity.ok(errorResponse);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> handleNullPointerException(NullPointerException ex) {
        log.info("Checking logs...");
        ErrorResponse errorResponse =  ErrorResponse.builder()
                .errorCode(1002)
                .errorMessage(ex.getMessage())
                .statusCode(1)
                .build();
        log.info("Checking logs...2...");
//        ex.getMessage()
        return  ResponseEntity.ok(errorResponse);
    }
}
