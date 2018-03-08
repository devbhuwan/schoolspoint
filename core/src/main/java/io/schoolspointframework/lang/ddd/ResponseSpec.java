package io.schoolspointframework.lang.ddd;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static io.schoolspointframework.lang.ddd.MessageFormats.MUST_BE_NOT_BLANK;
import static io.schoolspointframework.lang.ddd.MessageFormats.MUST_BE_NOT_NULL;
import static io.schoolspointframework.lang.ddd.Response.failure;
import static io.schoolspointframework.lang.ddd.Response.success;
import static io.schoolspointframework.lang.ddd.ResponseError.raiseIfF;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toSet;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public class ResponseSpec<V> {
    private final Set<ResponseError> errors = new LinkedHashSet<>();

    private ResponseSpec(Set<ResponseError> errors) {
        errors.addAll(ofNullable(errors)
                .stream()
                .flatMap(Set::stream)
                .filter(ResponseError::isNotEmpty)
                .collect(toSet()));
    }

    public static <T> ResponseSpec<T> create() {
        return new ResponseSpec<>(new HashSet<>());
    }

    public static <T> ResponseSpec<T> create(Set<ResponseError> errors) {
        return new ResponseSpec<>(errors);
    }

    private ResponseSpec<V> addIfNotEmptyAndThenReturn(ResponseError error) {
        if (error.isNotEmpty())
            errors.add(error);
        return _this();
    }

    private ResponseSpec<V> _this() {
        return this;
    }

    public Response<V> getOrElse(Supplier<V> value, Supplier<V> defaultGet) {
        if (errors.isEmpty())
            return success(value.get());
        else
            return failure(defaultGet.get(), errors);
    }

    public ResponseSpec<V> raiseIfBlank(String value, String causedBy, String message) {
        return addIfNotEmptyAndThenReturn(raiseIfF(isBlank(value), causedBy, message));
    }

    public ResponseSpec<V> raiseIfBlank(String value, String causedBy) {
        return addIfNotEmptyAndThenReturn(raiseIfF(isBlank(value), causedBy, MUST_BE_NOT_BLANK));
    }

    public ResponseSpec<V> raiseIfNull(Object o, String causedBy) {
        return addIfNotEmptyAndThenReturn(raiseIfF(Objects.isNull(o), causedBy, MUST_BE_NOT_NULL));
    }
}
