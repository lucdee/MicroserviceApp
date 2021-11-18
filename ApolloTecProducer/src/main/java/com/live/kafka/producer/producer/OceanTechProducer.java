package com.live.kafka.producer.producer;

import com.live.kafka.producer.controller.OceanTechDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OceanTechProducer {

    private static final Logger logger = LoggerFactory.getLogger(OceanTechProducer.class);
    private final String topic;
    private final KafkaTemplate<String, OceanTechDTO> kafkaTemplate;

    public OceanTechProducer(@Value("${topic.name}") String topic, KafkaTemplate<String, OceanTechDTO> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(OceanTechDTO OceanTechDTO){
        kafkaTemplate.send(topic, OceanTechDTO).addCallback(
                success -> logger.info("Messagem send" + success.getProducerRecord().value()),
                failure -> logger.info("Message failure" + failure.getMessage())
        );
    }
}
