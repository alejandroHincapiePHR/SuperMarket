package com.SuperMarket.SuperMarket.application.ports.admin.employe.in;

import com.SuperMarket.SuperMarket.domain.admin.Employee;

import java.util.Optional;

@FunctionalInterface
public interface EmployeeByIDUseCase {

    Employee employeeById(Long id);
}
