package io.schoolspointframework.core.cleancode.usecase;

import static org.apache.commons.lang3.StringUtils.EMPTY;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@FunctionalInterface
public interface UseCase<I, O> {

    UseCase<String, String> NULL = model -> EMPTY;

    O execute(I model);
}
