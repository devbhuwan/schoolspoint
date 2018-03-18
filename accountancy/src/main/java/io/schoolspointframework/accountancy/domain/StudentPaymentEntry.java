package io.schoolspointframework.accountancy.domain;

import io.schoolspointframework.lang.ddd.Response;
import io.schoolspointframework.lang.ddd.SchoolspointPersistable;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Supplier;

import static java.lang.String.format;

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

    public static Response<StudentPaymentEntry> create(StudentPaymentEntryInfoParams params,
                                                       FeeAccountancy accountancy) {
        return Response
                .of(StudentPaymentEntry.class)
                .raiseIfNull(params.getPaidBy(), "paidBy")
                .raiseIfBlank(params.getGradeName(), "gradeName")
                .raiseIfNull(params.getPaidAmount(), "paidAmount")
                .raiseIfLessThenZero(params.getPaidAmount(), "paidAmount")
                .raiseIfFalse(isPaidAmountEqualToFee(params, accountancy), "paidAmount", format("paidAmount not equal with fee for grade {%s}", params.getGradeName()))
                .getOrElse(entry(params, accountancy), defaultEntry());
    }

    private static boolean isPaidAmountEqualToFee(StudentPaymentEntryInfoParams params, FeeAccountancy accountancy) {
        return accountancy.getFee(params.getGradeName()).equals(params.getPaidAmount());
    }

    private static Supplier<StudentPaymentEntry> entry(StudentPaymentEntryInfoParams params, FeeAccountancy accountancy) {
        return () -> new StudentPaymentEntry(params.getPaidBy(), accountancy.getFee(params.getGradeName()));
    }

    @Override
    public StudentPaymentEntryIdentifier getIdentifier() {
        return identifier;
    }
}
