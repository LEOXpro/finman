package ru.lbas.finman.domain.entity;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
* Cчет
 */
public class Bill {
    Long id;          // id счета
    Date billDate;    // дата счета

    public Bill(Long id, Date billDate) {
        this.id = id;
        this.billDate = billDate;
    }
    public Bill(Date billDate) {
        this.id = ThreadLocalRandom.current().nextLong(Long.MAX_VALUE);
        this.billDate = billDate;
    }

    public Long getId() {
        return id;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    @Override
    public  String toString(){
        return " " + this.billDate;
    }
}
