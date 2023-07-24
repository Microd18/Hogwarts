package ru.hogwarts.school.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SchoolExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(SchoolExceptionHandler.class);

    @ExceptionHandler(
            {
                    FacultyNotFoundException.class,
                    StudentNotFoundException.class,
                    AvatarNotFoundException.class
            }
    )
    public ResponseEntity<?> handleNotFound(RuntimeException e) {
        LOGGER.error(e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

}
