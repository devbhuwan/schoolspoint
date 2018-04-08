package io.schoolspointframework.student.adapters;

import com.google.common.net.MediaType;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.schoolspointframework.Json;
import io.schoolspointframework.Schoolspoint;
import io.schoolspointframework.SchoolspointExtension;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static io.schoolspointframework.student.adapters.RestStudentEndpoints.BASE_URI;
import static io.schoolspointframework.student.adapters.RestStudentEndpoints.REGISTER;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.OK;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@ExtendWith(SchoolspointExtension.class)
@SpringBootTest(classes = Schoolspoint.class, webEnvironment = RANDOM_PORT)
class RestStudentEndpointsIntegrationTests {
    private static final Matcher<Iterable<Object>> EMPTY_ITEMS = hasItems();
    @LocalServerPort
    private int serverPort;

    @Test
    void givenMissingStudentInfoParametersThenShouldReturnValidationErrors() {
        ValidatableResponse response = studentEndpoints().body("{}").post(applicantRegisterUri()).then();
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

    @Test
    void givenCompleteStudentInfoParametersThenShouldReturnEmptyValidationErrors() {
        final String jsonParams = Json.start()
                .item("firstName", "BHUWAN")
                .item("middleName", "PRASAD")
                .item("lastName", "UPDADHYAY")
                .lastItem("addressName", "Lamki").json();
        ValidatableResponse response = studentEndpoints().body(jsonParams).post(applicantRegisterUri()).then();
        response.statusCode(OK.value());
        response.body("causedBy", EMPTY_ITEMS);
        response.body("message", EMPTY_ITEMS);
    }

    private String applicantRegisterUri() {
        return BASE_URI + REGISTER;
    }

    private RequestSpecification studentEndpoints() {
        return RestAssured.given()
                .log()
                .all()
                .with()
                .contentType(MediaType.PROTOBUF.type())
                .port(serverPort);
    }

}

