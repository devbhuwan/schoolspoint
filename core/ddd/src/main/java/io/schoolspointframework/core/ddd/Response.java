package io.schoolspointframework.core.ddd;


import io.schoolspointframework.core.ddd.annotations.DddValueObject;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

import static io.schoolspointframework.core.ddd.ValidationError.hasErrors;
import static java.util.Optional.empty;
import static java.util.stream.Collectors.toSet;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@DddValueObject
public class Response<V> {

    private final V value;
    private final ResponseError error;

    private Response(V value, ResponseError error) {
        this.value = value;
        this.error = error;
    }

    public static <V> Response<V> success(V value) {
        return new Response<>(value, ResponseError.NULL);
    }

    public static <V> Response<V> failure(V value, Set<ValidationError> errors) {
        return new Response<V>(value, new ResponseError(errors));
    }

    public static Response<Optional<Void>> success() {
        return success(empty());
    }

    public static Set<ResponseError> all(Response<?>... responses) {
        return Stream.of(responses).map(Response::error).collect(toSet());
    }

    public static Set<ValidationError> reduce(Response<?>... responses) {
        return Stream.of(all(responses)).reduce(new HashSet<>(), (f, errs) -> errs).stream().map(ResponseError::validationErrors).reduce(new HashSet<>(), (f, errs) -> errs);
    }

    public static <V> boolean hasError(Response<V> response) {
        return hasErrors(response.error().validationErrors());
    }

    public static Response<Optional<Void>> mergeErrors(Set<ValidationError> first, Set<ValidationError> second) {
        return Response.failure(Optional.empty(), Stream.of(first, second).reduce(new HashSet<>(), (f, errs) -> errs));
    }

    private boolean isValid() {
        return error.isEmpty();
    }

    public V value() {
        return value;
    }

    public ResponseError error() {
        return error;
    }

    public Response<V> onSuccess(Function<V, V> save) {
        if (isValid())
            save.apply((V) save);
        return _this();
    }

    private Response<V> _this() {
        return this;
    }
}
