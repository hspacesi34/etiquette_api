package com.etiquette.GlobalExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.etiquette.User.dtos.ReadUserDto;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice // Utilisé pour les APIs REST (équivalent de @ControllerAdvice + @ResponseBody)
public class GlobalExceptionHandler {

    Map<String, Object> body = new HashMap<>();

    public ResponseEntity<?> handleSuccesfullRequest(String message, ReadUserDto user) {
        this.body.put("timestamp", LocalDateTime.now());
        this.body.put("status", HttpStatus.OK.value());
        this.body.put("message", message);
        if (user != null) {
            this.body.put("user", user);
        }
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    public ResponseEntity<?> handleSuccesfullRequestIterable(String message, Iterable<ReadUserDto> users) {
        this.body.put("timestamp", LocalDateTime.now());
        this.body.put("status", HttpStatus.OK.value());
        this.body.put("message", message);
        if (users != null) {
            this.body.put("users", users);
        }
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    public ResponseEntity<?> handleEntityAlreadyExists(String message) {
        this.body.put("timestamp", LocalDateTime.now());
        this.body.put("status", HttpStatus.PRECONDITION_FAILED.value());
        this.body.put("message", message);
        return new ResponseEntity<>(body, HttpStatus.PRECONDITION_FAILED);
    }

    public ResponseEntity<?> handleEntityNotFound(String message) {
        this.body.put("timestamp", LocalDateTime.now());
        this.body.put("status", HttpStatus.NOT_FOUND.value());
        this.body.put("message", message);
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
