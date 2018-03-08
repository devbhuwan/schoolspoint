package io.schoolspointframework.student.endpoints;

import io.schoolspointframework.lang.ddd.ValidationError;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Set;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public interface StudentEndpoints {

    String BASE_URI = "/students";
    String REGISTER = "/register";

    @PostMapping(REGISTER)
    Set<ValidationError> registerStudent(EndpointStudentInfoParameters params);
}
