package io.schoolspointframework.student.domain;

import io.schoolspointframework.lang.ddd.MessageFormats;
import io.schoolspointframework.lang.ddd.Response;
import io.schoolspointframework.lang.ddd.ValidationError;
import io.schoolspointframework.lang.ddd.annotations.DddValueObject;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.util.Set;

import static io.schoolspointframework.lang.ddd.ValidationError.raiseIfWithMessageFormat;
import static org.apache.commons.lang3.StringUtils.*;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@DddValueObject
@EqualsAndHashCode
@Embeddable
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PACKAGE)
class Name {

    static final Name NULL = new Name(EMPTY, EMPTY, EMPTY);
    private String firstName;
    private String middleName;
    private String lastName;

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
