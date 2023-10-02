package com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public class GenericEntity {
    @Column(name = "status")
    private String status;
}
