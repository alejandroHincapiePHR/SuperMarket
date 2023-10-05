package com.SuperMarket.SuperMarket.application.ports.bill.out;

import com.SuperMarket.SuperMarket.domain.finance.Bill;

@FunctionalInterface
public interface GetBillByIDPort {

    Bill getBillById(Long id);
}
