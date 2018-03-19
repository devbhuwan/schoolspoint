package io.schoolspointframework.accountancy.domain;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@Getter
@Builder
public class EventStudentPaymentEntryInfoParams implements StudentPaymentEntryInfoParams {
    private final String gradeName;
    private final StudentIdentifier paidBy;
    private final BigDecimal paidAmount;


}
