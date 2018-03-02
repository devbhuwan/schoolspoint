package io.schoolspointframework.core.ddd.runtime.agent;

import io.schoolspointframework.core.ddd.annotations.DddValueObject;
import javassist.CtClass;

import javax.persistence.Embeddable;

/**
 * @author Bhuwan Prasad Upadhyay
 */
final class DddValueObjectTransformer extends AbstractDddAnnotationTransformer {

    @Override
    protected Class<?> annotationClass() {
        return DddValueObject.class;
    }

    @Override
    protected void instrument(final CtClass ctClass) {
        addClassLevelAnnotation(ctClass, Embeddable.class);
    }


}
