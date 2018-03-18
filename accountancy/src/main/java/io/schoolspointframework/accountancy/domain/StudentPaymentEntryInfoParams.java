package io.schoolspointframework.accountancy.domain;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public interface StudentPaymentEntryInfoParams extends PaymentEntryInfoParams<StudentIdentifier> {

    String getGradeName();
}
