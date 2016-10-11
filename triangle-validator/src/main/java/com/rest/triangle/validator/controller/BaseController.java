package com.rest.triangle.validator.controller;

import com.rest.triangle.validator.webvalidators.TriangleValidator;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * The Class BaseController.
 */
public abstract class BaseController {

    // =================================================
    // Class Variables
    // =================================================

    // =================================================
    // Instance Variables
    // =================================================

    // =================================================
    // Constructors
    // =================================================

    // =================================================
    // Class Methods
    // =================================================

    // =================================================
    // Instance Methods
    // =================================================

    /**
     * Inits the binder.
     * @param binder the binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(new TriangleValidator());
    }

}
