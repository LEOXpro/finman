package ru.lbas.finman.service;

import ru.lbas.finman.domain.entity.Bill;

public interface BillService {
    void createBill(Bill bill);
    void deliteBill(Long idBill);
}
