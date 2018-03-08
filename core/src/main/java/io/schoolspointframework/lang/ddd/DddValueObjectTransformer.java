package io.schoolspointframework.lang.ddd;

import io.schoolspointframework.lang.ddd.annotations.DddValueObject;
import io.schoolspointframework.lang.transformer.SchoolspointCompileTimeTransformer;
import javassist.CtClass;

import javax.persistence.Embeddable;

/**
 * @author Bhuwan Prasad Upadhyay
 */
final class DddValueObjectTransformer extends SchoolspointCompileTimeTransformer {

    @Override
    protected boolean activateOnlyIf(CtClass ctClass) throws Exception {
        return ctClass.hasAnnotation(DddValueObject.class);
    }

    @Override
    protected void instrument(final CtClass ctClass) {
        addClassLevelAnnotation(ctClass, Embeddable.class);
    }


}
