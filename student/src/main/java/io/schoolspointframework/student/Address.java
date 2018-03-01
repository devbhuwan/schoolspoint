package io.schoolspointframework.student;

import io.schoolspointframework.core.ddd.Response;
import io.schoolspointframework.core.ddd.ValidationError;
import io.schoolspointframework.core.ddd.annotations.DddValueObject;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Set;

import static io.schoolspointframework.core.ddd.MessageFormats.MUST_BE_NOT_BLANK;
import static io.schoolspointframework.core.ddd.ValidationError.*;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@DddValueObject
@FieldDefaults(makeFinal = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
class Address {

    static final Address NULL = new Address(EMPTY, EMPTY, EMPTY, EMPTY);
    private String name;
    private String street;
    private String city;
    private String zipCode;


    public static Response<Address> create(String name, String street, String city, String zipCode) {
        Set<ValidationError> errors = validateEntry(name);
        if (hasErrors(errors))
            return Response.failure(Address.NULL, errors);
        return Response.success(new Address(name,
                isBlank(city) ? EMPTY : city,
                isBlank(city) ? EMPTY : street,
                isBlank(city) ? EMPTY : zipCode)
        );
    }

    private static Set<ValidationError> validateEntry(String name) {
        return of(raiseIfWithMessageFormat(isBlank(name), "name", MUST_BE_NOT_BLANK));
    }


}
