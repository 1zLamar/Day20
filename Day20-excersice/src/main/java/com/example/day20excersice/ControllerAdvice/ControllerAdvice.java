package com.example.day20excersice.ControllerAdvice;

import com.example.day20excersice.ApiException.ApiException;
import com.example.day20excersice.ApiResponse.ApiResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@org.springframework.web.bind.annotation.ControllerAdvice


public class ControllerAdvice {

    @ExceptionHandler(value = ApiException.class)

    public ResponseEntity<ApiResponse> ApiException(ApiException a){
        String msg=a.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(msg));
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> MethodArgumentNotValidException(MethodArgumentNotValidException a){
        String msg=a.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(msg));
    }
    @ExceptionHandler(value = DataIntegrityViolationException.class)

    public ResponseEntity<ApiResponse> DataIntegrityViolationException(DataIntegrityViolationException a){
        String msg=a.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(msg));
    }
    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ApiResponse> MethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException a){
        String msg=a.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(msg));
    }
}

