package com.SuperMarket.SuperMarket.application.billing.service;

import com.SuperMarket.SuperMarket.application.billing.ports.bill.in.BillConfirmation;
import com.SuperMarket.SuperMarket.application.billing.ports.bill.in.BillInitialization;
import com.SuperMarket.SuperMarket.application.billing.ports.bill.in.LineItemAddition;
import com.SuperMarket.SuperMarket.application.billing.ports.bill.out.BillCreatedPort;
import com.SuperMarket.SuperMarket.application.billing.ports.product.out.ProductConsultPort;
import com.SuperMarket.SuperMarket.domain.admin.Customer;
import com.SuperMarket.SuperMarket.domain.admin.Employee;
import com.SuperMarket.SuperMarket.domain.finance.Bill;
import com.SuperMarket.SuperMarket.domain.finance.InvoiceLineItem;
import com.SuperMarket.SuperMarket.domain.product.Product;

public class BillService implements BillInitialization, LineItemAddition, BillConfirmation {

    private BillCreatedPort billCreatedPort;
    private ProductConsultPort productConsultPort;


    public BillService(final BillCreatedPort billCreatedPort,
                       final ProductConsultPort productConsultPort) {
        this.billCreatedPort = billCreatedPort;
        this.productConsultPort = productConsultPort;
    }

    @Override
    public Bill billInitialization(Customer customer, Employee employee) {
        Bill bill = new Bill(customer, employee);
        return bill;
    }

    @Override
    public Boolean lineItemAddition(String productSku, Bill bill, Integer quantity) {
        Product product = productConsultPort.getProductBySKU(productSku);
        InvoiceLineItem invoiceLineItem = new InvoiceLineItem(product, quantity);
        return bill.setLineItem(invoiceLineItem);
    }

    @Override
    public Bill billConfirmation(Bill bill) {
        //TODO add isEmployee logic
        bill.confirmBillAndGetTotalLineItem(Boolean.TRUE);
        return bill;
    }
}
