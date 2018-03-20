package io.schoolspointframework.student.usecase;

import io.schoolspointframework.Schoolspoint;
import io.schoolspointframework.SchoolspointExtension;
import io.schoolspointframework.student.model.StudentProtos.NewApplicant;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@ExtendWith(SchoolspointExtension.class)
@SpringBootTest(classes = Schoolspoint.class)
class RegisterApplicantUseCaseIntegrationTests {

    private static final NewApplicant INCOMPLETE_STUDENT_INFO_PARAMETERS =
            NewApplicant.newBuilder()
                    .buildPartial();
    private static final NewApplicant COMPLETE_STUDENT_INFO_PARAMETERS =
            NewApplicant.newBuilder()
                    .setFirstName("Bhuwan")
                    .setMiddleName("Prasad")
                    .setLastName("Upadhyay")
                    .setAddressName("Lamki")
                    .setStreet("Lamki")
                    .setCity("Lamki")
                    .setGradeType("TEN")
                    .setZipCode("123213")
                    .setGroup("A")
                    .build();
    @Autowired
    private RegisterApplicantUseCase registerApplicantUseCase;

    @Test
    void rejectsIncompleteStudentInfoParameters() {
        assertThat(registerApplicantUseCase.execute(INCOMPLETE_STUDENT_INFO_PARAMETERS).errors()).isNotEmpty();
    }

    @Test
    void saveApplicantCorrectlyWhenPassedCompleteStudentInfoParameters() {
        assertThat(registerApplicantUseCase.execute(COMPLETE_STUDENT_INFO_PARAMETERS).errors()).isEmpty();
    }
}