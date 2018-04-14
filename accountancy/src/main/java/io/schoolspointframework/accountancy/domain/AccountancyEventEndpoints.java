package io.schoolspointframework.accountancy.domain;


import io.github.devbhuwan.student.spec.ApplicantRegisteredPayload;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public interface AccountancyEventEndpoints {

    void handleRegisterNewApplicant(ApplicantRegisteredPayload params);
}
