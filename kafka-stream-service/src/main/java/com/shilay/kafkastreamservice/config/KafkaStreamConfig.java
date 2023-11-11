package com.shilay.kafkastreamservice.config;

import com.shilay.kafkastreamservice.dto.Car;
import com.shilay.kafkastreamservice.dto.CarAndEmployee;
import com.shilay.kafkastreamservice.dto.Employee;
import com.shilay.kafkastreamservice.dto.EmployeeWithCars;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.serializer.JsonSerde;

import java.util.function.BiConsumer;

@Configuration
public class KafkaStreamConfig {

    @Bean
    public BiConsumer<KTable<String, Employee>, KTable<String, Car>> process() {
        return (employees, cars) -> cars
                .join(
                        employees,
                        car -> car.getEmployeeId().toString(),
                        CarAndEmployee::new
                )
                .groupBy((key, value) -> KeyValue.pair(
                                value.getEmployee().getId().toString(), value)
//                        Grouped.with(Serdes.String(), new JsonSerde<>(CarAndEmployee.class))
                )
                .aggregate(
                        EmployeeWithCars::new,
                        (employeeId, carAndEmployee, employeeWithCars) -> employeeWithCars.addCar(carAndEmployee),
                        (employeeId, carAndEmployee, employeeWithCars) -> employeeWithCars.removeCar(carAndEmployee)
//                        Materialized.with(Serdes.String(), new JsonSerde<>(EmployeeWithCars.class))
                )
                .toStream()
                .foreach((key, value) -> System.out.println("***RESULT*** KEY: " + key + " VALUE: " + value));
    }
}
