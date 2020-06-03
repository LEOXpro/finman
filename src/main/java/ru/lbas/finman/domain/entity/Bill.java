package ru.lbas.financemanager.domain.entity;

import java.util.Date;
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
}
