package com.SuperMarket.SuperMarket.application.service;

import com.SuperMarket.SuperMarket.application.exceptions.EmployeeNotFoundException;
import com.SuperMarket.SuperMarket.application.ports.admin.employe.in.EmployeeByIDUseCase;
import com.SuperMarket.SuperMarket.application.ports.admin.employe.out.EmployeeByIDPort;
import com.SuperMarket.SuperMarket.domain.admin.Employee;

import java.util.Optional;

public class EmployeeService implements EmployeeByIDUseCase {

    private EmployeeByIDPort employeeByIDPort;


    public EmployeeService(final EmployeeByIDPort employeeByIDPort) {
        this.employeeByIDPort = employeeByIDPort;
    }

    @Override
    public Employee employeeById(Long id) throws EmployeeNotFoundException {
        Optional<Employee> employeeOptional = employeeByIDPort.getEmployeeById(id);
        if(employeeOptional.isEmpty()){
            throw new EmployeeNotFoundException();
        }
        return employeeOptional.get();
    }
}
