package com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.administration;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class EmployeeMySQLAdapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String position;
    private Integer salary;

    @OneToOne
    @JoinColumn(name = "personId")
    private PersonMySQLAdapter person;
}
