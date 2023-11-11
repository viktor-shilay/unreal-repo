package com.shilay.kafkastreamservice.dto;

import lombok.Data;

@Data
public class CarAndEmployee {

    private Car car;
    private Employee employee;

    public CarAndEmployee() {

    }

    public CarAndEmployee (Car car, Employee employee) {
        this.car = car;
        this.employee = employee;
    }
}
