package io.schoolspointframework.endpoints;

import io.schoolspointframework.student.Student;
import io.schoolspointframework.student.StudentManager;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@RequiredArgsConstructor
public class RestStudentEndpoints implements StudentEndpoints {

    private final @NonNull
    StudentManager<Student> studentManager;


    @Override
    public void registerStudent(RegisterStudentRequestRepresentation representation) {

    }
}
