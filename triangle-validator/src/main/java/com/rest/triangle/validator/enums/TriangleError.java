package com.rest.triangle.validator.enums;


/**
 * The Enum TriangleError.
 */
public enum TriangleError {

    CONSTRAINT_EMPTY("triangle.empty.constraint"), CONSTRAINT_NEGATIVE("triangle.negative.constraint"), CONSTRAINT_ZERO("triangle.zero.constraint"), CONSTRAINT_INVALID("triangle.invalid.constraint");


    /** The error type. */
    private final String errorType;

    /**
     * Instantiates a new Triangle error.
     * @param errorType the error type
     */
    private TriangleError(final String errorType) {
        this.errorType = errorType;
    }

    @Override
    public String toString() {
        return errorType;
    }

}
