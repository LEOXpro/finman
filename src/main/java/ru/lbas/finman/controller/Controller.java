package ru.lbas.finman.controller;

import ru.lbas.finman.domain.entity.Bill;
import ru.lbas.finman.domain.entity.BillList;
import ru.lbas.finman.domain.entity.Income;
import ru.lbas.finman.domain.entity.Item;

import java.util.*;

public class Controller {
    private Calendar calendar;
    private Map<Long, Bill> bills;
    private Map<Long, BillList> billLists;
    private Map<Long, Item> items;
    private Map<Long, Income> incomes;

    public Controller(){
        this.bills = new HashMap();
        this.billLists = new HashMap();
        this.incomes = new HashMap();
        this.items = new HashMap();
        this.calendar = new GregorianCalendar();
    }

    public void viewItems() throws Exception{
        for (Map.Entry<Long, Item> entry: items.entrySet()){
            System.out.println(entry.getKey() + entry.getValue().toString());
        }
    }

    public void createBill(Long id, Bill bill){
        this.bills.put(id, bill);
    }
    public void deliteBill(Long id){
        this.bills.remove(id);
    }
    public void createBillList(Long id, BillList billList){
        this.billLists.put(id, billList);
    }
    public void deliteBillList(Long idBillList){
        this.billLists.remove(idBillList);
    }
    public void addItem(Long id, Item item){
        this.items.put(id, item);
    }
    public void addIncome(Long id, Income income){
        this.incomes.put(id, income);
    }
    public void deliteIncome(Long id){
        this.incomes.remove(id);
    }
    public void veiwInfoBillLists(Calendar cal) {
        for (Map.Entry<Long, Bill> bills: bills.entrySet()){
            Date ff = bills.getValue().getBillDate();
            calendar.setTime(ff);
            if (cal.get(Calendar.YEAR) == calendar.get(Calendar.YEAR) && cal.get(Calendar.MONTH) == calendar.get(Calendar.MONTH) && cal.get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH)) {
                System.out.println("Счет №: " + bills.getKey() + " от " + bills.getValue().toString());
                for (Map.Entry<Long, BillList> billList: this.billLists.entrySet()){
                    if (billList.getValue().getBillId() == bills.getValue().getId()){
                        System.out.println(billList.getValue().toString());
                    }
                //    System.out.println(billList.getKey() + billList.getValue().toString());
                }
            }
             else System.out.println("В этот день не было покупок");
        }
    }
}
