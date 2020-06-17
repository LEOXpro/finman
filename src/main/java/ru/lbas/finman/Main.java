package ru.lbas.finman;

import ru.lbas.finman.domain.entity.Item;
import ru.lbas.finman.service.impl.BillServiceImpl;
import ru.lbas.finman.ui.ConsoleManager;


import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BillServiceImpl billService = new BillServiceImpl();
        ConsoleManager consoleManager = new ConsoleManager();
        consoleManager.start();

        /**
         * заготовка для сохранения в файл
         */
        Item chips = new Item(id, "Чипсы", "шт.");
        File items = new File("src/main/resources/item.csv");
        PrintWriter tt = new PrintWriter(items);
        tt.print(chips.getId() + ";");
        tt.print(chips.getName() + ";");
        tt.print(chips.getUnit() + ";");
        if (chips.getDescription() != null)
        tt.print(chips.getDescription());

        tt.close();

    }
}
