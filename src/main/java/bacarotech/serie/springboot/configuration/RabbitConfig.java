package bacarotech.serie.springboot.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    @Value("${spring.rabbitmq.queue.test}")
    private String testQueue;

    @Bean
    public Queue testQueue() {
        return new Queue(this.testQueue, false);
    }
}
