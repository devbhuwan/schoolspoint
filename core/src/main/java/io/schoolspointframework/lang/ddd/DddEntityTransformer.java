package io.schoolspointframework.lang.ddd;

import io.schoolspointframework.lang.ddd.annotations.DddEntity;
import io.schoolspointframework.lang.transformer.SchoolspointCompileTimeTransformer;
import javassist.CtClass;

import javax.persistence.Entity;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public final class DddEntityTransformer extends SchoolspointCompileTimeTransformer {

    @Override
    protected boolean activateOnlyIf(CtClass ctClass) {
        return ctClass.hasAnnotation(DddEntity.class);
    }

    @Override
    protected void instrument(final CtClass ctClass) {
        addClassLevelAnnotation(ctClass, Entity.class);
    }


}
