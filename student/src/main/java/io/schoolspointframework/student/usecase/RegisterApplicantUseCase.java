package io.schoolspointframework.student.usecase;

import io.schoolspointframework.lang.ddd.Response;
import io.schoolspointframework.lang.ddd.usecase.DddUseCase;
import io.schoolspointframework.lang.usecase.UseCaseDesign;
import io.schoolspointframework.student.adapters.SchoolspointChannel;
import io.schoolspointframework.student.domain.RollNumberGenerator;
import io.schoolspointframework.student.domain.Student;
import io.schoolspointframework.student.domain.StudentManager;
import io.schoolspointframework.student.model.StudentProtos.NewApplicant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static io.schoolspointframework.student.model.StudentProtos.ApplicantRegisteredPayload.newBuilder;

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
    private final SchoolspointChannel channel;

    @Override
    public Response<Optional<Void>> execute(NewApplicant applicant) {
        return Student.create(applicant, rollNumberGenerator)
                .onSuccess(studentManager::save)
                .onSuccess(student ->
                        channel.send(newBuilder()
                                .setGradeName(student.getGradeType())
                                .setPaidBy("Bhuwan")
                                .setPaidAmount(10.2d)
                                .build()))
                .thenReturn();
    }
}
