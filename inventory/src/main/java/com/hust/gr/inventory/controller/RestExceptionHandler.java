package com.hust.gr.inventory.controller;

import com.hust.gr.inventory.exception.BadRequestException;
import com.hust.gr.inventory.exception.PermissionDeniedException;
import com.hust.gr.inventory.exception.ResourceNotFoundException;
import com.hust.gr.inventory.model.dto.ErrorResponseDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException e,
                                                                  WebRequest webRequest) {
        return handleExceptionInternal(e, null, new HttpHeaders(), HttpStatus.NOT_FOUND, webRequest);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleBadRequestException(BadRequestException e, WebRequest webRequest) {
        return handleExceptionInternal(e, null, new HttpHeaders(), HttpStatus.BAD_REQUEST, webRequest);
    }

    @ExceptionHandler(PermissionDeniedException.class)
    public ResponseEntity<Object> handlePermissionDeniedException(PermissionDeniedException e, WebRequest webRequest) {
        return handleExceptionInternal(e, null, new HttpHeaders(), HttpStatus.BAD_REQUEST, webRequest);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body,
                                                             HttpHeaders headers, HttpStatus status,
                                                             WebRequest request) {
        return buildResponse(ex.getMessage(), status);
    }

    private ResponseEntity<Object> buildResponse(String message, HttpStatus status) {
        ErrorResponseDTO response = new ErrorResponseDTO();
        response.setMessage(message);
        response.setStatus(status);
        response.setTimestamp(LocalDateTime.now());
        return ResponseEntity.status(status).body(response);
    }
}
