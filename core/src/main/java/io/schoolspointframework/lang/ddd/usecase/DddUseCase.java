package io.schoolspointframework.lang.ddd.usecase;

import io.schoolspointframework.lang.ddd.Response;
import io.schoolspointframework.lang.usecase.UseCase;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public interface DddUseCase<I, V> extends UseCase<I, Response<V>> {

    @Override
    Response<V> execute(I params);
}
