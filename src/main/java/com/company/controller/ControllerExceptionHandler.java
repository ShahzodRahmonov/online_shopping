package com.company.controller;

import com.company.exceptions.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    @ExceptionHandler({CategoryNotFoundException.class})
    public ResponseEntity<?> handlerException(RuntimeException e) {
        log.error(e.getMessage());
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler({ProductNotFoundException.class})
    public ResponseEntity<?> handlerException(ProductNotFoundException e) {
        log.error(e.getMessage());
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler({CustomerNotFoundException.class})
    public ResponseEntity<?> handlerException(CustomerNotFoundException e) {
        log.error(e.getMessage());
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler({InvoiceNotFoundException.class})
    public ResponseEntity<?> handlerException(InvoiceNotFoundException e) {
        log.error(e.getMessage());
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler({OrderNotFoundException.class})
    public ResponseEntity<?> handlerException(OrderNotFoundException e) {
        log.error(e.getMessage());
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler({PaymentNotFoundException.class})
    public ResponseEntity<?> handlerException(PaymentNotFoundException e) {
        log.error(e.getMessage());
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler({OrderFailedException.class})
    public ResponseEntity<?> handlerException(OrderFailedException e) {
        log.error(e.getMessage());
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
