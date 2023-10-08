package com.example.kafkamessaging;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
// following articles used
// https://www.stackchief.com/blog/%40KafkaListener%20%7C%20Spring%20Boot%20Example
// https://www.baeldung.com/spring-kafka
// https://coderanch.com/t/770966/java/Kafka-consumer-message-consumed-multiple
// https://levelup.gitconnected.com/how-to-integrate-kafka-with-spring-boot-47c0ee01b65d
//
@RestController
public class KafkaController {
    private final KafkaProducerService producerService;

    public KafkaController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/messages")
    public void sendMessageToKafka(@RequestBody String message) {
        producerService.sendMessage(message);
    }

}