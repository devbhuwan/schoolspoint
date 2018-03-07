package io.schoolspointframework.core.cleancode.usecase;

import javassist.CtClass;
import javassist.CtMethod;

import static java.lang.String.format;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public class UseCaseLoggingInjectorTransformer extends SchoolspointRuntimeTransformer {

    @Override
    protected boolean activateOnlyIf(CtClass ctClass) throws Exception {
        return ctClass.hasAnnotation(UseCaseDecorator.class);
    }

    @Override
    protected void instrument(CtClass ctClass) throws Exception {
        CtMethod execute = ctClass.getDeclaredMethod("execute");
        execute.insertAfter(format("LOG.info(\"Executing [%s]\");", ctClass.getName()));
        execute.insertBefore(format("LOG.info(\"Finished [%s]\");", ctClass.getName()));
    }
}
