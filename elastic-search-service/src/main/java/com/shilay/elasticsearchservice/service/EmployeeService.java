package com.shilay.elasticsearchservice.service;

import com.shilay.elasticsearchservice.dto.Employee;
import com.shilay.elasticsearchservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository carRepository;

    public Flux<Employee> findAll() {
        log.info("Getting all employees...");
        return carRepository.findAll();
    }

    public Mono<Employee> create(Employee employee) {
        log.info("Save an employee: {}", employee);
        return carRepository.save(employee);
    }
}
