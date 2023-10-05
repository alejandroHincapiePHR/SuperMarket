package com.SuperMarket.SuperMarket.application.service;

import com.SuperMarket.SuperMarket.application.ports.bill.in.BillConfirmation;
import com.SuperMarket.SuperMarket.application.ports.bill.in.BillInitialization;
import com.SuperMarket.SuperMarket.application.ports.bill.in.GetBillByIDUseCase;
import com.SuperMarket.SuperMarket.application.ports.bill.in.LineItemAddition;
import com.SuperMarket.SuperMarket.application.ports.bill.out.BillCreatedPort;
import com.SuperMarket.SuperMarket.application.ports.bill.out.GetBillByIDPort;
import com.SuperMarket.SuperMarket.application.ports.product.out.ProductConsultPort;
import com.SuperMarket.SuperMarket.domain.admin.Customer;
import com.SuperMarket.SuperMarket.domain.admin.Employee;
import com.SuperMarket.SuperMarket.domain.finance.Bill;
import com.SuperMarket.SuperMarket.domain.finance.InvoiceLineItem;
import com.SuperMarket.SuperMarket.domain.product.Product;


public class BillService implements BillInitialization, LineItemAddition, BillConfirmation, GetBillByIDUseCase {

    private BillCreatedPort billCreatedPort;
    private ProductConsultPort productConsultPort;
    private GetBillByIDPort getBillByIDPort;

    public BillService(final BillCreatedPort billCreatedPort,
                       final ProductConsultPort productConsultPort, final GetBillByIDPort getBillByIDPort) {
        this.billCreatedPort = billCreatedPort;
        this.productConsultPort = productConsultPort;
        this.getBillByIDPort = getBillByIDPort;
    }

    @Override
    public Bill billInitialization(Customer customer, Employee employee) {
        Bill bill = new Bill(customer, employee, null);

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
        billCreatedPort.saveBill(bill);
        return bill;
    }

    @Override
    public Bill getbillByIdUseCase(Long id) {
        return getBillByIDPort.getBillById(id);
    }
}
