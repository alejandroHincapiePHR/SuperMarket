package com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.adapter;

import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.bill.BillMySQLEntity;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.bill.interfaces.BillMapper;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.repository.bill.BillMySQLRepository;
import com.SuperMarket.SuperMarket.application.ports.bill.out.BillCreatedPort;
import com.SuperMarket.SuperMarket.application.ports.bill.out.GetBillByIDPort;
import com.SuperMarket.SuperMarket.domain.finance.Bill;


import java.util.Optional;


public class BillMySQLAdapter implements BillCreatedPort, GetBillByIDPort {

    private BillMapper billMapper;
    private BillMySQLRepository billMySQLRepository;


    public BillMySQLAdapter(final BillMapper billMapper, final BillMySQLRepository billMySQLRepository) {
        this.billMapper = billMapper;
        this.billMySQLRepository = billMySQLRepository;
    }

    @Override
    public Long saveBill(Bill bill) {
        //TODO add logic to check id Bill is added
        BillMySQLEntity billMySQLEntity = billMySQLRepository.save(billMapper.toEntity(bill));
        return billMySQLEntity.getBillId();

    }

    @Override
    public Bill getBillById(Long id) {
        Optional<BillMySQLEntity> billMySQL = billMySQLRepository.findById(id);
        if (billMySQL.isPresent()) {
            return billMapper.toDomain(billMySQL.get());
        } else {
            return null;
        }
    }
}
