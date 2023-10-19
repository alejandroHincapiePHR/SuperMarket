package com.SuperMarket.SuperMarket.application.service;

import com.SuperMarket.SuperMarket.application.ports.bill.in.*;
import com.SuperMarket.SuperMarket.application.ports.bill.out.BillCreatedPort;
import com.SuperMarket.SuperMarket.application.ports.bill.out.GetBillByIDPort;
import com.SuperMarket.SuperMarket.application.ports.product.out.GetProductBySkuPort;
import com.SuperMarket.SuperMarket.domain.admin.Customer;
import com.SuperMarket.SuperMarket.domain.admin.Employee;
import com.SuperMarket.SuperMarket.domain.finance.Bill;
import com.SuperMarket.SuperMarket.domain.finance.InvoiceLineItem;
import com.SuperMarket.SuperMarket.domain.product.Product;

import java.util.List;


public class BillService implements BillCreationUseCase,  GetBillByIDUseCase {

    private BillCreatedPort billCreatedPort;
    private GetBillByIDPort getBillByIDPort;

    public BillService(final BillCreatedPort billCreatedPort,  final GetBillByIDPort getBillByIDPort) {
        this.billCreatedPort = billCreatedPort;
        this.getBillByIDPort = getBillByIDPort;
    }

    @Override
    public Bill getbillByIdUseCase(Long id) {
        return getBillByIDPort.getBillById(id);
    }

    @Override
    public Long billCreationUseCase(Employee employee, Customer customer, List<Product> products) {
        Bill bill = new Bill(customer, employee, null);
        products.stream().map(x->new InvoiceLineItem(x,1)).forEach(x->bill.setLineItem(x));
        bill.confirmBillAndGetTotalLineItem(Boolean.TRUE);
        return  billCreatedPort.saveBill(bill);
    }
}
