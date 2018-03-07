package io.schoolspointframework.core.cleancode.usecase;

import lombok.extern.slf4j.Slf4j;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.util.Optional;

@Slf4j
public class RuntimeAgentInstaller {

    private static volatile Instrumentation instrumentation;

    private RuntimeAgentInstaller() {
        throw new UnsupportedOperationException();
    }

    private static Instrumentation getInstrumentation() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new RuntimePermission("getInstrumentation"));
        }
        Instrumentation instrumentation = RuntimeAgentInstaller.instrumentation;
        if (instrumentation == null) {
            throw new IllegalStateException("The Clean Code agent is not loaded or this method is not called via the system class loader");
        }
        return instrumentation;
    }

    public static void premain(String agentArguments, Instrumentation instrumentation) {
        RuntimeAgentInstaller.instrumentation = instrumentation;
    }

    public static void agentmain(String agentArguments, Instrumentation instrumentation) {
        RuntimeAgentInstaller.instrumentation = instrumentation;
    }

    public static void addTransformers(SchoolspointRuntimeTransformer... transformers) {
        for (ClassFileTransformer t : transformers)
            Optional.ofNullable(t).ifPresent(RuntimeAgentInstaller::add);
    }

    private static void add(ClassFileTransformer transformer) {
        LOG.info("Added transformer [{}]", transformer.getClass().getName());
        getInstrumentation().addTransformer(transformer);
    }
}