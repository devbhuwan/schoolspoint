package io.schoolspointframework.student.usecase;

import io.schoolspointframework.core.cleancode.usecase.UseCaseDesign;
import io.schoolspointframework.core.ddd.Response;
import io.schoolspointframework.core.ddd.event.DomainEventPublisher;
import io.schoolspointframework.core.ddd.usecase.DddUseCase;
import io.schoolspointframework.student.domain.RollNumberGenerator;
import io.schoolspointframework.student.domain.Student;
import io.schoolspointframework.student.domain.StudentInfoParameters;
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
public class RegisterApplicantUseCase implements DddUseCase<StudentInfoParameters, Optional<Void>> {

    private final RollNumberGenerator rollNumberGenerator;
    private final StudentManager<Student> studentManager;
    private final DomainEventPublisher publisher;

    @Override
    public Response<Optional<Void>> execute(StudentInfoParameters params) {
        return Student.create(params, rollNumberGenerator)
                .onSuccess(studentManager::save)
                .thenReturn();
    }
}
