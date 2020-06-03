package ru.lbas.financemanager.domain.entity;

/**
 * Товар
 */
public class Item {
    Long id;              // id товара
    String name;          // имя товара
    String unit;          // ед. измерения (кг, штуки…)
    String description;   // описание

    public Item(Long id, String name, String unit, String description) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.description = description;
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
}
