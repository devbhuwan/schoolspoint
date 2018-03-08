package io.schoolspointframework.lang.ddd;

import io.schoolspointframework.lang.ddd.annotations.DddValueObject;
import lombok.*;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.EMPTY;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(exclude = "message")
@Getter
@DddValueObject
public class ValidationError implements Comparable<ValidationError> {
    public static final ValidationError NULL = new ValidationError(EMPTY, EMPTY);
    static final String DUPLICATED_CAUSED_BY_ERROR = "Same {causedBy} entries in the validation validationErrors!";
    private final String causedBy;
    private final String message;

    public static ValidationError raiseIfWithMessageFormat(@NonNull Boolean signal, @NonNull String field, @NonNull String format) {
        return raiseIfWithMessage(signal, field, format(format, field));
    }

    public static ValidationError raiseIfWithMessage(@NonNull Boolean signal, @NonNull String field, @NonNull String message) {
        return signal ? new ValidationError(field, message) : ValidationError.NULL;
    }

    public static Set<ValidationError> of(@NonNull ValidationError... errors) {
        return nonNullErrors(errors).collect(Collectors.toSet());
    }

    private static Stream<ValidationError> nonNullErrors(@NonNull ValidationError... errors) {
        return Stream.of(errors).filter(e -> !e.equals(ValidationError.NULL));
    }

    public static boolean hasErrors(Set<ValidationError> errors) {
        return !errors.isEmpty();
    }

    @Override
    public int compareTo(ValidationError o) {
        return this.causedBy.compareToIgnoreCase(o.causedBy);
    }
}

