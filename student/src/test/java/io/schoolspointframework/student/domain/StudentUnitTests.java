package io.schoolspointframework.student.domain;

import io.github.devbhuwan.student.spec.NewApplicant;
import io.github.devbhuwan.student.spec.NewApplicantImpl;
import io.schoolspointframework.lang.ddd.Response;
import io.schoolspointframework.lang.ddd.ResponseError;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Bhuwan Prasad Upadhyay
 */
class StudentUnitTests {

    ;

    private static final RollNumberGenerator ROLL_NUMBER_GENERATOR = (g) -> (121);

    @Test
    void rejectIncompleteStudentInfoParameters() {
        Response<Student> studentResponse = Student.create(new NewApplicantImpl(), ROLL_NUMBER_GENERATOR);

        assertThat(studentResponse.value())
                .hasFieldOrPropertyWithValue("name", Name.NULL)
                .hasFieldOrPropertyWithValue("address", Address.NULL)
                .hasFieldOrPropertyWithValue("grade", Grade.NULL);
        assertThat(studentResponse.errors()).isNotEqualTo(ResponseError.NULL);
    }


    @Test
    void succeedToCreateStudentWhenGivenCompleteStudentInfoParameters() {
        Response<Student> studentResponse = Student.create(applicant(), ROLL_NUMBER_GENERATOR);
        assertThat(studentResponse.errors()).isEmpty();
    }


    private NewApplicant applicant() {
        NewApplicant applicant = new NewApplicantImpl();
        applicant.setName(name());
        applicant.setGrade(grade());
        applicant.setAddress(address());
        return applicant;
    }

    private NewApplicantImpl.AddressTypeImpl address() {
        NewApplicantImpl.AddressTypeImpl address = new NewApplicantImpl.AddressTypeImpl();
        address.setName("Lamki");
        address.setStreet("Lamki");
        address.setCity("Lamki");
        address.setZipCode("123213");
        return address;
    }

    private NewApplicantImpl.GradeTypeImpl grade() {
        NewApplicantImpl.GradeTypeImpl grade = new NewApplicantImpl.GradeTypeImpl();
        grade.setGradeType("TEN");
        return grade;
    }

    private NewApplicantImpl.NameTypeImpl name() {
        NewApplicantImpl.NameTypeImpl name = new NewApplicantImpl.NameTypeImpl();
        name.setFirstName("Bhuwan");
        name.setMiddleName("Prasad");
        name.setLastName("Upadhyay");
        return name;
    }
}