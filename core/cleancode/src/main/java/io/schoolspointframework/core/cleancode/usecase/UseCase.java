package io.schoolspointframework.core.cleancode.usecase;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@FunctionalInterface
public interface UseCase<I, O> {

    O execute(I model);
}
