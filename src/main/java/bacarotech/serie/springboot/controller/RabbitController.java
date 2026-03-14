package bacarotech.serie.springboot.controller;

import bacarotech.serie.springboot.queue.RabbitProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbit")
public class RabbitController {
    @Autowired
    private RabbitProducer rabbitProducer;

    @PostMapping
    public ResponseEntity<String> produceMessage(
            @RequestParam(value = "message", required = true) String message
    ) {
        this.rabbitProducer.produceMessage(message);

        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

}
