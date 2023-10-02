package com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.administration;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.base.GenericEntity;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class CustomerMySQLAdapter extends GenericEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private Integer points;

    @OneToOne
    @JoinColumn(name = "personId")
    private PersonMySQLAdapter person;

}

