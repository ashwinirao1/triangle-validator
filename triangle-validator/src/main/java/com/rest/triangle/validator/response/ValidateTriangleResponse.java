package com.rest.triangle.validator.response;

import com.rest.triangle.validator.constants.GenericConstants;

/**
 * The Class ValidateTriangleResponse.
 */
public class ValidateTriangleResponse extends GenericResponse {

    private double triangleSideOne;

    private double triangleSideTwo;

    private double triangleSideThree;

    private String triangleType;

    public ValidateTriangleResponse() {

    }
    public ValidateTriangleResponse(double triangleSideOne, double triangleSideTwo, double triangleSideThree, String triangleType) {
        super(GenericConstants.SUCCESS);
        this.triangleSideOne = triangleSideOne;
        this.triangleSideTwo = triangleSideTwo;
        this.triangleSideThree = triangleSideThree;
        this.triangleType = triangleType;
    }

    /**
     * @return the triangleSideOne
     */
    public double getTriangleSideOne() {
        return triangleSideOne;
    }

    /**
     * @param triangleSideOne the triangleSideOne to set
     */
    public void setTriangleSideOne(double triangleSideOne) {
        this.triangleSideOne = triangleSideOne;
    }

    /**
     * @return the triangleSideTwo
     */
    public double getTriangleSideTwo() {
        return triangleSideTwo;
    }

    /**
     * @param triangleSideTwo the triangleSideTwo to set
     */
    public void setTriangleSideTwo(double triangleSideTwo) {
        this.triangleSideTwo = triangleSideTwo;
    }

    /**
     * @return the triangleSideThree
     */
    public double getTriangleSideThree() {
        return triangleSideThree;
    }

    /**
     * @param triangleSideThree the triangleSideThree to set
     */
    public void setTriangleSideThree(double triangleSideThree) {
        this.triangleSideThree = triangleSideThree;
    }

    /**
     * @return the triangleType
     */
    public String getTriangleType() {
        return triangleType;
    }

    /**
     * @param triangleType the triangleType to set
     */
    public void setTriangleType(String triangleType) {
        this.triangleType = triangleType;
    }


}
