package com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.bill;

import jakarta.persistence.*;
import lombok.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "totallineitem")
public class TotalLineItemMySQLEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "totallineitemid")
    private Long totalLineItemId;

    @Column(name = "employeediscount")
    private Double employeeDiscount;

    @Column(name = "totalquantityproducts")
    private Integer totalQuantityProducts;

    @Column(name = "totaldiscount")
    private Double totalDiscount;

    @Column(name = "totaltaxes")
    private Double totalTaxes;

    @Column(name = "totaltopay")
    private Double totalToPay;

    @Column(name = "totalaccumulatedpoints")
    private Double totalAccumulatedPoints;
}

