package com.SuperMarket.SuperMarket.application.service;

import com.SuperMarket.SuperMarket.application.ports.admin.employe.in.EmployeeByIDUseCase;
import com.SuperMarket.SuperMarket.application.ports.admin.employe.out.EmployeeByIDPort;
import com.SuperMarket.SuperMarket.domain.admin.Employee;

public class EmployeeService implements EmployeeByIDUseCase {

    private EmployeeByIDPort employeeByIDPort;


    public EmployeeService(final EmployeeByIDPort employeeByIDPort) {
        this.employeeByIDPort = employeeByIDPort;
    }

    @Override
    public Employee employeeById(Long id) {
        return employeeByIDPort.getEmployeeById(id);
    }
}
