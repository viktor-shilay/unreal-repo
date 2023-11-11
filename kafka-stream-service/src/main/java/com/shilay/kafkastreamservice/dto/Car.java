package com.shilay.kafkastreamservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Car {

    private Long id;
    private String brand;
    private String model;

    @JsonProperty("manufacture_year")
    private String manufactureYear;

    @JsonProperty("engine_type")
    private String engineType;
    private String color;
    private BigDecimal price;

    @JsonProperty("employee_id")
    private Long employeeId;
}
