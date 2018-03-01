package io.schoolspointframework.endpoints;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@RequestMapping(StudentEndpoints.API)
@RestController
public interface StudentEndpoints {

    String API = "students";
//
//    @GetMapping
//    List<Student> studentsByGrade(GradeRequestRepresentation grade);

    @PostMapping
    void registerStudent(RegisterStudentRequestRepresentation representation);
}
