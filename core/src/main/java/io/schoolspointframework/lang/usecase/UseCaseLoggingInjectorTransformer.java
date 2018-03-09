package io.schoolspointframework.lang.usecase;

import io.schoolspointframework.lang.transformer.SchoolspointRuntimeTransformer;
import javassist.CtClass;
import javassist.CtMethod;

import static java.lang.String.format;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public final class UseCaseLoggingInjectorTransformer extends SchoolspointRuntimeTransformer {

    @Override
    protected boolean activateOnlyIf(CtClass ctClass) throws Exception {
        return ctClass.hasAnnotation(UseCaseDesign.class);
    }

    @Override
    protected void instrument(CtClass ctClass) throws Exception {
        CtMethod execute = ctClass.getDeclaredMethod("execute");
        execute.insertBefore(format("LOG.info(\"Finished [%s]\");", ctClass.getName()));
        execute.insertAfter(format("LOG.info(\"Executing [%s]\");", ctClass.getName()));
    }
}
