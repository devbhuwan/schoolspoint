package io.schoolspointframework.student.domain;

import io.schoolspointframework.lang.ddd.Response;
import io.schoolspointframework.lang.ddd.annotations.DddValueObject;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.util.function.Supplier;

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
        return Response.<Name>create()
                .raiseIfBlank(firstName, "firstName", "")
                .raiseIfBlank(lastName, "lastName", "")
                .getOrElse(name(firstName, middleName, lastName), defaultName());
    }

    private static Supplier<Name> name(String firstName, String middleName, String lastName) {
        return () -> new Name(firstName, isBlank(middleName) ? EMPTY : middleName, lastName);
    }

    private static Supplier<Name> defaultName() {
        return () -> Name.NULL;
    }

    @Override
    public String toString() {
        return firstName + SPACE + middleName + (isBlank(middleName) ? EMPTY : SPACE) + lastName;
    }


}
