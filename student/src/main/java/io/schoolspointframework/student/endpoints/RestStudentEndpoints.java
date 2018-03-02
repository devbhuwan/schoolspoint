package io.schoolspointframework.student.endpoints;

import io.schoolspointframework.core.ddd.ValidationError;
import io.schoolspointframework.student.usecase.RegisterApplicantUseCase;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@RequiredArgsConstructor
@RequestMapping(StudentEndpoints.BASE_URI)
@RestController
public class RestStudentEndpoints implements StudentEndpoints {

    private final @NonNull
    RegisterApplicantUseCase registerApplicantUseCase;

    @Override
    public Set<ValidationError> registerStudent(EndpointStudentInfoParameters params) {
        return registerApplicantUseCase.execute(params).error().validationErrors();
    }

}
