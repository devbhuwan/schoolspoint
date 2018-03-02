package io.schoolspointframework.core.ddd.runtime.agent;

import java.lang.instrument.ClassFileTransformer;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public enum DddJavassistAgentFactory {
    INSTANCE;

    public List<ClassFileTransformer> transformers() {
        return unmodifiableList(asList(
                new DddEntityTransformer(),
                new DddEntityIdentifierTransformer(),
                new DddValueObjectTransformer()
        ));
    }

}
