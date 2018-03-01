package io.schoolspointframework.student;

import io.schoolspointframework.core.ddd.Response;
import io.schoolspointframework.core.ddd.ResponseError;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public class StudentUnitTests {

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
    public void rejectIncompleteStudentInfoParameters() {
        Response<Student> studentResponse = Student.create(INCOMPLETE_INFO_PARAMETERS, ROLL_NUMBER_GENERATOR);

        assertThat(studentResponse.value())
                .hasFieldOrPropertyWithValue("name", Name.NULL)
                .hasFieldOrPropertyWithValue("address", Address.NULL)
                .hasFieldOrPropertyWithValue("rollNumber", RollNumber.create(Grade.NULL, ROLL_NUMBER_GENERATOR).value())
                .hasFieldOrPropertyWithValue("grade", Grade.NULL);
        assertThat(studentResponse.error()).isNotEqualTo(ResponseError.NULL);
    }


    @Test
    public void succeedToCreateStudentWhenGivenCompleteStudentInfoParameters() {
        Response<Student> studentResponse = Student.create(COMPLETE_INFO_PARAMETERS, ROLL_NUMBER_GENERATOR);
        assertThat(studentResponse.error()).isEqualTo(ResponseError.NULL);
    }

}