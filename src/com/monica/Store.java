package com.monica;

import java.util.Arrays;
import java.util.Scanner;

public class Store {

    public double currentBalance = 0;       //calculate what customer selected (revenue)
    public double storeFunding = 100;       //what the store starts off with
    public Scanner scanner = new Scanner(System.in);

    public Inventory ourInventory = new Inventory();


    public void welcome() {
        System.out.println("Welcome to our store!");
        ourInventory.initiateItem();
    }

    public void display() {
        System.out.println("the items available are: ");
        for (int i = 0; i < ourInventory.itemsList.length; i++) {
            System.out.println(i + ". " + ourInventory.itemsList[i].name + " price: $" + ourInventory.itemsList[i].price);
        }
    }


    public void shoppingCart() {
        boolean isShopping = true;
//        int[] pendingItems = new int[ourInventory.itemsList.length];
        while (isShopping) {
            System.out.println("Enter the item number you desired:");
            int itemIndex = scanner.nextInt();
            System.out.println("How many " + ourInventory.itemsList[itemIndex].name + " would you like?");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            // update the currentBalance
            currentBalance += ourInventory.itemsList[itemIndex].price * quantity;
            ourInventory.decreaseItemQuantity(itemIndex, quantity);
            System.out.println("Current total is: $" + currentBalance);
            System.out.println("Would you like to continue? y/n ");
            String isContinue = scanner.nextLine();
            if (isContinue.equals("n")) {
                isShopping = false;
            }
        }
    }
}
