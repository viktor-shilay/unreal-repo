package com.shilay.kafkastreamservice.service;

import com.shilay.kafkastreamservice.dto.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Service
public class MessageSender {

    private static final String EMPLOYEES_URL = "/employees";

    private final WebClient webClient;

    public void sendEmployee(Employee employee) {
        webClient.post()
                .uri(EMPLOYEES_URL)
                .body(Mono.just(employee), Employee.class)
                .retrieve()
                .bodyToMono(Employee.class)
                .subscribe(response -> log.info("{} was successfully saved!", response));
    }
}
