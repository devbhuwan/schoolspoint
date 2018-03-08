package io.schoolspointframework.lang.ddd;

import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.function.Supplier;

import static io.schoolspointframework.lang.ddd.Response.*;
import static io.schoolspointframework.lang.ddd.ResponseError.raiseIfM;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Bhuwan Prasad Upadhyay
 */
class ResponseUnitTests {

    @Test
    void successResponseCreateCorrectlyWithVoid() {
        assertThat(success().value().isPresent()).isFalse();
    }

    @Test
    void errorsAggregatedCorrectly() {
        Supplier<Person> value = Person::new;
        Response<Person> response = of(Person.class, failure(value.get(), Set.of(
                raiseIfM(true, "name", "error"),
                ResponseError.NULL,
                raiseIfM(true, "name", "error")
        ))).getOrElse(value, value);
        assertThat(response.errors()).hasSize(2);
    }
}