package io.schoolspointframework.student.endpoints;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.schoolspointframework.Schoolspoint;
import io.schoolspointframework.student.AbstractIntegrationTests;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static io.schoolspointframework.student.endpoints.StudentEndpoints.BASE_URI;
import static io.schoolspointframework.student.endpoints.StudentEndpoints.REGISTER;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.OK;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@SpringBootTest(classes = Schoolspoint.class, webEnvironment = RANDOM_PORT)
public class RestStudentEndpointsIntegrationTests extends AbstractIntegrationTests {

    @LocalServerPort
    private int serverPort;

    @Test
    public void givenMissingStudentInfoParameterThenShouldReturnValidationErrors() {
        ValidatableResponse validatableResponse = studentEndpoints().body("{}").post(BASE_URI + REGISTER).then();
        validatableResponse.statusCode(OK.value());
        validatableResponse.body("[0].causedBy", is("name"));
        validatableResponse.body("[0].message", is("name must be not blank!"));
    }

    public RequestSpecification studentEndpoints() {
        return RestAssured.with().port(serverPort);
    }

}