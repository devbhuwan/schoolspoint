package io.schoolspointframework.student.domain;

import io.schoolspointframework.lang.ddd.Response;
import io.schoolspointframework.lang.ddd.ResponseError;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Bhuwan Prasad Upadhyay
 */
class StudentUnitTests {

    private static final FakeStudentInfoParameters INCOMPLETE_INFO_PARAMETERS = FakeStudentInfoParameters.builder()
            .build();

    private static final FakeStudentInfoParameters COMPLETE_INFO_PARAMETERS = FakeStudentInfoParameters.builder()
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

    private static final RollNumberGenerator ROLL_NUMBER_GENERATOR = (g) -> (121);

    @Test
    void rejectIncompleteStudentInfoParameters() {
        Response<Student> studentResponse = Student.create(INCOMPLETE_INFO_PARAMETERS, ROLL_NUMBER_GENERATOR);

        assertThat(studentResponse.value())
                .hasFieldOrPropertyWithValue("name", Name.NULL)
                .hasFieldOrPropertyWithValue("address", Address.NULL)
                .hasFieldOrPropertyWithValue("grade", Grade.NULL);
        assertThat(studentResponse.errors()).isNotEqualTo(ResponseError.NULL);
    }


    @Test
    void succeedToCreateStudentWhenGivenCompleteStudentInfoParameters() {
        Response<Student> studentResponse = Student.create(COMPLETE_INFO_PARAMETERS, ROLL_NUMBER_GENERATOR);
        assertThat(studentResponse.errors()).isEqualTo(ResponseError.NULL);
    }

}