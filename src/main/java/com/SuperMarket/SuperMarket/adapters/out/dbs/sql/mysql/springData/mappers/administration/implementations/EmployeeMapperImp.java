package com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.administration.implementations;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.administration.Interfaces.EmployeeMapper;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.administration.EmployeeMySQLEntity;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.administration.PersonMySQLEntity;
import com.SuperMarket.SuperMarket.domain.admin.Employee;
import com.SuperMarket.SuperMarket.domain.admin.position.PositionEnum;



public class EmployeeMapperImp implements EmployeeMapper {

    @Override
    public Employee toDomain(EmployeeMySQLEntity e) {

        PositionEnum position = PositionEnum.valueOf(e.getPosition());
        Employee employee = new Employee(e.getPerson().getFirstName(), e.getPerson().getLastName(),
                e.getPerson().getEmail(),e.getPerson().getTelefonNumber(), position, e.getSalary());
        employee.setId(e.getEmployeeId());
        return employee;
    }

    @Override
    public EmployeeMySQLEntity toEntity(Employee e) {

        PersonMySQLEntity person = new PersonMySQLEntity(null, e.getFirstName(), e.getLastName(), e.getEmail(),
                e.getEmail());

        EmployeeMySQLEntity employeeMySQLEntity = new EmployeeMySQLEntity(null,e.getPosition().toString(), e.getSalary(),
                person);

        return employeeMySQLEntity;
    }
}
