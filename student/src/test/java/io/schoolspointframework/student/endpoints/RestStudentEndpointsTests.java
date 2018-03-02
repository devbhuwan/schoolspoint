package io.schoolspointframework.student.endpoints;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.schoolspointframework.Schoolspoint;
import io.schoolspointframework.student.AbstractIntegrationTests;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static io.schoolspointframework.student.endpoints.StudentEndpoints.BASE_URI;
import static io.schoolspointframework.student.endpoints.StudentEndpoints.REGISTER;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.OK;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@SpringBootTest(classes = Schoolspoint.class, webEnvironment = RANDOM_PORT)
public class RestStudentEndpointsTests extends AbstractIntegrationTests {

    @LocalServerPort
    private int serverPort;

    @Test
    public void givenMissingStudentInfoParameterThenShouldReturnValidationErrors() {
        studentEndpoints()
                .body("")
                .post(BASE_URI + REGISTER)
                .then()
                .statusCode(OK.value());

    }

    public RequestSpecification studentEndpoints() {
        return RestAssured
                .with()
                .port(serverPort);

    }
}