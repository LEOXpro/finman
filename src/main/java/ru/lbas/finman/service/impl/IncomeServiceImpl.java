package ru.lbas.finman.service.impl;

import ru.lbas.finman.domain.entity.Income;
import ru.lbas.finman.service.impl.IncomeService;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class IncomeServiceImpl implements IncomeService {
    private Income income;
    private Map<Long, Income> incomes = new HashMap();



    public void create(Date date, Double amount, String name){
        income = new Income(date, amount, name);
        incomes.put(income.getId(), income);
    }
    public void create(Date date, Double amount, String name, String description){
        income = new Income(date, amount, name, description);
        incomes.put(income.getId(), income);
    }

    public void delite(){

    }
    public void view(){
        for (Map.Entry<Long, Income> incomes: incomes.entrySet()){
            Date date = incomes.getValue().getDate();
            String name = incomes.getValue().getName();
            String descript = incomes.getValue().getDescription();
            Double amount = incomes.getValue().getAmount();
            System.out.println(date + " " + name + " " + descript + " " + amount);
        }
    }

}

