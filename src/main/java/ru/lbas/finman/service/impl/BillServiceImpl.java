package ru.lbas.finman.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import ru.lbas.finman.domain.entity.*;
import ru.lbas.finman.service.BillService;

public class BillServiceImpl implements BillService {
    private Map<Long, Bill> bills = new HashMap();
    private Map<Long, Item> items = new HashMap();
    private Bill bill;
    private BillList billList;
    private Item item;
    private ItemPrice itemPrice;
    private Income  income;

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public BillList getBillList() {
        return billList;
    }

    public void setBillList(BillList billList) {
        this.billList = billList;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public ItemPrice getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(ItemPrice itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Income getIncome() {
        return income;
    }

    public void setIncome(Income income) {
        this.income = income;
    }

    @Override
    public void createBill(Date date) {
        bill = new Bill(date);     // 1 создали счет
        bills.put(bill.getId(), bill);  // 2 полочили счет в мапу ключ - уникальный id счета, значение - сам счет
    }

    @Override
    public void deleteBill(Long id) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите id товара");
        Long id = Long.parseLong(reader.readLine());
        bills.remove(id);
    }
    public void createBillList(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите наименование товара");
        String name = reader.readLine();
        item = createItem();
            BillList billList = new BillList(idBill, item.getId(),  );

        }

    public Item createItem(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите наименование товара");
        String nameItem = reader.readLine();
        System.out.println("Выберите ед. измерения: 1 - кг, 2 - штуки");
        int ed = 0;
        try {
            while (true) {
                ed = Integer.parseInt(reader.readLine());
                if (ed == 1 && ed == 2)
                    break;
                else
                    System.out.println("Неверно, введите '1' (кг.) или '2' (шт.)");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        String unit;
        if (ed == 1)
            unit = "кг.";
        else
            unit = "шт."

        System.out.println("Хотите ввести описание товара? (1 - Да; 2 - Нет)");
        String descript = null;
        int des = 0;
        try {
            while (true) {
                des = Integer.parseInt(reader.readLine());
                if (des == 2)
                    break;
                else if (des == 1) {
                    descript = reader.readLine();
                    break;
                }
                else
                    System.out.println("Неверно, введите '1' (Да) или '2' (Нет)");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        if (des == 2)
            item = new Item(nameItem, unit);
        else if (des == 1)
            item = new Item(nameItem, unit, descript);

        items.put(item.getId(), item);

        createItemPrise();
        return item;

    }
    public void deleteItem(){

    }
    public void createItemPrise(Long idItem){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите стоимость товара");
        Double rt = Double.parseDouble(reader.readLine());
        BillList billList = new BillList(idBill, item.getId(),  );

    }
}
