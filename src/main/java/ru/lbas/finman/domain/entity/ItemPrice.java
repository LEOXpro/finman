package ru.lbas.finman.domain.entity;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Цена товара
 *
 * Если дата actualTill не проставлена, то цена актуальна.
 * Может быть только 1 запись для товара без установленной actualTill
 */
public class ItemPrice {
    Long id;             // id цены на товар
    Long itemId;         // ссылка на товар
    Date actualTill;     // дата действия цены
    Double price;        // стоимость единицы товара

    public ItemPrice(Long itemId, Date actualTill, Double price) {
        this.id = ThreadLocalRandom.current().nextLong(Long.MAX_VALUE);
        this.itemId = itemId;
        this.actualTill = actualTill;
        this.price = price;
    }
    public ItemPrice(Long itemId, Double price) {
        this.id = ThreadLocalRandom.current().nextLong(Long.MAX_VALUE);
        this.itemId = itemId;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public Long getItemId() {
        return itemId;
    }

    public Date getActualTill() {
        return actualTill;
    }

    public Double getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public void setActualTill(Date actualTill) {
        this.actualTill = actualTill;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
