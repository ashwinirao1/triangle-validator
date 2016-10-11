package com.rest.triangle.validator.integration;

import static org.junit.Assert.assertEquals;

import com.rest.triangle.validator.constants.ControllerPathConstants;
import com.rest.triangle.validator.constants.GenericConstants;
import com.rest.triangle.validator.enums.TriangleType;
import com.rest.triangle.validator.response.GenericResponse;
import com.rest.triangle.validator.response.ValidateTriangleResponse;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * The Class ValidationControllerIntegrationTest.
 */
public class ValidationControllerIntegrationTest extends BaseIntegrationTest {


    @Test
    public void testValidTriangle() {
        Double triangleSideOne = 2d;
        Double triangleSideTwo = 4d;
        Double triangleSideThree = 5d;
        final ResponseEntity<GenericResponse> response = testRestTemplate.getForEntity(test_base_url + ControllerPathConstants.VALIDATE_URL + "?sideOne=" + triangleSideOne + "&sideTwo=" + triangleSideTwo + "&sideThree=" + triangleSideThree, GenericResponse.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(GenericConstants.SUCCESS, response.getBody().getMessage());
    }

    @Test
    public void testValidTriangle_TypeIsosceles() {
        Double triangleSideOne = 2d;
        Double triangleSideTwo = 4d;
        Double triangleSideThree = 4d;
        final ResponseEntity<ValidateTriangleResponse> response = testRestTemplate.getForEntity(test_base_url + ControllerPathConstants.VALIDATE_URL + "?sideOne=" + triangleSideOne + "&sideTwo=" + triangleSideTwo + "&sideThree=" + triangleSideThree, ValidateTriangleResponse.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(GenericConstants.SUCCESS, response.getBody().getMessage());
        assertEquals(TriangleType.ISOSCELES.toString(), response.getBody().getTriangleType());
    }

    @Test
    public void testValidTriangle_TypeEquilateral() {
        Double triangleSideOne = 3d;
        Double triangleSideTwo = 3d;
        Double triangleSideThree = 3d;
        final ResponseEntity<ValidateTriangleResponse> response = testRestTemplate.getForEntity(test_base_url + ControllerPathConstants.VALIDATE_URL + "?sideOne=" + triangleSideOne + "&sideTwo=" + triangleSideTwo + "&sideThree=" + triangleSideThree, ValidateTriangleResponse.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(GenericConstants.SUCCESS, response.getBody().getMessage());
        assertEquals(TriangleType.EQUILATERAL.toString(), response.getBody().getTriangleType());
    }

    @Test
    public void testValidTriangle_TypeScalene() {
        Double triangleSideOne = 4d;
        Double triangleSideTwo = 5d;
        Double triangleSideThree = 7d;
        final ResponseEntity<ValidateTriangleResponse> response = testRestTemplate.getForEntity(test_base_url + ControllerPathConstants.VALIDATE_URL + "?sideOne=" + triangleSideOne + "&sideTwo=" + triangleSideTwo + "&sideThree=" + triangleSideThree, ValidateTriangleResponse.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(GenericConstants.SUCCESS, response.getBody().getMessage());
        assertEquals(TriangleType.SCALENE.toString(), response.getBody().getTriangleType());
    }

    @Test
    public void testValidTriangle_HighNumbers() {
        Double triangleSideOne = 2111112345d;
        Double triangleSideTwo = 3221212345d;
        Double triangleSideThree = 4511212345d;
        final ResponseEntity<GenericResponse> response = testRestTemplate.getForEntity(test_base_url + ControllerPathConstants.VALIDATE_URL + "?sideOne=" + triangleSideOne + "&sideTwo=" + triangleSideTwo + "&sideThree=" + triangleSideThree, GenericResponse.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(GenericConstants.SUCCESS, response.getBody().getMessage());
    }

    @Test
    public void testValidTriangle_DecimalNumbers() {
        Double triangleSideOne = 2.2d;
        Double triangleSideTwo = 3.1d;
        Double triangleSideThree = 4.5d;
        final ResponseEntity<GenericResponse> response = testRestTemplate.getForEntity(test_base_url + ControllerPathConstants.VALIDATE_URL + "?sideOne=" + triangleSideOne + "&sideTwo=" + triangleSideTwo + "&sideThree=" + triangleSideThree, GenericResponse.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(GenericConstants.SUCCESS, response.getBody().getMessage());
    }

    @Test
    public void testValidTriangle_DecimalNumbers_PrecisionHigh() {
        Double triangleSideOne = 2.3435563434d;
        Double triangleSideTwo = 3.18932212d;
        Double triangleSideThree = 4.556577123d;
        final ResponseEntity<GenericResponse> response = testRestTemplate.getForEntity(test_base_url + ControllerPathConstants.VALIDATE_URL + "?sideOne=" + triangleSideOne + "&sideTwo=" + triangleSideTwo + "&sideThree=" + triangleSideThree, GenericResponse.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(GenericConstants.SUCCESS, response.getBody().getMessage());
    }

    @Test
    public void testInvalidTriangle() {
        Double triangleSideOne = 2d;
        Double triangleSideTwo = 4d;
        Double triangleSideThree = 9d;
        final ResponseEntity<GenericResponse> response = testRestTemplate.getForEntity(test_base_url + ControllerPathConstants.VALIDATE_URL + "?sideOne=" + triangleSideOne + "&sideTwo=" + triangleSideTwo + "&sideThree=" + triangleSideThree, GenericResponse.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(GenericConstants.FAILURE, response.getBody().getMessage());
    }

    @Test
    public void testInvalidTriangle_Zero() {
        Double triangleSideOne = 0d;
        Double triangleSideTwo = 4d;
        Double triangleSideThree = 9d;
        final ResponseEntity<GenericResponse> response = testRestTemplate.getForEntity(test_base_url + ControllerPathConstants.VALIDATE_URL + "?sideOne=" + triangleSideOne + "&sideTwo=" + triangleSideTwo + "&sideThree=" + triangleSideThree, GenericResponse.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(GenericConstants.FAILURE, response.getBody().getMessage());
    }

    @Test
    public void testInvalidTriangle_LargeSide() {
        Double triangleSideOne = 111111111111111111111110d;
        Double triangleSideTwo = 4d;
        Double triangleSideThree = 9d;
        final ResponseEntity<GenericResponse> response = testRestTemplate.getForEntity(test_base_url + ControllerPathConstants.VALIDATE_URL + "?sideOne=" + triangleSideOne + "&sideTwo=" + triangleSideTwo + "&sideThree=" + triangleSideThree, GenericResponse.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(GenericConstants.FAILURE, response.getBody().getMessage());
    }

    @Test
    public void testInvalidTriangle_Negative() {
        Double triangleSideOne = -1d;
        Double triangleSideTwo = 4d;
        Double triangleSideThree = -9d;
        final ResponseEntity<GenericResponse> response = testRestTemplate.getForEntity(test_base_url + ControllerPathConstants.VALIDATE_URL + "?sideOne=" + triangleSideOne + "&sideTwo=" + triangleSideTwo + "&sideThree=" + triangleSideThree, GenericResponse.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(GenericConstants.FAILURE, response.getBody().getMessage());
    }

    @Test
    public void testInvalidTriangle_InvalidValues() {
        String triangleSideOne = "a";
        String triangleSideTwo = "b";
        String triangleSideThree = "c";
        final ResponseEntity<GenericResponse> response = testRestTemplate.getForEntity(test_base_url + ControllerPathConstants.VALIDATE_URL + "?sideOne=" + triangleSideOne + "&sideTwo=" + triangleSideTwo + "&sideThree=" + triangleSideThree, GenericResponse.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(GenericConstants.FAILURE, response.getBody().getMessage());
    }

    @Test
    public void testInvalidTriangle_InvalidParameters() {
        String triangleSideOne = "a";
        String triangleSideTwo = "b";
        String triangleSideThree = "c";
        final ResponseEntity<GenericResponse> response = testRestTemplate.getForEntity(test_base_url + ControllerPathConstants.VALIDATE_URL + "?side1=" + triangleSideOne + "&side2=" + triangleSideTwo + "&sideTsdfe=" + triangleSideThree, GenericResponse.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(GenericConstants.FAILURE, response.getBody().getMessage());
    }

    @Test
    public void testInvalidTriangle_InvalidUrl() {
        String triangleSideOne = "a";
        String triangleSideTwo = "b";
        String triangleSideThree = "c";
        final ResponseEntity<GenericResponse> response = testRestTemplate.getForEntity(test_base_url + ControllerPathConstants.VALIDATE_URL + "/hack" + "?side1=" + triangleSideOne + "&side2=" + triangleSideTwo + "&sideTsdfe=" + triangleSideThree, GenericResponse.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testInvalidTriangle_EmptyValues() {
        String triangleSideOne = "";
        String triangleSideTwo = "  ";
        String triangleSideThree = "c";
        final ResponseEntity<GenericResponse> response = testRestTemplate.getForEntity(test_base_url + ControllerPathConstants.VALIDATE_URL + "?sideOne=" + triangleSideOne + "&sideTwo=" + triangleSideTwo + "&sideThree=" + triangleSideThree, GenericResponse.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(GenericConstants.FAILURE, response.getBody().getMessage());
    }
}
