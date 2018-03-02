package io.schoolspointframework.core.ddd.runtime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.instrument.classloading.LoadTimeWeaver;

import static io.schoolspointframework.core.ddd.runtime.agent.DddJavassistAgentFactory.INSTANCE;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@Configuration
public class DddJavassistAgentAutoConfiguration {

    @Bean
    public LoadTimeWeaver loadTimeWeaver() {
        InstrumentationLoadTimeWeaver loadTimeWeaver = new InstrumentationLoadTimeWeaver();
        INSTANCE.transformers().forEach(loadTimeWeaver::addTransformer);
        return loadTimeWeaver;
    }
}
