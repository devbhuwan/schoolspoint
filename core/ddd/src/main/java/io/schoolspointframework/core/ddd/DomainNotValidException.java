package io.schoolspointframework.core.ddd;

import lombok.Getter;
import lombok.NonNull;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@Getter
public class DomainNotValidException extends RuntimeException {

    private final DomainErrorType errorType;

    public DomainNotValidException(String message, DomainErrorType errorType) {
        super(message);
        this.errorType = errorType;
    }

    public static void raiseIf(@NonNull Boolean signal, @NonNull DomainNotValidException e) {
        if (signal)
            throw e;
    }

    public static DomainNotValidException errorOnField(String message) {
        return new DomainNotValidException(message, DomainErrorType.FIELD);
    }


}
