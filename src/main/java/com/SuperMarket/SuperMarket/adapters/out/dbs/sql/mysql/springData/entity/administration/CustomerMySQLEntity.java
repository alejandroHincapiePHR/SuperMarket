package com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.administration;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.base.GenericEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Customer")
public class CustomerMySQLEntity extends GenericEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerid")
    private Long customerId;
    private Integer points;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personid")
    private PersonMySQLEntity person;

}

