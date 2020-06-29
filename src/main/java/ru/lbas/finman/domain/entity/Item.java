package ru.lbas.finman.domain.entity;

import org.w3c.dom.ls.LSOutput;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Товар
 */
public class Item {
    Long id;              // id товара
    String name;          // имя товара
    String unit;          // ед. измерения (кг, штуки…)
    String description;   // описание
    Double price;         // цена товара

    public Item(String name, String unit, String description, Double price) {
        this.id = ThreadLocalRandom.current().nextLong(Long.MAX_VALUE);
        this.name = name;
        this.unit = unit;
        this.description = description;
        this.price = price;
    }
    public Item(String name, String unit, Double price) {
        this.id = ThreadLocalRandom.current().nextLong(Long.MAX_VALUE);
        this.name = name;
        this.unit = unit;
        this.price = price;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice(){ return price;}

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) { this.price = price; }

    @Override
    public  String toString(){
        return this.id + " " + this.name + " " + this.unit + " " + this.description + " " + this.price;
    }
}
