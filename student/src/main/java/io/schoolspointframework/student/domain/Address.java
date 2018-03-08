package io.schoolspointframework.student.domain;

import io.schoolspointframework.lang.ddd.Response;
import io.schoolspointframework.lang.ddd.ValueObject;
import io.schoolspointframework.lang.ddd.annotations.DddValueObject;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Embeddable;
import java.util.Objects;
import java.util.function.Supplier;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@DddValueObject
@FieldDefaults(makeFinal = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(force = true, access = AccessLevel.PACKAGE)
@Embeddable
class Address extends ValueObject {

    static final Address NULL = new Address(EMPTY, EMPTY, EMPTY, EMPTY);
    private String name;
    private String street;
    private String city;
    private String zipCode;

    static Response<Address> create(String name, String street, String city, String zipCode) {
        return Response.create(Address.class)
                .raiseIfBlank(name, "addressName", "student.address.name.must.be.not.blank")
                .getOrElse(address(name, street, city, zipCode), defaultAddress());
    }

    private static Supplier<Address> defaultAddress() {
        return () -> Address.NULL;
    }

    private static Supplier<Address> address(String name, String street, String city, String zipCode) {
        return () -> new Address(name,
                isBlank(city) ? EMPTY : city,
                isBlank(city) ? EMPTY : street,
                isBlank(city) ? EMPTY : zipCode);
    }

    @Override
    public int valueHashCode() {
        return Objects.hash(name);
    }

}
