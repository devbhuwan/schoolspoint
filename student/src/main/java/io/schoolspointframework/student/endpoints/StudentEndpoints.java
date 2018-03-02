package io.schoolspointframework.student.endpoints;

import io.schoolspointframework.core.ddd.ValidationError;
import io.schoolspointframework.student.domain.StudentInfoParameters;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Set;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public interface StudentEndpoints {

    String BASE_URI = "/students";
    String REGISTER = "/register";
    //
//    @GetMapping
//    List<Student> studentsByGrade(GradeRequestRepresentation grade);

    @PostMapping(REGISTER)
    Set<ValidationError> registerStudent(StudentInfoParameters params);
}
