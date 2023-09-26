package com.shilay.unrealrepo.service;

import com.shilay.unrealrepo.repository.EmployeeRepository;
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
    public void logEmployeeByKafkaId(@Header(KafkaHeaders.RECEIVED_KEY) Long key) {
        employeeRepository.findById(key).ifPresent(employee -> log.info(String.valueOf(employee)));
    }
}
