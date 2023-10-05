package com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "product")
public class ProductMySQLEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "sku")
    private String SKU;
    @Column(name = "expirationdate")
    private Date expirationDate;
    @Column(name = "productname")
    private String productName;
    @Column(name = "productmanufacturer")
    private String productManufacturer;
    @Column(name = "Producttype")
    private String productType;
    @Column(name = "availableunits")
    private Integer availableUnits;
    @Column(name = "customercost")
    private Double customerCost;
    @Column(name = "companycost")
    private Double companyCost;
}
