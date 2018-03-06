package io.schoolspointframework.core.ddd.runtime.agent;

import io.schoolspointframework.core.ddd.annotations.DddEntityIdentifier;
import javassist.CtClass;

import javax.persistence.Embeddable;

/**
 * @author Bhuwan Prasad Upadhyay
 */
final class DddEntityIdentifierTransformer extends AbstractDddRuntimeTransformer {

    @Override
    protected Class<?> annotationClass() {
        return DddEntityIdentifier.class;
    }

    @Override
    protected void instrument(final CtClass ctClass) {
        addClassLevelAnnotation(ctClass, Embeddable.class);
    }


}
