package io.schoolspointframework.core.ddd;

import org.junit.Test;

import static io.schoolspointframework.core.ddd.MessageFormats.MUST_BE_NOT_BLANK;
import static io.schoolspointframework.core.ddd.ValidationError.raiseIfWithMessage;
import static io.schoolspointframework.core.ddd.ValidationError.raiseIfWithMessageFormat;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public class ValidationErrorUnitTests {

    private static final String FIELD = "name";
    private static final String MESSAGE = "Your name is incorrect";

    @Test
    public void nullObjectHaveEmptyCausedByAndMessage() {
        assertThat(ValidationError.NULL)
                .hasFieldOrPropertyWithValue("causedBy", EMPTY)
                .hasFieldOrPropertyWithValue("message", EMPTY);
    }

    @Test
    public void compareWithCausedByOnlyField() {
        assertThat(raiseIfWithMessage(TRUE, "A", "M").compareTo(raiseIfWithMessage(TRUE, "B", "A")))
                .isLessThan(0);
        assertThat(raiseIfWithMessage(TRUE, "A", "M").compareTo(raiseIfWithMessage(TRUE, "A", "X")))
                .isEqualTo(0);
        assertThat(raiseIfWithMessage(TRUE, "B", "M").compareTo(raiseIfWithMessage(TRUE, "A", "X")))
                .isGreaterThan(0);
    }

    @Test
    public void compareWithCausedByOnlyFieldCaseInsensitiveManner() {
        assertThat(raiseIfWithMessage(TRUE, "A", "M").compareTo(raiseIfWithMessage(TRUE, "a", "X")))
                .isEqualTo(0);
    }

    @Test
    public void rejectsNullSignal() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> raiseIfWithMessage(null, FIELD, MESSAGE));
    }

    @Test
    public void rejectsNullField() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> raiseIfWithMessage(TRUE, null, MESSAGE));
    }

    @Test
    public void rejectsNullMessage() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> raiseIfWithMessage(TRUE, FIELD, null));
    }

    @Test
    public void arrayOfErrorToSetMappedCorrectlySkipNULLError() {
        assertThat(ValidationError.of(
                ValidationError.NULL,
                raiseIfWithMessage(TRUE, FIELD, MESSAGE))
        ).hasSize(1);
    }

    @Test
    public void raisedErrorOnlyIfSignalIsTrue() {
        ValidationError whenSignalIsTrue = raiseIfWithMessage(TRUE, "OK", "MESSAGE");
        assertThat(whenSignalIsTrue.getCausedBy()).isEqualTo("OK");
        assertThat(whenSignalIsTrue.getMessage()).isEqualTo("MESSAGE");

        ValidationError whenSignalISFalse = raiseIfWithMessage(FALSE, "OK", "Ok");
        assertThat(whenSignalISFalse).isEqualTo(ValidationError.NULL);
    }

    @Test
    public void raisedErrorWithFormatMessageByFieldOnlyIfSignalIsTrue() {
        ValidationError whenSignalIsTrue = raiseIfWithMessageFormat(TRUE, "OK", MUST_BE_NOT_BLANK);
        assertThat(whenSignalIsTrue.getCausedBy()).isEqualTo("OK");
        assertThat(whenSignalIsTrue.getMessage()).isEqualTo(format(MUST_BE_NOT_BLANK, "OK"));

        ValidationError whenSignalISFalse = raiseIfWithMessage(FALSE, "OK", "Ok");
        assertThat(whenSignalISFalse).isEqualTo(ValidationError.NULL);
    }
}