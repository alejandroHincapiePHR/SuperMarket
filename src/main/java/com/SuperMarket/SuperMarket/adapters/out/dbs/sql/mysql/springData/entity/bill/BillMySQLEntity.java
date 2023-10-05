package com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.bill;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.administration.CustomerMySQLEntity;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.administration.EmployeeMySQLEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Bill")
public class BillMySQLEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "billid")
    private Long billId;

    @Column(name = "issuedate")
    private Date issueDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerid")
    private CustomerMySQLEntity customer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employeeid")
    private EmployeeMySQLEntity employee;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "totallineitemid")
    private TotalLineItemMySQLEntity totalLineItem;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "bill_invoicelineitem",
            joinColumns = @JoinColumn(name = "billid"),
            inverseJoinColumns = @JoinColumn(name = "invoicelineitemid")
    )
    private List<InvoiceLineItemMySQLEntity> lineItems;


}

