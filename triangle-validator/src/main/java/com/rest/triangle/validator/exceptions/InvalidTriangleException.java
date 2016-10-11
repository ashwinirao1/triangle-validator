package com.rest.triangle.validator.exceptions;

import java.util.Map;

/**
 * The Class InvalidTriangleException.
 */
public class InvalidTriangleException extends RuntimeException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7339031952826090428L;

    /** The error map. */
    private Map<Integer, String> errorMap;

    public InvalidTriangleException(Map<Integer, String> errorMap) {
        super("Invalid Triangle.");
        this.errorMap = errorMap;
    }

    /**
     * @return the errorMap
     */
    public Map<Integer, String> getErrorMap() {
        return errorMap;
    }

    /**
     * @param errorMap the errorMap to set
     */
    public void setErrorMap(Map<Integer, String> errorMap) {
        this.errorMap = errorMap;
    }

}
