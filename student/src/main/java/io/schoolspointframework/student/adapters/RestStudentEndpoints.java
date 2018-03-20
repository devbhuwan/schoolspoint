package io.schoolspointframework.student.adapters;

import io.schoolspointframework.lang.ddd.ResponseError;
import io.schoolspointframework.student.model.StudentProtos.NewApplicant;
import io.schoolspointframework.student.usecase.RegisterApplicantUseCase;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

import static io.schoolspointframework.student.adapters.RestStudentEndpoints.BASE_URI;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@RequiredArgsConstructor
@RequestMapping(BASE_URI)
@RestController
class RestStudentEndpoints {

    static final String BASE_URI = "/students";
    static final String REGISTER = "/register";

    private final @NonNull
    RegisterApplicantUseCase registerApplicantUseCase;

    @PostMapping(REGISTER)
    public Set<ResponseError> registerStudent(@RequestBody NewApplicant applicant) {
        return registerApplicantUseCase.execute(applicant).errors();
    }

}
