package com.shilay.kafkastreamservice.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Employee {

    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private LocalDate birthDate;
    private Role role;
    private List<Car> cars = new ArrayList<>();

    public Employee(Car car, Employee employee) {
        setFields(employee);
        this.cars.add(car);
    }

    public Employee addCar(Employee employee) {
        setFields(employee);
        cars.addAll(employee.getCars());
        return this;
    }

    public Employee removeCar(Employee employee) {
        cars.removeAll(employee.getCars());
        return this;
    }

    public enum Role {
        JAVA_DEV, PM, UNEMPLOYED
    }

    private void setFields(Employee employee) {
        this.id = employee.getId();
        this.username = employee.getUsername();
        this.firstname = employee.getFirstname();
        this.lastname = employee.getLastname();
        this.birthDate = employee.getBirthDate();
        this.role = employee.getRole();
    }
}
