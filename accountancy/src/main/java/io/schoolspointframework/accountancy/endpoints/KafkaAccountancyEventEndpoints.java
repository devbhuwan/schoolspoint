package io.schoolspointframework.accountancy.endpoints;

import io.schoolspointframework.accountancy.domain.Accountancy;
import io.schoolspointframework.accountancy.domain.AccountancyEventEndpoints;
import io.schoolspointframework.accountancy.domain.StudentPaymentEntry;
import io.schoolspointframework.accountancy.domain.StudentPaymentEntryInfoParams;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@RequiredArgsConstructor
@Component
@Slf4j
public class KafkaAccountancyEventEndpoints implements AccountancyEventEndpoints {

    private @NonNull
    final Accountancy accountancy;

    @Override
    @StreamListener("RegisteredNewApplicant")
    public void handleRegisterNewApplicant(@Payload StudentPaymentEntryInfoParams params) {
        LOG.info("RegisteredNewApplicant student identifier is [{}]", params.getPaidBy());
        StudentPaymentEntry
                .create(params, accountancy)
                .onSuccess(accountancy::add);
    }
}
