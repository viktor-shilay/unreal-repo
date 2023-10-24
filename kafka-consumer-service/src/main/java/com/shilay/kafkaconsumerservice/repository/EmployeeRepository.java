package com.shilay.kafkaconsumerservice.repository;

import com.shilay.kafkaconsumerservice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
