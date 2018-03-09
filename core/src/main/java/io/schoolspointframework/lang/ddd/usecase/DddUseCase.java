package io.schoolspointframework.lang.ddd.usecase;

import io.schoolspointframework.lang.usecase.UseCase;
import io.schoolspointframework.lang.ddd.InfoParameters;
import io.schoolspointframework.lang.ddd.Response;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public interface DddUseCase<I extends InfoParameters, V> extends UseCase<I, Response<V>> {

    @Override
    Response<V> execute(I params);
}
