package ru.lbas.finman.service.impl;

import ru.lbas.finman.domain.entity.Item;
import ru.lbas.finman.service.ItemService;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ItemServiceImpl implements ItemService {
    private Map<Long, Item> items;
    // эти 4 поля, если они не используются между методами, то их по месту надо и определить, т.е. в методе использования
    File itemsFile;
    FileWriter fWriter;
    FileReader fReader;
    ArrayList<String> listLine;

    public ItemServiceImpl() throws Exception{
        this.items = new HashMap();
        this.itemsFile = new File("src/main/resources/item.csv");
        this.listLine = new ArrayList();
    }

    public void createItem(Item item) {
        try {
            fWriter = new FileWriter(itemsFile, true);
            fWriter.write(item.getId() + ";");
            fWriter.write(item.getName() + ";");
            // для if-else скобки надо расставить, а то похоже, что оно не совсем будет так работать
        if (item.getDescription() != null)
            fWriter.write(item.getDescription() + ";");
        else fWriter.write(";");
            fWriter.write(item.getUnit() + ";");
            fWriter.write(item.getPrice() + ";");
            fWriter.write("\n");
            fWriter.close();
    }
        catch (Exception e){

        }
        items.put(item.getId(), item);
    }

    public void readFileWrite() {
        try {
            fReader = new FileReader(this.itemsFile);
            BufferedReader reader = new BufferedReader(fReader);
            String line = null;
            while ((line = reader.readLine()) != null) {
                listLine.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] arrayItems = new String[listLine.size()];
        listLine.toArray(arrayItems);
        ArrayList<Integer> indexs = new ArrayList();
        indexs.add(0);
        ArrayList<Character> tovar = new ArrayList();
        Long idItem = null;
        String nameItem = null;
        String descItem = null;
        String unitItem = null;
        Double priceItem = null;
        Item item = null;

//todo сложный и непонятный метод. Надо упростить. Для разделения стринги по символу можно использовать split
        for (int i = 1; i < arrayItems.length; i++){
            char [] arrayCharItem = arrayItems[i].toCharArray();
            for (Integer j = 0; j < arrayCharItem.length; j++) {
                if (arrayCharItem[j] == 59) {
                    indexs.add(j);
                }
            }

            for (int k = 1; k < indexs.size(); k++) {
                for (int z = indexs.get(k-1); z < indexs.get(k); z++) {
                    if ((indexs.get(k-1) + 1) == indexs.get(k)){
                        tovar.add(';');
                    }
                    else tovar.add(arrayCharItem[z]);
                }
                /**
                 * здесь выцепляем из листа tovar товар, откидываем лишние ; и преобразовываем из char в int String Double
                 */
                if (k == 1){
                    String idString = "";
                    for(Character tv: tovar){
                        idString = idString + tv;
                    }
                    idItem = Long.parseLong(idString);
                }
                else if (k == 2){
                     nameItem = "";
                    for (int x = 1; x < tovar.size(); x++){
                        nameItem = nameItem + tovar.get(x);
                    }
                }
                else if (k == 3){
                     descItem = "";
                    for (int x = 1; x < tovar.size(); x++){
                        descItem = descItem + tovar.get(x);
                    }
                }
                else if (k == 4){
                        unitItem = "";
                    for (int x = 1; x < tovar.size(); x++){
                        unitItem = unitItem + tovar.get(x);
                    }
                }
                else if (k == 5){
                    String priceItemString = "";
                    for (int x = 1; x < tovar.size(); x++){
                        priceItemString = priceItemString + tovar.get(x);
                    }
                    priceItem = Double.parseDouble(priceItemString);
                }
                tovar.clear();
            }
            indexs.clear();
            indexs.add(0);
                if (descItem.length() >= 1) {
                    item = new Item(idItem, nameItem, unitItem, descItem, priceItem);
                    items.put(item.getId(), item);
                }
                else {
                    item = new Item(idItem, nameItem, unitItem, priceItem);
                    items.put(item.getId(), item);
                }
        }
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
                // здесь лучше собирать всё в одну переменную String, переходя на новую строку через \n
                // после цикла 1 раз сделать вывод на консоль
                System.out.println(id + " " + name + " " + descr + " " + unit + " " + price);
            }
        }
}
