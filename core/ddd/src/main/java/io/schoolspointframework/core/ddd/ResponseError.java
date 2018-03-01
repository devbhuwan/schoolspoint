package io.schoolspointframework.core.ddd;


import io.schoolspointframework.core.ddd.annotations.DddValueObject;
import lombok.EqualsAndHashCode;

import java.util.Objects;
import java.util.Set;

import static java.util.Collections.emptySet;
import static java.util.Collections.unmodifiableSet;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@EqualsAndHashCode
@DddValueObject
public class ResponseError {

    public static final ResponseError NULL = new ResponseError(emptySet());
    private final Set<ValidationError> errors;

    public ResponseError(Set<ValidationError> errors) {
        this.errors = unmodifiableSet(errors);
    }

    public Set<ValidationError> validationErrors() {
        return errors;
    }

    public boolean hasNoError() {
        return this.equals(NULL);
    }

    public ValidationError validationError(String causedBy) {
        return errors.stream().filter(e -> Objects.equals(e.getCausedBy(), causedBy)).findFirst().orElse(ValidationError.NULL);
    }

}
