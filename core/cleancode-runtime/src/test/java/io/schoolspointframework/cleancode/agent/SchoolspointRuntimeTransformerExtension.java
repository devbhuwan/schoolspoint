package io.schoolspointframework.cleancode.agent;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static io.schoolspointframework.core.cleancode.usecase.RuntimeAgentInstaller.addTransformers;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@Slf4j
public class SchoolspointRuntimeTransformerExtension implements BeforeAllCallback {

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        LOG.info("beforeAll");
        addTransformers(new UseCaseLoggingInjectorTransformer());
    }
}
