package com.SuperMarket.SuperMarket.application.billing.ports.bill.out;
import com.SuperMarket.SuperMarket.domain.finance.Bill;

@FunctionalInterface
public interface BillCreatedPort {

    Boolean saveBill(Bill bill);
}
