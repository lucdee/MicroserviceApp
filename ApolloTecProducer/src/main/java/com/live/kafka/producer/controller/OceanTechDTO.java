package com.live.kafka.producer.controller;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OceanTechDTO {

    private String id;
    private String oceano;
    private String ph;

}
