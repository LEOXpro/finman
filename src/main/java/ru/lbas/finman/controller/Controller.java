package ru.lbas.finman.controller;

import ru.lbas.finman.domain.entity.Bill;
import ru.lbas.finman.domain.entity.BillList;
import ru.lbas.finman.domain.entity.Income;
import ru.lbas.finman.domain.entity.Item;

import java.io.*;
import java.util.*;

public class Controller {
    private Calendar calendar;
    File itemsFile;
    FileWriter fWriter;
    FileReader fReader;
    ArrayList<String> listLine;
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
        this.itemsFile = new File("src/main/resources/item.csv");  ////1
        this.listLine = new ArrayList();
                    }
        public void viewItems() throws Exception{
        for (Map.Entry<Long, Item> entry: items.entrySet()){
            System.out.println(entry.getKey() + entry.getValue().toString());
        }
    }

    /**
     *
     * ЗАГАТОВКА для чтения из файла. Метод считывания с файла и запись в список
     */
    public void readFileWrite() throws Exception{
        fReader = new FileReader(this.itemsFile);
        BufferedReader reader = new BufferedReader(fReader);
        String line = null;
        while ((line = reader.readLine()) != null) {
            listLine.add(line);
        }
        System.out.println(listLine.toString());
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
    public void addItem(Long id, Item item) throws Exception{
        this.items.put(id, item);
        fWriter = new FileWriter(itemsFile, true);
        fWriter.write(item.getId() + ";");
        fWriter.write(item.getName() + ";");
        if (item.getDescription() != null)
            fWriter.write(item.getDescription() + ";");
        else fWriter.write(";");
        fWriter.write(item.getUnit() + ";");
        fWriter.write(item.getPrice() + ";");
        fWriter.write("\n");
        fWriter.close();
    }


    public void addIncome(Long id, Income income){
        this.incomes.put(id, income);
    }
    public void deliteIncome(Long id){
        this.incomes.remove(id);
    }
    public void veiwInfoBillLists1(Calendar cal) {
        for (Map.Entry<Long, Bill> bills: bills.entrySet()){
            Date ff = bills.getValue().getBillDate();
            calendar.setTime(ff);
            if (cal.get(Calendar.YEAR) == calendar.get(Calendar.YEAR) && cal.get(Calendar.MONTH) == calendar.get(Calendar.MONTH) &&
                    cal.get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH)) {
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
    public void veiwInfoBillLists2(Calendar cal) {
        for (Map.Entry<Long, Bill> bills: bills.entrySet()){
            Date ff = bills.getValue().getBillDate();
            calendar.setTime(ff);
            if (cal.get(Calendar.YEAR) == calendar.get(Calendar.YEAR) && cal.get(Calendar.MONTH) == calendar.get(Calendar.MONTH)) {
                System.out.println("Счет №: " + bills.getKey() + " от " + bills.getValue().toString());
                for (Map.Entry<Long, BillList> billList: this.billLists.entrySet()){
                    if (billList.getValue().getBillId() == bills.getValue().getId()){
                        System.out.println(billList.getValue().toString());
                    }
                }
            }
            else System.out.println("В этот день не было покупок");
        }
    }
    public void veiwBalanceMonth(Calendar cal){
        Double sumBuy = 0.0;
        Double sumIncome = 0.0;
        Double balance = 0.0;
        ArrayList<Long> idBill = new ArrayList();
        for (Map.Entry<Long, Bill> bills: bills.entrySet()){
            Date ff = bills.getValue().getBillDate();
            calendar.setTime(ff);
            if (cal.get(Calendar.YEAR) == calendar.get(Calendar.YEAR) && cal.get(Calendar.MONTH) == calendar.get(Calendar.MONTH)) {
               idBill.add(bills.getKey());
            }
        }
        for (Map.Entry<Long, BillList> billList: this.billLists.entrySet()) {
            for (int i = 0; i < idBill.size(); i++) {
                if (billList.getValue().getBillId() == idBill.get(i))
                sumBuy = sumBuy + billList.getValue().getPrice();
            }
        }

        for (Map.Entry<Long, Income> incomes: incomes.entrySet()){
            Date ff = incomes.getValue().getDate();
            calendar.setTime(ff);
            if (cal.get(Calendar.YEAR) == calendar.get(Calendar.YEAR) && cal.get(Calendar.MONTH) == calendar.get(Calendar.MONTH)) {
                    sumIncome = sumIncome + incomes.getValue().getAmount();
            }
        }
        balance = sumIncome - sumBuy;
        System.out.println("Баланс за текущий месяц: " + balance);
    }
}
