package io.schoolspointframework.student.domain;

import io.schoolspointframework.AbstractIntegrationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@DataJpaTest
class RollNumberGeneratorIntegrationTests extends AbstractIntegrationTests {
    private static final Grade GRADE = Grade.create(GradeType.TEN, "A").value();
    private static final FakeStudentInfoParameters COMPLETE_INFO_PARAMETERS = FakeStudentInfoParameters.builder()
            .firstName("Bhuwan")
            .middleName("Prasad")
            .lastName("Upadhyay")
            .addressName("Lamki")
            .street("Lamki")
            .city("Lamki")
            .gradeType(GRADE.getGradeType().name())
            .group(GRADE.getGradeGroup())
            .zipCode("123213")
            .group("A")
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