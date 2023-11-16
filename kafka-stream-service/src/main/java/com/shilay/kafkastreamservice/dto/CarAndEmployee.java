package com.shilay.kafkastreamservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarAndEmployee {

    private Car car;
    private Employee employee;
}
