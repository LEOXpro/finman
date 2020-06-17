package ru.lbas.finman.domain.entity;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Содержание Счета
 */
public class BillList {
    Long id;                // id содержаня счета
    Long billId;            // ссылка на счет
    Long itemId;            // ссылка на товар
    Integer quantity;       // кол-во
    Double purchaseAmount;  // сумма покупки

    public BillList(Long billId, Long itemId, Integer quantity, Double purchaseAmount) {
        this.id = ThreadLocalRandom.current().nextLong(Long.MAX_VALUE);
        this.billId = billId;
        this.itemId = itemId;
        this.quantity = quantity;
        this.purchaseAmount = purchaseAmount;
    }
    public BillList(Long billId, Long itemId, Integer quantity) {
        this.id = ThreadLocalRandom.current().nextLong(Long.MAX_VALUE);
        this.billId = billId;
        this.itemId = itemId;
        this.quantity = quantity;
    }
    public BillList(Long billId, Long itemId, Double purchaseAmount) {
        this.id = ThreadLocalRandom.current().nextLong(Long.MAX_VALUE);
        this.billId = billId;
        this.itemId = itemId;
        this.purchaseAmount = purchaseAmount;
    }

    public Long getId() {
        return id;
    }

    public Long getBillId() {
        return billId;
    }

    public Long getItemId() {
        return itemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPurchaseAmount(Double purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }
}
