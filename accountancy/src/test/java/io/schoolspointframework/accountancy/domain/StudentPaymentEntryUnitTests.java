package io.schoolspointframework.accountancy.domain;

import io.schoolspointframework.lang.ddd.Response;
import org.junit.jupiter.api.Test;

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
                = StudentPaymentEntry.create(params, accountancy);
        assertThat(response.errors()).hasSize(1);
    }
}