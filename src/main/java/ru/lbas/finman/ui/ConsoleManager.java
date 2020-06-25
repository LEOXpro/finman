package ru.lbas.finman.ui;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import ru.lbas.finman.controller.Controller;
import ru.lbas.finman.domain.entity.*;

public class ConsoleManager {
    private Scanner ln;
    private Controller controller;
    private Bill bill;
    private BillList billList;
    private Item item;
    private ItemPrice itemPrice;
    private Income income;
    private Map<Long, Bill> bills = new HashMap();
    private Map<Long, BillList> billLists = new HashMap();
    public static Integer des = 0;

    public ConsoleManager(){
        this.ln = new Scanner(System.in);
        this.controller = new Controller();
    }


    public  int menu() {
        System.out.println("1 - Показать список товаров");
        System.out.println("2 - Создать чек");
        System.out.println("3 - Удалить чек");
        System.out.println("4 - Добавить товар в чек");
        System.out.println("5 - Удалить товар из чека");
        System.out.println("6 - Добавить приход");
        System.out.println("7 - Удалить приход");
        System.out.println("8 - Показать список товаров за дату");
        System.out.println("9 - Показать список товаров за месяц");
        System.out.println("10 - Показать баланс за месяц");
        System.out.println("0 - Выход");
        int choice = readInt(0, 10);
        return choice;
    }

        public void start() {
            while (true) {
                try {
                    Integer choice = menu();
                    switch (choice) {
                        case 0:
                            System.exit(0);
                            break;
                        case 1:
                            viewItems();
                            break;
                        case 2:
                            createBill();
                            break;
                        case 3:
                            deliteBill();
                            break;
                        case 4:
                            addItemBillList();
                            break;
                        case 5:
                            deliteBillList();
                            break;
                        case 6:
                            addIncome();
                            break;
                        case 7:
                            deliteIncome();
                            break;
                        case 8:
                            veiwInfoItemsDate();
                            break;
                        case 9:
                            veiwInfoItemsMonth();
                            break;
                        case 10:
                            viewBalanceMonth();
                            break;
                        default:
                            throw new AssertionError();
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        private  int readInt(int min, int max){
            int choice;
                while (true) {
                    try {
                        choice = Integer.parseInt(ln.nextLine());
                        if (choice >= min && choice <= max)
                            break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return choice;
            }

    /**
     * Метод отображения списка товаров из справочника (Item)
     */
    private void viewItems() throws Exception{
        this.controller.viewItems();
            }  // сделать позже
    private void createBill() throws Exception {
        bill = new Bill(new Date());
        this.controller.createBill(bill.getId(), bill);
        createBillList(bill.getId());
    }
    private void deliteBill() throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите id счета, который хотите удалить");
        Long idBill = Long.parseLong(reader.readLine());
        this.controller.deliteBill(idBill);
    }           // удаление чека

    private void createBillList(Long id) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            item = createItem();
            System.out.println("Введите кол-во ед. товара, если оно известно или введите - 0, если неизвестно");
            des = Integer.parseInt(reader.readLine());
            if (des == 0) {
                billList = new BillList(id, item.getId(), itemPrice.getPrice());
            } else {
                Double resultPrice = des * itemPrice.getPrice();
                billList = new BillList(id, item.getId(), resultPrice);
            }
            this.controller.createBillList(billList.getId(), billList);
            System.out.println("Добавить еще товар? 1 - Да; 2 - Нет");
            int x = Integer.parseInt(reader.readLine());
            if (x == 2)
                break;
        }
    }
    public void deliteBillList() throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите id позиции в чеке, которую хотите удалить");
        Long idBillList = Long.parseLong(reader.readLine());
        this.controller.deliteBillList(idBillList);
    }
    private void addItemBillList() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите id счета, в который нужно добавить товар");
        Long id = Long.parseLong(reader.readLine());
        createBillList(id);
    }

    private Item createItem() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите наименование товара");
        String nameItem = reader.readLine();
        System.out.println("Выберите ед. измерения: 1 - кг, 2 - штуки");
        int ed = 0;
        try {
            while (true) {
                ed = Integer.parseInt(reader.readLine());
                if (ed == 1 || ed == 2)
                    break;
                else
                    System.out.println("Неверно, введите '1' (кг.) или '2' (шт.)");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        String edIzm;
        if (ed == 1)
            edIzm = "кг.";
        else
            edIzm = "шт.";

        System.out.println("Хотите ввести описание товара? (1 - Да; 2 - Нет)");
        String descript = "";
        try {
            while (true) {
                des = Integer.parseInt(reader.readLine());
                if (des == 2)
                    break;
                else if (des == 1) {
                    System.out.println("Введите описание товара");
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
             item = new Item(nameItem, edIzm);
        else if (des == 1)
             item = new Item(nameItem, edIzm, descript);
        this.controller.addItem(item.getId(), item);
        createItemPrise();

        return item;
    }
    public ItemPrice createItemPrise() throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите стоимость единицы товара");
        Double price = Double.parseDouble(reader.readLine());

        System.out.println("Хотите выбрать дату действия цены на товара? (1 - Да; 2 - Нет)");
        String descript = null;
        Date date = null;
        des = 0;
        try {
            while (true) {
                des = Integer.parseInt(reader.readLine());
                if (des == 2)
                    break;
                else if (des == 1) {
                    date = new Date();
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
            itemPrice = new ItemPrice(item.getId(), price);
        else if (des == 1)
            itemPrice = new ItemPrice(item.getId(), date, price);

        return itemPrice;
    }
    public void addIncome() throws Exception{
        System.out.println("Введите наименование прихода");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        System.out.println("Введите сумму прихода");
        Double amount = Double.parseDouble(reader.readLine());

        System.out.println("Хотите добавить описание прихода? (1 - Да; 2 - Нет)");
        String descript = null;
        des = 0;
        try {
            while (true) {
                des = Integer.parseInt(reader.readLine());
                if (des == 2)
                    break;
                else if (des == 1) {
                    System.out.println("Введите описание товара");
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
            income = new Income(new Date(), amount, name);
        else if (des == 1)
            income = new Income(new Date(), amount, name, descript);
        this.controller.addIncome(income.getId(), income);
    }
    public void deliteIncome() throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите id прихода, который хотите удалить");
        Long idIncome = Long.parseLong(reader.readLine());
        this.controller.deliteIncome(idIncome);
    }
    public void veiwInfoItemsDate() throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите дату, за которую хотите посмотреть покупки");
        System.out.println("Введите год");
        int year = Integer.parseInt(reader.readLine());
        System.out.println("Введите месяц. 1 - январь и т.д.");
        int month = Integer.parseInt(reader.readLine());
        System.out.println("Введите число месяца.");
        int day = Integer.parseInt(reader.readLine());
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month-1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        this.controller.veiwInfoBillLists(calendar);
    }
    public void veiwInfoItemsMonth(){

    }
    public void viewBalanceMonth(){

    }
}
