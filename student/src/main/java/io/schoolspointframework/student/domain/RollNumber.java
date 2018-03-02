package io.schoolspointframework.student.domain;

import io.schoolspointframework.core.ddd.Response;
import io.schoolspointframework.core.ddd.ValidationError;
import io.schoolspointframework.core.ddd.annotations.DddValueObject;
import lombok.*;

import javax.persistence.Embeddable;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static io.schoolspointframework.core.ddd.MessageFormats.MUST_BE_NOT_NULL;
import static io.schoolspointframework.core.ddd.ValidationError.*;
import static java.util.Objects.isNull;

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
        Set<ValidationError> errors = validateEntry(newSequence);
        if (hasErrors(errors))
            return Response.failure(RollNumber.NULL, errors);
        return Response.success(new RollNumber(newSequence));
    }

    private static Set<ValidationError> validateEntry(Integer sequence) {
        return of(raiseIfWithMessageFormat(isNull(sequence), "sequence", MUST_BE_NOT_NULL));
    }

    Integer plusOne() {
        LOCK.lock();
        int plusOne = sequence + 1;
        LOCK.unlock();
        return plusOne;
    }
}
