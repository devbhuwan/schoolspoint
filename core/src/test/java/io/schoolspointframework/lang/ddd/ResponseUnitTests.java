package io.schoolspointframework.lang.ddd;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.Set;

import static io.schoolspointframework.lang.ddd.Response.all;
import static io.schoolspointframework.lang.ddd.Response.failure;
import static io.schoolspointframework.lang.ddd.ValidationError.of;
import static io.schoolspointframework.lang.ddd.ValidationError.raiseIfWithMessage;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Bhuwan Prasad Upadhyay
 */
class ResponseUnitTests {
    private static final Set<ValidationError> ERROR_SET_1 = of(raiseIfWithMessage(true, "a", "b"));
    private static final Set<ValidationError> ERROR_SET_2 =
            of(raiseIfWithMessage(true, "1", "2"),
                    raiseIfWithMessage(true, "3", "4"));

    @Test
    void successResponseCreateCorrectlyWithVoid() {
        assertThat(Response.success().value().isPresent()).isFalse();
    }

    @Test
    void mergeErrorsCorrectly() {
        assertThat(all(failure(Optional.empty(), ERROR_SET_1), failure(Optional.empty(), ERROR_SET_2))
                .error().validationErrors()).hasSize(3);
    }
}