package com.SuperMarket.SuperMarket.application.ports.admin.employe.out;

import com.SuperMarket.SuperMarket.domain.admin.Employee;

import java.util.Optional;

@FunctionalInterface
public interface EmployeeByIDPort {

    Optional<Employee> getEmployeeById(Long id);
}
