package com.springbootacedamy.oderoderdetailsmapstruct.adviser;


import com.springbootacedamy.oderoderdetailsmapstruct.exception.NotFoundException;
import com.springbootacedamy.oderoderdetailsmapstruct.exception.ValidateException;
import com.springbootacedamy.oderoderdetailsmapstruct.util.StandedResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice


//400 - bad request
//404-not found
//500- internal serve error
public class AppWideExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandedResponse> notFoundHandler(NotFoundException notFoundException){

        return new ResponseEntity<StandedResponse>(
                new StandedResponse(404,"error",notFoundException.getMessage()),
                        HttpStatus.NOT_FOUND
                );
    }

    @ExceptionHandler(ValidateException.class)
    public ResponseEntity<StandedResponse> validateExceptionHandler(ValidateException validateException){

        return new ResponseEntity<StandedResponse>(
                new StandedResponse(400,"error",validateException.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandedResponse> validateExceptionHandler(Exception exception){

        return new ResponseEntity<StandedResponse>(
                new StandedResponse(500,"error",exception.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
