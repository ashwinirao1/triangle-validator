package com.rest.triangle.validator.model;


/**
 * The Class TriangleInput.
 */
public class TriangleInput {

    /** The side one. */
    private double sideOne;

    /** The side two. */
    private double sideTwo;

    /** The side three. */
    private double sideThree;

    /**
     * Instantiates a new triangle input.
     */
    public TriangleInput() {}

    /**
     * Instantiates a new triangle input.
     * @param sideOne the side one
     * @param sideTwo the side two
     * @param sideThree the side three
     */
    public TriangleInput(double sideOne, double sideTwo, double sideThree) {
        super();
        this.sideOne = sideOne;
        this.sideTwo = sideTwo;
        this.sideThree = sideThree;
    }

    /**
     * Gets the side one.
     * @return the sideOne
     */
    public double getSideOne() {
        return sideOne;
    }

    /**
     * Sets the side one.
     * @param sideOne the sideOne to set
     */
    public void setSideOne(double sideOne) {
        this.sideOne = sideOne;
    }

    /**
     * Gets the side two.
     * @return the sideTwo
     */
    public double getSideTwo() {
        return sideTwo;
    }

    /**
     * Sets the side two.
     * @param sideTwo the sideTwo to set
     */
    public void setSideTwo(double sideTwo) {
        this.sideTwo = sideTwo;
    }

    /**
     * Gets the side three.
     * @return the sideThree
     */
    public double getSideThree() {
        return sideThree;
    }

    /**
     * Sets the side three.
     * @param sideThree the sideThree to set
     */
    public void setSideThree(double sideThree) {
        this.sideThree = sideThree;
    }

}
