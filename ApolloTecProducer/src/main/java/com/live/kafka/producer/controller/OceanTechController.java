package com.live.kafka.producer.controller;

import com.live.kafka.producer.producer.OceanTechProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/ocean")
public class OceanTechController {

    @Autowired
    private OceanTechProducer OceanTechProducer;

    @PostMapping
    public ResponseEntity<OceanTechDTO> create(@RequestBody OceanTechDTO OceanTechDTO){
    	OceanTechDTO ocean = OceanTechDTO.builder().id(UUID.randomUUID().toString()).oceano(OceanTechDTO.getOceano()).ph(OceanTechDTO.getPh()).build();
    	OceanTechProducer.send(ocean);
        return ResponseEntity.status(HttpStatus.CREATED).body(ocean);
    }

}
