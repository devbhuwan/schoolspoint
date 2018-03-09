package io.schoolspointframework.lang.ddd;


import io.schoolspointframework.lang.ddd.annotations.DddValueObject;
import lombok.Getter;
import lombok.NonNull;

import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@DddValueObject
@Getter
public class ResponseError implements Comparable<ResponseError> {
    public static final ResponseError NULL = new ResponseError(EMPTY, EMPTY);
    private final String causedBy;
    private final String message;

    private ResponseError(String causedBy, String message) {
        this.causedBy = isNotBlank(causedBy) ? causedBy : EMPTY;
        this.message = isNotBlank(message) ? message : EMPTY;
    }

    static ResponseError raiseIfF(@NonNull Boolean signal, @NonNull String field, @NonNull String format) {
        return raiseIfM(signal, field, format(format, field));
    }

    static ResponseError raiseIfM(@NonNull Boolean signal, @NonNull String field, @NonNull String message) {
        return signal ? new ResponseError(field, message) : ResponseError.NULL;
    }

    private static boolean isEmpty(ResponseError error) {
        return error.equals(NULL);
    }

    static boolean isNotEmpty(ResponseError error) {
        return !isEmpty(error);
    }

    @Override
    public int compareTo(ResponseError o) {
        return this.causedBy.compareToIgnoreCase(o.causedBy);
    }
}
