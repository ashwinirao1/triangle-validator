package com.rest.triangle.validator.controller.advice;

import com.rest.triangle.validator.constants.GenericConstants;
import com.rest.triangle.validator.exceptions.InvalidTriangleException;
import com.rest.triangle.validator.model.GenericError;
import com.rest.triangle.validator.response.GenericResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The Class GlobalControllerExceptionHandler.
 */
@ControllerAdvice
class GlobalControllerExceptionHandler {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);


    /**
     * Handle invalid triangle.
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler({ InvalidTriangleException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<GenericResponse> handleInvalidTriangleRequest(final InvalidTriangleException exception) {
        LOGGER.error(exception.getMessage(), exception);
        return new ResponseEntity<GenericResponse>(getExceptionResponse(exception.getErrorMap(), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
    }

    /**
     * Gets the exception response.
     * @param errorMap the error Map
     * @param code the code
     * @return the exception response
     */
    private GenericResponse getExceptionResponse(Map<Integer, String> errorMap, int httpErrorCode) {
        List<GenericError> errors = new ArrayList<>();
        errorMap.forEach((key, value) -> {
            GenericError newError = new GenericError();
            newError.setErrorCode(key);
            newError.setErrorMessage(value);
            errors.add(newError);
        });
        return new GenericResponse(GenericConstants.FAILURE, errors, httpErrorCode);
    }

}