package com.SuperMarket.SuperMarket.application.billing.ports.bill.in;

import com.SuperMarket.SuperMarket.domain.finance.Bill;
import com.SuperMarket.SuperMarket.domain.finance.InvoiceLineItem;

@FunctionalInterface
public interface LineItemAddition {

    Boolean lineItemAddition(String productSku, Bill bill, Integer quantity);


}
