package io.schoolspointframework.lang.agent;

import io.schoolspointframework.lang.ddd.DddEntityIdentifierTransformer;
import io.schoolspointframework.lang.ddd.DddEntityTransformer;
import io.schoolspointframework.lang.ddd.DddValueObjectTransformer;
import io.schoolspointframework.lang.transformer.SchoolspointTransformer;
import io.schoolspointframework.lang.usecase.UseCaseLoggingInjectorTransformer;
import lombok.extern.slf4j.Slf4j;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.util.Optional;

@Slf4j
public class AgentInstaller {

    private static volatile Instrumentation instrumentation;

    private AgentInstaller() {
        throw new UnsupportedOperationException();
    }

    private static Instrumentation getInstrumentation() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new RuntimePermission("getInstrumentation"));
        }
        Instrumentation instrumentation = AgentInstaller.instrumentation;
        if (instrumentation == null) {
            throw new IllegalStateException("The Clean Code agent is not loaded or this method is not called via the system class loader");
        }
        return instrumentation;
    }

    public static void premain(String agentArguments, Instrumentation instrumentation) {
        AgentInstaller.instrumentation = instrumentation;
        addTransformers(new UseCaseLoggingInjectorTransformer(), new DddEntityIdentifierTransformer(), new DddEntityTransformer(), new DddValueObjectTransformer());
    }

    public static void agentmain(String agentArguments, Instrumentation instrumentation) {
        AgentInstaller.instrumentation = instrumentation;
    }

    public static void addTransformers(SchoolspointTransformer... transformers) {
        for (ClassFileTransformer t : transformers)
            Optional.ofNullable(t).ifPresent(AgentInstaller::add);
    }

    private static void add(ClassFileTransformer transformer) {
        LOG.info("Added transformer [{}]", transformer.getClass().getName());
        getInstrumentation().addTransformer(transformer);
    }
}