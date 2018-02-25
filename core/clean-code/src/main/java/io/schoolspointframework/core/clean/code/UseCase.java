package io.schoolspointframework.core.clean.code;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@FunctionalInterface
public interface UseCase<I, O> {

    O execute(I model);
}
