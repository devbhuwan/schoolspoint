package io.schoolspointframework.student.domain;

import io.github.devbhuwan.student.spec.NewApplicant;
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
@SpringBootTest(classes = Schoolspoint.class)
@ExtendWith(SchoolspointExtension.class)
class RollNumberGeneratorIntegrationTests {
    private static final Grade GRADE = Grade.create(GradeType.TEN, "A").value();
    @Autowired
    private RollNumberGenerator rollNumberGenerator;
    @Autowired
    private StudentManager<Student> studentManager;

    @Test
    void rollNumberShouldStartFromOneWhenStudentRecordNotExistThatMatchingWithGrade() {
        assertThat(rollNumberGenerator.newSequence(Grade.NULL)).isEqualTo(1);
    }

    @Test
    void rollNumberShouldStartFromLastSequencePlusOneWhenStudentRecordExistThatMatchingWithGrade() {
        Student student = Student.create(applicant(), rollNumberGenerator).value();
        studentManager.save(student);
        assertThat(rollNumberGenerator.newSequence(GRADE))
                .isEqualTo(student.getRollNumber().plusOne());
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
        grade.setGradeType(GRADE.getGradeType().name());
        grade.setGroup(GRADE.getGradeGroup());
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