package com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.adapter;

import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.administration.EmployeeMySQLEntity;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.administration.Interfaces.EmployeeMapper;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.repository.administration.EmployeeMySQLRepository;
import com.SuperMarket.SuperMarket.application.ports.admin.employe.out.EmployeeByIDPort;
import com.SuperMarket.SuperMarket.domain.admin.Employee;
import java.util.Optional;


public class EmployeeMySQLAdapter implements EmployeeByIDPort {

    private EmployeeMySQLRepository employeeMySQLRepository;
    private EmployeeMapper employeeMapper;


    public EmployeeMySQLAdapter(final EmployeeMySQLRepository employeeMySQLRepository, final EmployeeMapper employeeMapper) {
        this.employeeMySQLRepository = employeeMySQLRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<EmployeeMySQLEntity> employeeMySQL = employeeMySQLRepository.findById(id);

        if(employeeMySQL.isPresent()){
            return employeeMapper.toDomain(employeeMySQL.get());
        }
        else {
            return null;
        }
    }
}
