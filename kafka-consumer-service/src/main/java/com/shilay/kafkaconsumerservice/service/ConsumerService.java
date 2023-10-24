package com.shilay.kafkaconsumerservice.service;

import com.shilay.kafkaconsumerservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ConsumerService {

    private final EmployeeRepository employeeRepository;

    @KafkaListener(topics = "unreal-topic.department.employees", groupId = "consumerId")
    public void logEmployeeByKafkaId(@Header(KafkaHeaders.RECEIVED_KEY) Long key, @Header String op) {
        if(op.equals("d")) {
            log.info("Employee with id {} was deleted!", key);
        } else {
            employeeRepository.findById(key).ifPresent(employee -> {
                if(op.equals("c")) {
                    log.info("Employee with id {} was created! [{}]", key, employee);
                }
                if(op.equals("u")) {
                    log.info("Employee with id {} was updated! [{}]", key, employee);
                }
            });
        }
    }
}
