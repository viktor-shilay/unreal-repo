package com.shilay.kafkastreamservice.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Car {

    private Long id;
    private String brand;
    private String model;
    private String manufactureYear;
    private String engineType;
    private String color;
    private BigDecimal price;
    private Long employeeId;
}
