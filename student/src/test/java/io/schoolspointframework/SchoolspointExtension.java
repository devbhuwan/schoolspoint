package io.schoolspointframework;

import lombok.Getter;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.kafka.test.rule.KafkaEmbedded;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.net.ServerSocketFactory;
import java.net.ServerSocket;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@Getter
public class SchoolspointExtension extends SpringExtension {

    public Integer kafkaPort = 9092;
    private KafkaEmbedded kafkaEmbedded;

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        kafkaEmbedded = new KafkaEmbedded(1, false, 2);
        ServerSocket ss = ServerSocketFactory.getDefault().createServerSocket(0);
        kafkaPort = ss.getLocalPort();
        ss.close();
        kafkaEmbedded.setKafkaPorts(kafkaPort);
        kafkaEmbedded.before();
        System.setProperty("spring.cloud.stream.kafka.binder.brokers", "localhost:" + kafkaPort);
        super.beforeAll(context);
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        super.afterAll(context);
        kafkaEmbedded.after();
    }
}
