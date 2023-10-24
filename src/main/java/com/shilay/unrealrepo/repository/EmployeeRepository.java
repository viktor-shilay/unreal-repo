package com.shilay.unrealrepo.repository;

import com.shilay.unrealrepo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
