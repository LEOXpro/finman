package ru.lbas.finman.domain.entity;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * приход
 */
public class Income {
    Long id;              // id прихода
    Date data;            // дата
    Double amount;        // сумма
    String name;          // наименование
    String description;   // описание

    public Income(Date data, Double amount, String name, String description) {
        this.id = ThreadLocalRandom.current().nextLong(Long.MAX_VALUE);
        this.data = data;
        this.amount = amount;
        this.name = name;
        this.description = description;
    }
    public Income(Date data, Double amount, String name) {
        this.id = id;
        this.data = data;
        this.amount = amount;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public Double getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
