package ru.lbas.finman.service.impl;

import ru.lbas.finman.domain.entity.Income;
import ru.lbas.finman.service.BillListService;
import ru.lbas.finman.service.BillService;

import java.util.Calendar;
import java.util.Date;

public interface IncomeService {
    void createIncome(Income income);
    void deliteIncome(Long idIncome);
    void viewIncomes();
    void veiwBalanceMonth(Calendar cal, BillService billService, BillListService billListService);
}
