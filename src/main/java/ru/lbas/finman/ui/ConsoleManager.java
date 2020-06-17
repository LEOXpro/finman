package ru.lbas.finman.ui;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Scanner;

import ru.lbas.finman.service.impl.BillServiceImpl;

public class ConsoleManager implements Methods {
    private Scanner ln;
    private BillServiceImpl service;


    public ConsoleManager(){
        this.ln = new Scanner(System.in);
        service = new BillServiceImpl();
    }


    public static int menu() {
        System.out.println("1 - Показать список товаров");
        System.out.println("2 - Создать чек");
        System.out.println("3 - Удалить чек");
        System.out.println("4 - Добавить товар в чек");
        System.out.println("5 - Удалить товар из чека");
        System.out.println("6 - Добавить доход");
        System.out.println("7 - Удалить доход");
        System.out.println("8 - Показать список товаров за дату");
        System.out.println("9 - Показать списко товаров за месяц");
        System.out.println("10 - Показать баланс за месяц");
        System.out.println("0 - Выход");
        int choice = readInt(0, 10);
        return choice;
    }

        public void start() {
            while (true) {
                try {
                    int choice = menu();
                    switch (choice) {
                        case 0:
                            System.exit();
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
                            createBillList();
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
                            veiwInfoItemsDate()
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
                }
            }
        }

        private static int readInt(int min, int max){
            Integer choice;
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
    private void viewItems(){
                System.out.println("");
            }  // сделать позже
    private void createBill(){
        service.createBill(new Date());
        createBillList(service.getBill().getId());
    }
    private void deliteBill(){ service.deleteBill(); }           // удаление чека

    private void createBillList(Long id) {
        service.createBillList();
    }


    private Item createItem() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите наименование товара");
        String nameBill = reader.readLine();
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
        String edIzm;
        if (ed == 1)
            edIzm = "кг.";
        else
            edIzm = "шт."

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
             item = new Item(idItem, nameBill, edIzm)
        else if (des == 1)
             item = new Item(idItem, nameBill, edIzm, descript);

        createItemPrise();
        return item;
    }
    private void createItemPrise(){
        Id id = new Id();
        Long idItemPrise = id.getId();

    }
}
