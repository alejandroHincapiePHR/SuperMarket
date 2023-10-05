package com.SuperMarket.SuperMarket.application.ports.admin.employe.out;

import com.SuperMarket.SuperMarket.domain.admin.Employee;

@FunctionalInterface
public interface EmployeeByIDPort {

    Employee getEmployeeById(Long id);
}
