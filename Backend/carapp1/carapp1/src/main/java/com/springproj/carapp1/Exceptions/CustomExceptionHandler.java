package com.springproj.carapp1.Exceptions;

import Exceptions.CarNotFoundException;
import Exceptions.GeneralException;
import Exceptions.InvalidRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CustomExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(CustomExceptionHandler.class);
        @ExceptionHandler(InvalidRequestException.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        public ResponseEntity<Exceptions.GeneralException> handleBadRequestException(
                final InvalidRequestException exception, final WebRequest request) {
            log.error(exception.getMessage());
            return new ResponseEntity<>(
                    prepareCustomErrorResponse(
                            HttpStatus.BAD_REQUEST, exception.getMessage(), request.getDescription(false)),
                    HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(CarNotFoundException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        public ResponseEntity<Exceptions.GeneralException> handleNotFoundException(
                final CarNotFoundException exception, final WebRequest request) {
            log.error(exception.getMessage());
            return new ResponseEntity<>(
                    prepareCustomErrorResponse(
                            HttpStatus.NOT_FOUND, exception.getMessage(), request.getDescription(false)),
                    HttpStatus.NOT_FOUND);
        }


        private Exceptions.GeneralException prepareCustomErrorResponse(
                final HttpStatus httpStatus, final String message, final String details) {
            final Exceptions.GeneralException error = new GeneralException();
            error.setTimestamp(LocalDateTime.now());
            error.setError(httpStatus.getReasonPhrase());
            error.setStatus(httpStatus.value());
            error.setMessage(message);
            error.setDetails(details);

            return error;
        }
    }






