package com.example.kafkamessaging;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
    private final KafkaProducerService producerService;
    private final KafkaConsumerService consumerService;

    public KafkaController(KafkaProducerService producerService, KafkaConsumerService consumerService) {
        this.producerService = producerService;
        this.consumerService = consumerService;
    }

    @PostMapping("/messages")
    public void sendMessageToKafka(@RequestBody String message) {
        producerService.sendMessage(message);
    }
    @GetMapping("/messages")
    public String getMessagesFromKafka(){
        return "Hello";
    }
}