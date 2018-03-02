package io.schoolspointframework.student.domain;

import io.schoolspointframework.core.ddd.Response;
import io.schoolspointframework.core.ddd.ValidationError;
import io.schoolspointframework.core.ddd.annotations.DddValueObject;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.util.Set;

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
class RollNumber {

    static final RollNumber NULL = new RollNumber(-1);
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

}
