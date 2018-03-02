package io.schoolspointframework.student.domain;

import io.schoolspointframework.core.ddd.MessageFormats;
import io.schoolspointframework.core.ddd.Response;
import io.schoolspointframework.core.ddd.ValidationError;
import io.schoolspointframework.core.ddd.annotations.DddValueObject;
import lombok.EqualsAndHashCode;

import java.util.Set;

import static io.schoolspointframework.core.ddd.ValidationError.raiseIfWithMessageFormat;
import static org.apache.commons.lang3.StringUtils.*;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@DddValueObject
@EqualsAndHashCode
class Name {

    static final Name NULL = new Name(EMPTY, EMPTY, EMPTY);
    private String firstName;
    private String middleName;
    private String lastName;

    private Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    static Response<Name> create(String firstName, String middleName, String lastName) {
        Set<ValidationError> errors = validateEntry(firstName, lastName);
        if (ValidationError.hasErrors(errors))
            return Response.failure(Name.NULL, errors);
        return Response.success(new Name(firstName, isBlank(middleName) ? EMPTY : middleName, lastName));
    }

    private static Set<ValidationError> validateEntry(String firstName, String lastName) {
        return ValidationError.of(
                raiseIfWithMessageFormat(isBlank(firstName), "firstName", MessageFormats.MUST_BE_NOT_BLANK),
                raiseIfWithMessageFormat(isBlank(lastName), "lastName", MessageFormats.MUST_BE_NOT_BLANK));
    }

    @Override
    public String toString() {
        return firstName + SPACE + middleName + (isBlank(middleName) ? EMPTY : SPACE) + lastName;
    }


}
