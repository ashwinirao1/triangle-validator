package com.rest.triangle.validator.webvalidators;

import static com.rest.triangle.validator.constants.ErrorConstants.INVALID_TRIANGLE_CODE;
import static com.rest.triangle.validator.constants.ErrorConstants.NEGATIVE_TRIANGLE_CODE;
import static com.rest.triangle.validator.constants.ErrorConstants.ZERO_TRIANGLE_CODE;
import static com.rest.triangle.validator.constants.GenericConstants.TRIANGLE_SIDE_ONE;
import static com.rest.triangle.validator.constants.GenericConstants.TRIANGLE_SIDE_THREE;
import static com.rest.triangle.validator.constants.GenericConstants.TRIANGLE_SIDE_TWO;

import com.rest.triangle.validator.enums.TriangleError;
import com.rest.triangle.validator.model.TriangleInput;
import com.rest.triangle.validator.utils.ValidatorUtil;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * The Class TriangleValidator.
 */
public class TriangleValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return TriangleInput.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors e) {

        ValidationUtils.rejectIfEmptyOrWhitespace(e, TRIANGLE_SIDE_ONE, TriangleError.CONSTRAINT_EMPTY.toString(), INVALID_TRIANGLE_CODE);
        ValidationUtils.rejectIfEmptyOrWhitespace(e, TRIANGLE_SIDE_TWO, TriangleError.CONSTRAINT_EMPTY.toString(), INVALID_TRIANGLE_CODE);
        ValidationUtils.rejectIfEmptyOrWhitespace(e, TRIANGLE_SIDE_THREE, TriangleError.CONSTRAINT_EMPTY.toString(), INVALID_TRIANGLE_CODE);

        double triangleSideOne = ((TriangleInput) target).getSideOne();
        double triangleSideTwo = ((TriangleInput) target).getSideTwo();
        double triangleSideThree = ((TriangleInput) target).getSideThree();

        if (triangleSideOne == 0 || triangleSideTwo == 0 || triangleSideThree == 0) {
            e.reject(TriangleError.CONSTRAINT_ZERO.toString(), ZERO_TRIANGLE_CODE);
        }
        if (triangleSideOne < 0 || triangleSideTwo < 0 || triangleSideThree < 0) {
            e.reject(TriangleError.CONSTRAINT_NEGATIVE.toString(), NEGATIVE_TRIANGLE_CODE);
        }
        if (!ValidatorUtil.isValidTriangle(triangleSideOne, triangleSideTwo, triangleSideThree)) {
            e.reject(TriangleError.CONSTRAINT_INVALID.toString(), INVALID_TRIANGLE_CODE);
        }

    }
}