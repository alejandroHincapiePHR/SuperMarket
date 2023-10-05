package com.SuperMarket.SuperMarket.application.ports.bill.in;

import com.SuperMarket.SuperMarket.domain.finance.Bill;

@FunctionalInterface
public interface GetBillByIDUseCase {

    Bill getbillByIdUseCase(Long id);
}
