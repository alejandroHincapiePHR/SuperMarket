package com.SuperMarket.SuperMarket.application.billing.ports.bill.in;

import com.SuperMarket.SuperMarket.domain.finance.Bill;

@FunctionalInterface
public interface BillConfirmation {
    Bill billConfirmation(Bill bill);

}
