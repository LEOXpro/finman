package ru.lbas.finman.service.impl;

import ru.lbas.finman.domain.entity.Income;

import java.util.Date;

public interface IncomeService {
    void create(Date date, Double amount, String name);
    void create(Date date, Double amount, String name, String description);
    void view();
}
