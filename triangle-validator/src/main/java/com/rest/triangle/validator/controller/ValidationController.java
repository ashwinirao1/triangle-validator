package com.rest.triangle.validator.controller;

import static com.rest.triangle.validator.constants.ControllerPathConstants.VALIDATE_URL;

import com.rest.triangle.validator.constants.ErrorConstants;
import com.rest.triangle.validator.exceptions.InvalidTriangleException;
import com.rest.triangle.validator.model.TriangleInput;
import com.rest.triangle.validator.response.ValidateTriangleResponse;
import com.rest.triangle.validator.utils.ValidatorUtil;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class ValidationController.
 */
@RestController
@RequestMapping(VALIDATE_URL)
public class ValidationController extends BaseController {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationController.class);

    /** The message source. */
    private final MessageSource messageSource;

    /**
     * Instantiates a new validation controller.
     * @param messageSource the message source
     */
    @Autowired
    public ValidationController(final MessageSource messageSource) {
        this.messageSource = messageSource;
    }


    /**
     * Validate triangle.
     * @param loginInputData the login input data
     * @param bindingResult the binding result
     * @param locale the locale
     * @return the response entity
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ValidateTriangleResponse> validateTriangle(@Validated final TriangleInput triangleInputData, BindingResult bindingResult, Locale locale) {
        LOGGER.debug("Input value from the request passed : ", triangleInputData);
        if (bindingResult.hasGlobalErrors()) {
            Map<Integer, String> errorMap = new HashMap<>();
            bindingResult.getGlobalErrors().stream().forEach(error -> {
                errorMap.put(Integer.valueOf(error.getDefaultMessage()), messageSource.getMessage(error.getCode(), error.getArguments(), ErrorConstants.INVALID_TRAINGLE_REQUEST, locale));
            });
            throw new InvalidTriangleException(errorMap);
        }
        return new ResponseEntity<ValidateTriangleResponse>(new ValidateTriangleResponse(triangleInputData.getSideOne(), triangleInputData.getSideTwo(), triangleInputData.getSideThree(), ValidatorUtil.getTypeOfTriangle(triangleInputData.getSideOne(), triangleInputData.getSideTwo(), triangleInputData.getSideThree())), HttpStatus.OK);
    }
}
