package io.schoolspointframework.accountancy.domain;

import io.schoolspointframework.student.model.StudentProtos.ApplicantRegisteredPayload;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public interface AccountancyEventEndpoints {

    void handleRegisterNewApplicant(ApplicantRegisteredPayload params);
}
