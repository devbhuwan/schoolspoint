package io.schoolspointframework.lang.ddd;

import org.junit.jupiter.api.Test;

import static io.schoolspointframework.lang.ddd.ResponseError.raiseIfM;
import static java.lang.Boolean.TRUE;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * @author Bhuwan Prasad Upadhyay
 */
class ResponseErrorUnitTests {

    private static final String FIELD = "name";
    private static final String MESSAGE = "Your name is incorrect";

    @Test
    void nullObjectHaveEmptyCausedByAndMessage() {
        assertThat(ResponseError.NULL)
                .hasFieldOrPropertyWithValue("causedBy", EMPTY)
                .hasFieldOrPropertyWithValue("message", EMPTY);
    }

    @Test
    void compareWithCausedByOnlyField() {
        assertThat(raiseIfM(TRUE, "A", "M").compareTo(raiseIfM(TRUE, "B", "A")))
                .isLessThan(0);
        assertThat(raiseIfM(TRUE, "A", "M").compareTo(raiseIfM(TRUE, "A", "X")))
                .isEqualTo(0);
        assertThat(raiseIfM(TRUE, "B", "M").compareTo(raiseIfM(TRUE, "A", "X")))
                .isGreaterThan(0);
    }

    @Test
    void compareWithCausedByOnlyFieldCaseInsensitiveManner() {
        assertThat(raiseIfM(TRUE, "A", "M").compareTo(raiseIfM(TRUE, "a", "X")))
                .isEqualTo(0);
    }

    @Test
    void rejectsNullSignal() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> raiseIfM(null, FIELD, MESSAGE));
    }

    @Test
    void rejectsNullField() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> raiseIfM(TRUE, null, MESSAGE));
    }

    @Test
    void rejectsNullMessage() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> raiseIfM(TRUE, FIELD, null));
    }

}