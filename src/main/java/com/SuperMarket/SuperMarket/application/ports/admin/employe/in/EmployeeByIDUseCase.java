package com.SuperMarket.SuperMarket.application.ports.admin.employe.in;

import com.SuperMarket.SuperMarket.domain.admin.Employee;

@FunctionalInterface
public interface EmployeeByIDUseCase {

    Employee employeeById(Long id);
}
