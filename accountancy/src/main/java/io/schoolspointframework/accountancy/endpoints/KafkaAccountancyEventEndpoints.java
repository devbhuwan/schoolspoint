package io.schoolspointframework.accountancy.endpoints;

import io.schoolspointframework.accountancy.domain.Accountancy;
import io.schoolspointframework.accountancy.domain.AccountancyEventEndpoints;
import io.schoolspointframework.accountancy.domain.StudentPaymentEntry;
import io.schoolspointframework.accountancy.domain.StudentPaymentEntryInfoParams;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@RequiredArgsConstructor
@Component
public class KafkaAccountancyEventEndpoints implements AccountancyEventEndpoints {

    private @NonNull
    final Accountancy accountancy;

    @Override
    public void handleRegisterNewApplicant(StudentPaymentEntryInfoParams params) {
        StudentPaymentEntry
                .create(params, accountancy)
                .onSuccess(accountancy::add);
    }
}
