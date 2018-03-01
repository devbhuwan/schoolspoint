package io.schoolspointframework.student;

import io.schoolspointframework.core.ddd.Response;
import io.schoolspointframework.core.ddd.usecase.DddUseCase;
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

    @Override
    public Response<Optional<Void>> execute(StudentInfoParameters params) {
        Response<Student> studentResponse = Student.create(params, rollNumberGenerator);
        return Response.success();
    }
}
