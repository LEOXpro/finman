package ru.lbas.finman.service.impl;

import ru.lbas.finman.domain.entity.Item;
import ru.lbas.finman.service.ItemService;

import java.util.HashMap;
import java.util.Map;

public class ItemServiceImpl implements ItemService {
    private Map<Long, Item> items = new HashMap();

       public void createItem(Item item){
            items.put(item.getId(), item);
        }
       public void deliteItem(Long idItem){
            items.remove(idItem);
        }
       public void viewItems(){
            for (Map.Entry<Long, Item> it: items.entrySet()){
               Long id = it.getValue().getId();
               String name = it.getValue().getName();
               String descr = it.getValue().getDescription();
               String unit = it.getValue().getUnit();
               Double price = it.getValue().getPrice();
                System.out.println(id + " " + name + " " + descr + " " + unit + " " + price);
            }
        }
}
