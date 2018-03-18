package io.schoolspointframework.accountancy.endpoints;

import io.schoolspointframework.accountancy.domain.Accountancy;
import io.schoolspointframework.accountancy.domain.StudentPaymentEntry;
import io.schoolspointframework.accountancy.domain.StudentPaymentEntryInfoParams;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@RequiredArgsConstructor
public class KafkaAccountancyEventEndpoints implements AccountancyEventEndpoints {

    private @NonNull
    final Accountancy accountancy;

    public void handleRegisterNewApplicant(StudentPaymentEntryInfoParams params) {
        StudentPaymentEntry
                .create(params, accountancy)
                .onSuccess(accountancy::add);
    }
}
