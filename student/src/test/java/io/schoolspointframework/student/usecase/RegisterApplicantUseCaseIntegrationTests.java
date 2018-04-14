package io.schoolspointframework.student.usecase;

import io.github.devbhuwan.student.spec.NewApplicantImpl;
import io.schoolspointframework.Schoolspoint;
import io.schoolspointframework.SchoolspointExtension;
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

    @Autowired
    private RegisterApplicantUseCase registerApplicantUseCase;

    @Test
    void rejectsIncompleteStudentInfoParameters() {
        assertThat(registerApplicantUseCase.execute(new NewApplicantImpl()).errors()).isNotEmpty();
    }

    @Test
    void saveApplicantCorrectlyWhenPassedCompleteStudentInfoParameters() {
        NewApplicantImpl applicant = new NewApplicantImpl();

        NewApplicantImpl.NameTypeImpl name = new NewApplicantImpl.NameTypeImpl();
        applicant.setName(name);
        name.setFirstName("Bhuwan");
        name.setMiddleName("Prasad");
        name.setLastName("Upadhyay");

        NewApplicantImpl.AddressTypeImpl address = new NewApplicantImpl.AddressTypeImpl();
        applicant.setAddress(address);
        address.setName("Lamki");
        address.setStreet("Lamki");
        address.setCity("Lamki");
        address.setZipCode("123213");

        NewApplicantImpl.GradeTypeImpl grade = new NewApplicantImpl.GradeTypeImpl();
        applicant.setGrade(grade);
        grade.setGradeType("TEN");
        grade.setGroup("A");

        assertThat(registerApplicantUseCase.execute(applicant).errors()).isEmpty();
    }
}