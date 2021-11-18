package com.live.kafka.consumer.consumer;

import com.live.kafka.consumer.DTO.OceanTechDTO;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OceanTechConsumer {

    private static final Logger log = LoggerFactory.getLogger(OceanTechConsumer.class);

    @Value(value = "${topic.name}")
    private String topic;

    @Value(value = "${spring.kafka.group-id}")
    private String groupId;

    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.group-id}", containerFactory = "OceanTechKafkaListenerContainerFactory")
    public void listenTopicOceanTech(ConsumerRecord<String, OceanTechDTO> record){
        log.info("Received Message " + record.partition());
        log.info("Received Message " + record.value());
    }


}
