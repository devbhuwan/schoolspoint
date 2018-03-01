package io.schoolspointframework.core.ddd.usecase;

import io.schoolspointframework.core.cleancode.usecase.UseCase;
import io.schoolspointframework.core.ddd.InfoParameters;
import io.schoolspointframework.core.ddd.Response;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public interface DddUseCase<I extends InfoParameters, V> extends UseCase<I, Response<V>> {

    @Override
    Response<V> execute(I params);
}
