package bacarotech.serie.springboot.queue;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitProducer {
    @Value("${spring.rabbitmq.queue.test}")
    private String testQueue;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void produceMessage(String message) {
        this.rabbitTemplate.convertAndSend(this.testQueue, message);
    }
}
