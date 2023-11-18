package com.shilay.elasticsearchservice.controller;

import com.shilay.elasticsearchservice.dto.Employee;
import com.shilay.elasticsearchservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public Flux<Employee> findAll() {
        return employeeService.findAll();
    }

    @PostMapping
    public Mono<Employee> create(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }
}
