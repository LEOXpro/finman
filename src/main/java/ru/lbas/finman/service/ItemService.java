package ru.lbas.finman.service;

import ru.lbas.finman.domain.entity.Item;

public interface ItemService {
    void createItem(Item item);
    void readFileWrite();
    void deliteItem(Long idItem);
    void viewItems();
}
