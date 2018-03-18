package io.schoolspointframework.accountancy.domain;

import io.schoolspointframework.lang.ddd.Response;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.TEN;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Bhuwan Prasad Upadhyay
 */
class StudentPaymentEntryUnitTests {

    @Test
    void rejectsIncompleteParams() {
        StudentPaymentEntryInfoParams params = new StudentPaymentEntryInfoParams() {
            @Override
            public String getGradeName() {
                return "NURSERY";
            }

            @Override
            public StudentIdentifier getPaidBy() {
                return new StudentIdentifier();
            }

            @Override
            public BigDecimal getPaidAmount() {
                return BigDecimal.ZERO;
            }
        };

        FeeAccountancy accountancy = (grade) -> TEN;
        Response<StudentPaymentEntry> response = StudentPaymentEntry.create(params, accountancy);
        assertThat(response.errors()).hasSize(1);
    }
}