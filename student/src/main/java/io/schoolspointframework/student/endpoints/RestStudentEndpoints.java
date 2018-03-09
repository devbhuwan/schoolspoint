package io.schoolspointframework.student.endpoints;

import io.schoolspointframework.lang.ddd.ResponseError;
import io.schoolspointframework.student.usecase.RegisterApplicantUseCase;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@RequiredArgsConstructor
@RequestMapping(StudentEndpoints.BASE_URI)
@RestController
class RestStudentEndpoints implements StudentEndpoints {

    private final @NonNull
    RegisterApplicantUseCase registerApplicantUseCase;

    @Override
    public Set<ResponseError> registerStudent(@RequestBody EndpointStudentInfoParameters params) {
        return registerApplicantUseCase.execute(params).errors();
    }

}
