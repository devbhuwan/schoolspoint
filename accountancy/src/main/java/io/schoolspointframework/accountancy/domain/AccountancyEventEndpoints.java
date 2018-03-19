package io.schoolspointframework.accountancy.domain;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public interface AccountancyEventEndpoints {

    void handleRegisterNewApplicant(StudentPaymentEntryInfoParams params);
}
