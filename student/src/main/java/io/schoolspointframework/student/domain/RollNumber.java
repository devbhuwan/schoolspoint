package io.schoolspointframework.student.domain;

import io.schoolspointframework.lang.ddd.Response;
import io.schoolspointframework.lang.ddd.annotations.DddValueObject;
import lombok.*;

import javax.persistence.Embeddable;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Supplier;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@DddValueObject
@EqualsAndHashCode
@Embeddable
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PACKAGE)
@Getter(AccessLevel.PACKAGE)
class RollNumber {

    static final RollNumber NULL = new RollNumber(-1);
    static final RollNumber START = new RollNumber(0);
    private static final ReentrantLock LOCK = new ReentrantLock();
    private Integer sequence;

    static Response<RollNumber> create(Grade grade, RollNumberGenerator generator) {
        Integer newSequence = generator.newSequence(grade);
        return Response.of(RollNumber.class)
                .raiseIfNull(newSequence, "rollNumberSequence")
                .getOrElse(rollNumber(newSequence), defaultRollNumber());
    }

    private static Supplier<RollNumber> defaultRollNumber() {
        return () -> RollNumber.NULL;
    }

    private static Supplier<RollNumber> rollNumber(Integer sequence) {
        return () -> new RollNumber(sequence);
    }

    Integer plusOne() {
        LOCK.lock();
        int plusOne = sequence + 1;
        LOCK.unlock();
        return plusOne;
    }
}
