package bacarotech.serie.springboot.queue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitConsumer {

    @RabbitListener(queues = {"${spring.rabbitmq.queue.test}"})
    public void consumeMessage(String message) {
        System.out.println("Consumer consumed this message: " + message);
    }
}
