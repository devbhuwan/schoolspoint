package io.schoolspointframework.student.usecase;

import io.schoolspointframework.AbstractIntegrationTests;
import io.schoolspointframework.student.domain.FakeStudentInfoParameters;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@DataJpaTest
class RegisterApplicantUseCaseIntegrationTests extends AbstractIntegrationTests {

    private static final FakeStudentInfoParameters INCOMPLETE_STUDENT_INFO_PARAMETERS = FakeStudentInfoParameters
            .builder().build();
    private static final FakeStudentInfoParameters COMPLETE_STUDENT_INFO_PARAMETERS = FakeStudentInfoParameters
            .builder()
            .firstName("Bhuwan")
            .middleName("Prasad")
            .lastName("Upadhyay")
            .addressName("Lamki")
            .street("Lamki")
            .city("Lamki")
            .gradeType("TEN")
            .zipCode("123213")
            .group("A")
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