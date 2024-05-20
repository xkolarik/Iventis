package com.baeldung.apiswagger.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CompraNotFoundException.class)
    public ResponseEntity<?> handleCompraNotFoundException(CompraNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(
                HttpStatus.NOT_FOUND.value(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    // Classe interna para detalhamento do erro
    public static class ErrorDetails {
        private int status;
        private String message;
        private String details;

        public ErrorDetails(int status, String message, String details) {
            super();
            this.status = status;
            this.message = message;
            this.details = details;
        }

        // Getters e Setters
        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }
    }
}