package io.schoolspointframework.student.usecase;

import io.schoolspointframework.core.ddd.Response;
import io.schoolspointframework.core.ddd.usecase.DddUseCase;
import io.schoolspointframework.student.domain.RollNumberGenerator;
import io.schoolspointframework.student.domain.Student;
import io.schoolspointframework.student.domain.StudentInfoParameters;
import io.schoolspointframework.student.domain.StudentManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@Component
@RequiredArgsConstructor
public class RegisterApplicantUseCase implements DddUseCase<StudentInfoParameters, Optional<Void>> {

    private final RollNumberGenerator rollNumberGenerator;
    private final StudentManager<Student> studentManager;

    @Override
    public Response<Optional<Void>> execute(StudentInfoParameters params) {
        Student.create(params, rollNumberGenerator)
                .onSuccess(studentManager::save);
        return Response.success();
    }
}
