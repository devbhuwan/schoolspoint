package io.schoolspointframework.core.ddd.runtime;

import java.lang.instrument.Instrumentation;

import static io.schoolspointframework.core.ddd.runtime.agent.DddJavassistAgentFactory.INSTANCE;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public class DddRuntimeAgentAutoConfiguration {

    public static void premain(final String agentArgs,
                               final Instrumentation inst) {
        System.out.printf("[Java-Agent]: Starting %s\n", DddRuntimeAgentAutoConfiguration.class.getSimpleName());
        INSTANCE.transformers().forEach(inst::addTransformer);
    }

}
