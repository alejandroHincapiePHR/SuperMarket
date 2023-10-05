package com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.bill.implementations;

import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.bill.interfaces.BillMapper;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.bill.interfaces.InvoiceLineItemMapper;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.bill.interfaces.TotalLineItemMapper;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.administration.CustomerMySQLEntity;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.administration.EmployeeMySQLEntity;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.bill.BillMySQLEntity;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.bill.InvoiceLineItemMySQLEntity;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.bill.TotalLineItemMySQLEntity;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.administration.implementations.CustomerMapperImp;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.administration.implementations.EmployeeMapperImp;
import com.SuperMarket.SuperMarket.domain.admin.Customer;
import com.SuperMarket.SuperMarket.domain.admin.Employee;
import com.SuperMarket.SuperMarket.domain.finance.Bill;
import java.util.List;

public class BillMapperImp implements BillMapper {
    private CustomerMapperImp customerMapperImp;
    private EmployeeMapperImp employeeMapperImp;
    private InvoiceLineItemMapper invoiceLineItemMapper;
    private TotalLineItemMapper totalLineItemMapper;

    public BillMapperImp(final CustomerMapperImp customerMapperImp, final EmployeeMapperImp employeeMapperImp,
                         final InvoiceLineItemMapper invoiceLineItemMapper, final TotalLineItemMapper totalLineItemMapper) {
        this.customerMapperImp = customerMapperImp;
        this.employeeMapperImp = employeeMapperImp;
        this.invoiceLineItemMapper = invoiceLineItemMapper;
        this.totalLineItemMapper = totalLineItemMapper;
    }

    @Override
    public Bill toDomain(BillMySQLEntity b) {
        Customer customer = customerMapperImp.toDomain(b.getCustomer());
        Employee employee = employeeMapperImp.toDomain(b.getEmployee());
        Bill bill = new Bill(customer, employee, b.getBillId());
        b.getLineItems().stream().map(invoiceLineItemMapper::toDomain).forEach(bill::setLineItem);
        bill.confirmBillAndGetTotalLineItem(Boolean.TRUE);
        return bill;
    }

    @Override
    public BillMySQLEntity toEntity(Bill b) {

        CustomerMySQLEntity customerMySQLEntity = customerMapperImp.toEntity(b.getCustomer());
        EmployeeMySQLEntity employeeMySQLEntity = employeeMapperImp.toEntity(b.getEmployee());
        TotalLineItemMySQLEntity totalLineItemMySQLEntity = totalLineItemMapper.toEntity(b.getTotalLineItem());
        List<InvoiceLineItemMySQLEntity> lineItems =b.getLineItems().stream().map(invoiceLineItemMapper::toEntity).toList();

        BillMySQLEntity billMySQLEntity = new BillMySQLEntity(null, b.getIssueDate(), customerMySQLEntity,
                employeeMySQLEntity,totalLineItemMySQLEntity,lineItems);

        return billMySQLEntity;
    }
}
