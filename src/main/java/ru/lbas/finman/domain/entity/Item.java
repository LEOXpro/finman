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

    public Item(String name, String unit, String description) {
        this.id = ThreadLocalRandom.current().nextLong(Long.MAX_VALUE);
        this.name = name;
        this.unit = unit;
        this.description = description;
    }
    public Item(String name, String unit) {
        this.id = ThreadLocalRandom.current().nextLong(Long.MAX_VALUE);
        this.name = name;
        this.unit = unit;
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

    @Override
    public  String toString(){
        return this.id + " " + this.name + " " + this.unit + " " + this.description;
    }
}
