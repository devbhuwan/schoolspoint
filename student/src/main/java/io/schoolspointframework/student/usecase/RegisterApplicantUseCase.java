package io.schoolspointframework.student.usecase;

import io.github.devbhuwan.student.spec.NewApplicant;
import io.schoolspointframework.lang.ddd.Response;
import io.schoolspointframework.lang.ddd.usecase.DddUseCase;
import io.schoolspointframework.lang.usecase.UseCaseDesign;
import io.schoolspointframework.student.adapters.StudentServiceStreams;
import io.schoolspointframework.student.domain.RollNumberGenerator;
import io.schoolspointframework.student.domain.Student;
import io.schoolspointframework.student.domain.StudentManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;


/**
 * @author Bhuwan Prasad Upadhyay
 */
@Component
@RequiredArgsConstructor
@UseCaseDesign
@Slf4j
public class RegisterApplicantUseCase implements DddUseCase<NewApplicant, Optional<Void>> {

    private final RollNumberGenerator rollNumberGenerator;
    private final StudentManager<Student> studentManager;
    private final StudentServiceStreams channel;

    @Override
    public Response<Optional<Void>> execute(NewApplicant applicant) {
        return Student.create(applicant, rollNumberGenerator)
                .onSuccess(studentManager::save)
                .thenReturn();
    }
}
