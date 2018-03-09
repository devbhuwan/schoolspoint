package io.schoolspointframework.student.endpoints;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.schoolspointframework.AbstractIntegrationTests;
import io.schoolspointframework.Schoolspoint;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static io.schoolspointframework.student.endpoints.StudentEndpoints.BASE_URI;
import static io.schoolspointframework.student.endpoints.StudentEndpoints.REGISTER;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.OK;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@SpringBootTest(classes = Schoolspoint.class, webEnvironment = RANDOM_PORT)
class RestStudentEndpointsIntegrationTests extends AbstractIntegrationTests {

    @LocalServerPort
    private int serverPort;

    @Test
    void givenMissingStudentInfoParameterThenShouldReturnValidationErrors() {
        ValidatableResponse response = studentEndpoints().body("{}").post(BASE_URI + REGISTER).then();
        response.statusCode(OK.value());

        response.body("causedBy",
                hasItems(
                        "firstName",
                        "lastName",
                        "addressName"));

        response.body("message",
                hasItems(
                        "firstName must be not blank!",
                        "lastName must be not blank!",
                        "student.address.name.must.be.not.blank"
                ));
    }

    private RequestSpecification studentEndpoints() {
        return RestAssured.with().port(serverPort);
    }

}