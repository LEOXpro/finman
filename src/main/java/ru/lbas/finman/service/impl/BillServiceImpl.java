package ru.lbas.finman.service.impl;

import ru.lbas.finman.domain.entity.Bill;
import ru.lbas.finman.domain.entity.BillList;
import ru.lbas.finman.domain.entity.Income;
import ru.lbas.finman.domain.entity.Item;
import ru.lbas.finman.service.BillService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BillServiceImpl implements BillService {
    private Map<Long, Bill> bills = new HashMap();

    public Map<Long, Bill> getBills() {
        return bills;
    }

    public void createBill(Bill bill){
        bills.put(bill.getId(), bill);
    }
    public void deliteBill(Long idBill){
        bills.remove(idBill);
    }
}
