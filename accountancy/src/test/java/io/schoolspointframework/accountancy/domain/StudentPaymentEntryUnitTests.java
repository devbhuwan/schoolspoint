package io.schoolspointframework.accountancy.domain;

import io.schoolspointframework.lang.ddd.Response;
import org.junit.jupiter.api.Test;

import static io.schoolspointframework.student.model.StudentProtos.ApplicantRegisteredPayload.newBuilder;
import static java.math.BigDecimal.TEN;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Bhuwan Prasad Upadhyay
 */
class StudentPaymentEntryUnitTests {

    @Test
    void rejectsIncompleteParams() {
        FeeAccountancy accountancy = (grade) -> TEN;
        Response<StudentPaymentEntry> response
                = StudentPaymentEntry.create(newBuilder()
                .build(), accountancy);
        assertThat(response.errors()).hasSize(1);
    }
}