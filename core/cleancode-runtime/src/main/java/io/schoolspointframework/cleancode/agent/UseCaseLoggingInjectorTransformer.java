package io.schoolspointframework.cleancode.agent;

import io.schoolspointframework.core.cleancode.usecase.SchoolspointRuntimeTransformer;
import io.schoolspointframework.core.cleancode.usecase.UseCase;
import javassist.CtClass;

import static org.apache.commons.lang3.StringUtils.EMPTY;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public class UseCaseLoggingInjectorTransformer extends SchoolspointRuntimeTransformer {

    @Override
    protected boolean activateOnlyIf(CtClass ctClass) throws Exception {
        return hasInterface(ctClass, UseCase.NULL.getClass());
    }

    @Override
    protected void instrument(CtClass ctClass) throws Exception {
        ctClass.getMethod("execute", EMPTY);
    }
}
