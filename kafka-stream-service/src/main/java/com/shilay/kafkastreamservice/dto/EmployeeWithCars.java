package com.shilay.kafkastreamservice.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class EmployeeWithCars {

    private Employee employee;
    private List<Car> cars = new ArrayList<>();


    public EmployeeWithCars addCar(CarAndEmployee carAndEmployee) {
        employee = carAndEmployee.getEmployee();
        cars.add(carAndEmployee.getCar());
        return this;
    }

    public EmployeeWithCars removeCar(CarAndEmployee carAndEmployee) {
        cars.remove(carAndEmployee.getCar());
        return this;
    }
}
