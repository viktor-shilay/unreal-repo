package com.shilay.kafkastreamservice.config;

import com.shilay.kafkastreamservice.dto.Car;
import com.shilay.kafkastreamservice.dto.Employee;
import com.shilay.kafkastreamservice.service.MessageSender;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.serializer.JsonSerde;

import java.util.function.BiConsumer;

@RequiredArgsConstructor
@Configuration
public class KafkaStreamConfig {

    private final MessageSender messageSender;

    @Bean
    public BiConsumer<KTable<String, Employee>, KTable<String, Car>> process() {
        return (employees, cars) -> cars
                .join(
                        employees,
                        car -> car.getEmployeeId().toString(),
                        Employee::new,
                        Materialized.with(Serdes.String(), new JsonSerde<>(Employee.class))
                )
                .groupBy((key, value) -> KeyValue.pair(
                                value.getId().toString(), value),
                        Grouped.with(Serdes.String(), new JsonSerde<>(Employee.class))
                )
                .aggregate(
                        Employee::new,
                        (employeeId, employee, employeeAgg) -> employeeAgg.addCar(employee),
                        (employeeId, employee, employeeAgg) -> employeeAgg.removeCar(employee),
                        Materialized.with(Serdes.String(), new JsonSerde<>(Employee.class))
                )
                .toStream()
                .foreach((key, value) -> messageSender.sendEmployee(value));
    }
}
