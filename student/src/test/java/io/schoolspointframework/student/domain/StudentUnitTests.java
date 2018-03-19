package io.schoolspointframework.student.domain;

import io.schoolspointframework.lang.ddd.Response;
import io.schoolspointframework.lang.ddd.ResponseError;
import io.schoolspointframework.student.model.StudentProtos.NewApplicant;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Bhuwan Prasad Upadhyay
 */
class StudentUnitTests {

    private static final NewApplicant INCOMPLETE_INFO_PARAMETERS = NewApplicant.newBuilder()
            .buildPartial();

    private static final NewApplicant COMPLETE_INFO_PARAMETERS =
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
        assertThat(studentResponse.errors()).isEmpty();
    }

}