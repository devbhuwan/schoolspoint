package io.schoolspointframework.student.domain;

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
@SpringBootTest(classes = Schoolspoint.class)
@ExtendWith(SchoolspointExtension.class)
class RollNumberGeneratorIntegrationTests {
    private static final Grade GRADE = Grade.create(GradeType.TEN, "A").value();
    private static final NewApplicant COMPLETE_INFO_PARAMETERS = NewApplicant.newBuilder()
            .setFirstName("Bhuwan")
            .setMiddleName("Prasad")
            .setLastName("Upadhyay")
            .setAddressName("Lamki")
            .setStreet("Lamki")
            .setCity("Lamki")
            .setGradeType(GRADE.getGradeType().name())
            .setGroup(GRADE.getGradeGroup())
            .setZipCode("123213")
            .build();

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
        Student student = Student.create(COMPLETE_INFO_PARAMETERS, rollNumberGenerator).value();
        studentManager.save(student);
        assertThat(rollNumberGenerator.newSequence(GRADE))
                .isEqualTo(student.getRollNumber().plusOne());
    }

}