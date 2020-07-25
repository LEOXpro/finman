package ru.lbas.finman.service.impl;

import ru.lbas.finman.domain.entity.Bill;
import ru.lbas.finman.domain.entity.BillList;
import ru.lbas.finman.domain.entity.Income;
import ru.lbas.finman.service.BillListService;
import ru.lbas.finman.service.BillService;
import ru.lbas.finman.service.impl.IncomeService;

import java.util.*;

public class IncomeServiceImpl implements IncomeService {
    private Map<Long, Income> incomes = new HashMap();
    public void createIncome(Income income){
        // какой-то код
        incomes.put(income.getId(), income);
    }
    public void deliteIncome(Long idIncome){
        incomes.remove(idIncome);
    }
    public void viewIncomes(){
        for (Map.Entry<Long,Income> inc: incomes.entrySet()){
            Date date = inc.getValue().getDate();
            Long id = inc.getValue().getId();
            String name = inc.getValue().getName();
            String descr = inc.getValue().getDescription();
            Double amount = inc.getValue().getAmount();
            // здесь лучше собирать всё в одну переменную String, переходя на новую строку через \n
            // после цикла 1 раз сделать вывод на консоль
            System.out.println(date + " " + id + " " + name + " " + descr + " " + amount);
        }
    }
    public void veiwBalanceMonth(Calendar cal, BillService billService, BillListService billListService){
        Calendar calendar = new GregorianCalendar();
        BillServiceImpl billServiceImp = (BillServiceImpl) billService; // тоже переделать (метод в интерфейс)
        Map<Long, Bill> bills = new HashMap(billServiceImp.getBills());
        Double sumBuy = 0.0;
        Double sumIncome = 0.0;
        Double balance = 0.0;
        ArrayList<Long> idBill = new ArrayList();
        for (Map.Entry<Long, Bill> bills1: bills.entrySet()){ // bills1 - плохое наименование с цифрой
            Date ff = bills1.getValue().getBillDate();
            calendar.setTime(ff);
            if (cal.get(Calendar.YEAR) == calendar.get(Calendar.YEAR) && cal.get(Calendar.MONTH) == calendar.get(Calendar.MONTH)) {
                idBill.add(bills1.getKey()); // лучше не сохранять в список, а сделать метод подсчета суммы по чеку и вызывать его здесь
                // тогда цикла ниже не будет (перейдет в метод)
            }
        }
        BillListServiceImpl billListServiceImp = (BillListServiceImpl) billListService; // тоже переделать (метод в интерфейс)
        Map<Long, BillList> billLists = new HashMap(billListServiceImp.getBillLists());
        for (Map.Entry<Long, BillList> billList: billLists.entrySet()) {
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

