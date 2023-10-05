package com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.bill;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.product.ProductMySQLEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "invoicelineitem")
public class InvoiceLineItemMySQLEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoicelineitemid")
    private Long invoiceLineItemId;

    @ManyToOne
    @JoinColumn(name = "productid")
    private ProductMySQLEntity product;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "taxes")
    private Double taxes;

    @Column(name = "discount")
    private Double discount;

    @Column(name = "subtotal")
    private Double subtotal;

    @Column(name = "points")
    private Double points;

    @Column(name = "taxespct")
    private Double taxesPCT;

    @Column(name = "pointspct")
    private Double pointsPCT;

    @Column(name = "discountpct")
    private Double discountPCT;

}

