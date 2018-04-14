package io.schoolspointframework.accountancy.domain;

import io.github.devbhuwan.student.spec.ApplicantRegisteredPayload;
import io.schoolspointframework.lang.ddd.Response;
import io.schoolspointframework.lang.ddd.SchoolspointPersistable;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Supplier;

import static java.lang.String.format;
import static java.math.BigDecimal.valueOf;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@Getter
public class StudentPaymentEntry extends SchoolspointPersistable<StudentPaymentEntryIdentifier> implements AccountancyEntry {

    private static final StudentPaymentEntry NULL = new StudentPaymentEntry(StudentIdentifier.NULL, BigDecimal.ZERO);
    private final StudentIdentifier studentIdentifier;
    private final BigDecimal paidAmount;
    private final LocalDateTime paidAt;
    private final StudentPaymentEntryIdentifier identifier;

    private StudentPaymentEntry(StudentIdentifier studentIdentifier, BigDecimal paidAmount) {
        this.studentIdentifier = studentIdentifier;
        this.paidAmount = paidAmount;
        this.paidAt = LocalDateTime.now();
        this.identifier = new StudentPaymentEntryIdentifier();
    }

    private static Supplier<StudentPaymentEntry> defaultEntry() {
        return () -> StudentPaymentEntry.NULL;
    }

    public static Response<StudentPaymentEntry> create(ApplicantRegisteredPayload payload,
                                                       FeeAccountancy accountancy) {

        return Response
                .of(StudentPaymentEntry.class)
                .raiseIfNull(payload.getPaidBy(), "paidBy")
                .raiseIfBlank(payload.getGradeName(), "gradeName")
                .raiseIfNull(payload.getPaidAmount(), "paidAmount")
                .raiseIfLessThenZero(valueOf(payload.getPaidAmount().doubleValue()), "paidAmount")
                .raiseIfFalse(isPaidAmountEqualToFee(payload, accountancy), "paidAmount", format("paidAmount not equal with fee for grade %s", payload.getGradeName()))
                .getOrElse(entry(payload, accountancy), defaultEntry());
    }

    private static boolean isPaidAmountEqualToFee(ApplicantRegisteredPayload payload, FeeAccountancy accountancy) {
        return accountancy.getFee(payload.getGradeName()).equals(payload.getPaidAmount());
    }

    private static Supplier<StudentPaymentEntry> entry(ApplicantRegisteredPayload payload, FeeAccountancy accountancy) {
        return () -> new StudentPaymentEntry(null, accountancy.getFee(payload.getGradeName()));
    }

    @Override
    public StudentPaymentEntryIdentifier getIdentifier() {
        return identifier;
    }
}
