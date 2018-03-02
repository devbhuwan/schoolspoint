package io.schoolspointframework.core.ddd.runtime.agent;

import io.schoolspointframework.core.ddd.annotations.DddEntity;
import javassist.CtClass;

import javax.persistence.Entity;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public final class DddEntityTransformer extends AbstractDddAnnotationTransformer {

    @Override
    protected Class<?> annotationClass() {
        return DddEntity.class;
    }

    @Override
    protected void instrument(final CtClass ctClass) {
        addClassLevelAnnotation(ctClass, Entity.class);
    }


}
