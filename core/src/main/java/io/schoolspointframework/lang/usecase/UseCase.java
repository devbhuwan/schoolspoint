package io.schoolspointframework.lang.usecase;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@FunctionalInterface
public interface UseCase<I, O> {

    O execute(I model);
}
