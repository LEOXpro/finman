package ru.lbas.finman.service.impl;

import ru.lbas.finman.domain.entity.Bill;
import ru.lbas.finman.domain.entity.BillList;
import ru.lbas.finman.domain.entity.Income;
import ru.lbas.finman.service.BillListService;
import ru.lbas.finman.service.BillService;

import java.util.*;

public class BillListServiceImpl implements BillListService {
    private Map<Long, BillList> billLists = new HashMap();

    public Map<Long, BillList> getBillLists() {
        return billLists;
    }

    public void createBillList(BillList billList) {
        billLists.put(billList.getId(), billList);
    }
    public void deliteBillList(Long idBillList){
        billLists.remove(idBillList);
    }

    public void veiwInfoBillListDay1(Calendar cal, BillService billService) {
        BillServiceImpl billService1 = (BillServiceImpl)billService;
        Map<Long, Bill> bills = new HashMap(billService1.getBills());
        Calendar calendar = new GregorianCalendar();
        for (Map.Entry<Long, Bill> bills1: bills.entrySet()){
            Date ff = bills1.getValue().getBillDate();
            calendar.setTime(ff);
            if (cal.get(Calendar.YEAR) == calendar.get(Calendar.YEAR) && cal.get(Calendar.MONTH) == calendar.get(Calendar.MONTH) &&
                    cal.get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH)) {
                System.out.println("Счет №: " + bills1.getKey() + " от " + bills1.getValue().toString());
                for (Map.Entry<Long, BillList> billList: this.billLists.entrySet()){
                    if (billList.getValue().getBillId() == bills1.getValue().getId()){
                        System.out.println(billList.getValue().toString());
                    }
                }
            }
            else System.out.println("В этот день не было покупок");
        }
    }

    public void veiwInfoBillListDay2(Calendar cal, BillService billService) {
        BillServiceImpl billService2 = (BillServiceImpl) billService;
        Map<Long, Bill> bills = new HashMap(billService2.getBills());
        Calendar calendar = new GregorianCalendar();
        for (Map.Entry<Long, Bill> bills2: bills.entrySet()){
            Date ff = bills2.getValue().getBillDate();
            calendar.setTime(ff);
            if (cal.get(Calendar.YEAR) == calendar.get(Calendar.YEAR) && cal.get(Calendar.MONTH) == calendar.get(Calendar.MONTH)) {
                System.out.println("Счет №: " + bills2.getKey() + " от " + bills2.getValue().toString());
                for (Map.Entry<Long, BillList> billList: this.billLists.entrySet()){
                    if (billList.getValue().getBillId() == bills2.getValue().getId()){
                        System.out.println(billList.getValue().toString());
                    }
                }
            }
            else System.out.println("В этот день не было покупок");
        }
    }
}

