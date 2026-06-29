package com.campus360.backend.common.exception;

import com.campus360.backend.common.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ApiResponse<Object>> handleDuplicateResourceException(DuplicateResourceException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(
                        ApiResponse.failure(ex.getMessage())
                );
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(
                        ApiResponse.failure(ex.getMessage())
                );
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiResponse<Object>> handleBadRequestException(BadRequestException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(
                        ApiResponse.failure(ex.getMessage())
                );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleGenericException(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(
                        ApiResponse.failure("Something went wrong. Please try again later.")
                );
    }

    public ResponseEntity<ApiResponse<Map<String, String>>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> validationErrors = new LinkedHashMap<>();

        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            validationErrors.put(
                    fieldError.getField(),
                    fieldError.getDefaultMessage()
            );
        }

        return ResponseEntity
                .badRequest()
                .body(
                        ApiResponse.failure(
                                "Validation failed.",
                                validationErrors
                        )
                );
    }
}
