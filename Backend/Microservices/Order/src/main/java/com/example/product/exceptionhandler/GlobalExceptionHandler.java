package com.example.product.exceptionhandler;

import com.example.product.dto.ApiResponse;
import com.example.product.exceptionhandler.customexceptions.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleGenericException(Exception ex) {
        ex.printStackTrace();
        return createApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred.");
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleProductNotFoundException(ProductNotFoundException ex) {
        return createApiResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    private ResponseEntity<ApiResponse<String>> createApiResponse(HttpStatus status, String message) {
        ApiResponse<String> response = new ApiResponse<>();
        response.setCode(status.value());
        response.setStatus("error");
        response.setMessage(message);
        response.setValidationErrors(null);
        response.setRequestedTime(System.currentTimeMillis());
        response.setExecutionTime("0 ms");
        response.setResponse(null);
        return new ResponseEntity<>(response, status);
    }
}
