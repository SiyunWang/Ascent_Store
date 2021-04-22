package com.monica;

public class Inventory {

    //10 kinds of items
    public static Item[] itemsList;

    public static void addItem(int index,  int numberOfItem){
        itemsList[index].numOfProductAvailable += numberOfItem;
        System.out.println(numberOfItem + " " + itemsList[index].name + " was added successfully!"  );
    }

    public static void decreaseItemQuantity(int index, int numberToDecrease) {
        itemsList[index].numOfProductAvailable -= numberToDecrease;
    }

    public static void initiateItem(){
        Item item1 = new Item("pocky", 1.50);
        Item item2 = new Item("chips", 2.50);
        Item item3 = new Item("soda", 1.25);
        Item item4 = new Item("cookies", 2.00);
        Item item5 = new Item("popcorn", 3.50);
        Item item6 = new Item("candy", 2.25);
        Item item7 = new Item("water", 1.00);
        Item item8 = new Item("coffee", 3.50);
        Item item9 = new Item("nuts", 4.00);
        Item item10 = new Item("yogurt", 2.00);
        itemsList = new Item[]{item1, item2, item3, item4, item5, item6, item7, item8, item9, item10};
    }
}
