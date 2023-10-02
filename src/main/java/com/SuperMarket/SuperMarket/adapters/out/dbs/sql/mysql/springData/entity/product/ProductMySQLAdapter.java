package com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.product;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
public class ProductMySQLAdapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String SKU;
    private Date expirationDate;
    private String productName;
    private String productManufacturer;
    private String productType;
    private Integer availableUnits;
    private Double customerCost;
    private Double companyCost;
}
