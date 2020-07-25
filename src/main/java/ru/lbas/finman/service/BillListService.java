package ru.lbas.finman.service;

import ru.lbas.finman.domain.entity.BillList;

import java.util.Calendar;

public interface BillListService {
    void createBillList(BillList billList);
    void deliteBillList(Long idBillList);
    void veiwInfoBillListDay1(Calendar cal, BillService billService);
    void veiwInfoBillListDay2(Calendar cal, BillService billService);
}
