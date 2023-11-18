package com.shilay.elasticsearchservice.repository;

import com.shilay.elasticsearchservice.dto.Employee;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;

public interface EmployeeRepository extends ReactiveElasticsearchRepository<Employee, Long> {
}
