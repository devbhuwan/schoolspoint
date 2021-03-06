package io.schoolspointframework.lang.ddd;


import io.schoolspointframework.lang.ddd.annotations.DddValueObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static java.util.Optional.empty;
import static java.util.stream.Collectors.toSet;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@DddValueObject
public class Response<V> {

    private static final Logger LOG = LoggerFactory.getLogger(Response.class);
    private final V value;
    private final Set<ResponseError> errors;

    private Response(V value, ResponseError... errors) {
        this(value, Stream.of(errors).collect(toSet()));
    }

    private Response(V value, Set<ResponseError> errors) {
        this.value = value;
        this.errors = errors.stream().filter(ResponseError::isNotEmpty).collect(toSet());
    }

    static <V> Response<V> success(V value) {
        return new Response<>(value, ResponseError.NULL);
    }

    static <V> Response<V> failure(V value, Set<ResponseError> errors) {
        return new Response<>(value, errors);
    }

    static Response<Optional<Void>> success() {
        return success(empty());
    }

    public static <V> ResponseSpec<V> of(Class<V> vClass, Response<?>... responses) {
        LOG.info("Creating Response [{}]", vClass.getName());
        Set<ResponseError> errors = new LinkedHashSet<>();
        stream(responses).forEachOrdered(r -> errors.addAll(r.errors()));
        return ResponseSpec.create(errors);
    }

    private boolean isValid() {
        return errors.isEmpty();
    }

    public V value() {
        return value;
    }

    public Set<ResponseError> errors() {
        return errors;
    }

    public <T> Response<V> onSuccess(Function<V, T> save) {
        if (isValid())
            save.apply(value);
        return _this();
    }

    private Response<V> _this() {
        return this;
    }

    public Response<Optional<Void>> thenReturn() {
        if (this.isInvalid()) {
            return Response.failure(Optional.empty(), this.errors());
        }
        return Response.success();
    }

    private boolean isInvalid() {
        return !isValid();
    }
}
