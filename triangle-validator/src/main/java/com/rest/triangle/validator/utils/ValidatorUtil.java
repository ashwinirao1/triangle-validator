package com.rest.triangle.validator.utils;

import static com.rest.triangle.validator.constants.ErrorConstants.INVALID_TRIANGLE_TYPE;
import static com.rest.triangle.validator.enums.TriangleType.EQUILATERAL;
import static com.rest.triangle.validator.enums.TriangleType.ISOSCELES;
import static com.rest.triangle.validator.enums.TriangleType.SCALENE;

/**
 * The Class ValidatorUtil.
 */
public class ValidatorUtil {

    /**
     * Checks if is valid triangle.
     * @param sideOne the side one
     * @param sideTwo the side two
     * @param sideThree the side three
     * @return true, if is valid triangle
     */
    public static boolean isValidTriangle(double sideOne, double sideTwo, double sideThree) {
        return ((sideOne + sideTwo) > sideThree) && ((sideOne + sideThree) > sideTwo) && ((sideThree + sideTwo) > sideOne);
    }

    /**
     * Gets the type of triangle.
     * @param sideOne the side one
     * @param sideTwo the side two
     * @param sideThree the side three
     * @return the type of triangle
     */
    public static String getTypeOfTriangle(double sideOne, double sideTwo, double sideThree) {
        if (!isValidTriangle(sideOne, sideTwo, sideThree)) {
            return INVALID_TRIANGLE_TYPE;
        } else if ((sideOne == sideTwo) && (sideTwo == sideThree)) {
            return EQUILATERAL.name();
        } else if ((sideOne == sideTwo) || (sideOne == sideThree) || (sideTwo == sideThree)) {
            return ISOSCELES.name();
        } else {
            return SCALENE.name();
        }
    }
}
