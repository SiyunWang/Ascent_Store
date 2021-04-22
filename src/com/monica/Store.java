package com.monica;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Store {

    public double currentBalance = 0;       //calculate what customer selected (revenue)
    public double storeFunding = 100;       //what the store starts off with
    public Scanner scanner = new Scanner(System.in);

    public Inventory ourInventory = new Inventory();


    public void welcome() {
        System.out.println("Welcome to our store!");
        ourInventory.initiateItem();

        for (int i = 0; i < ourInventory.itemsList.length; i++) {
            ourInventory.addItem(i, 100);
        }
    }

    public void display() {
        System.out.println("the items available are: ");
        for (int i = 0; i < ourInventory.itemsList.length; i++) {
            System.out.println(i + ". " + ourInventory.itemsList[i].name + " price: $" + ourInventory.itemsList[i].price);
        }
    }

    public void checkout(){
        System.out.println("Your final cost is $" + currentBalance + ".");
        System.out.println("Please enter the amount you are paying.");
        double amountPaid = scanner.nextDouble();
        if (amountPaid < currentBalance) {
            System.out.println("Purchase failed. Not enough money.");
            checkout();
        } else {
            System.out.println("Thank you for shopping with us! :)");
            storeFunding += currentBalance;
            System.out.println("Here is your change: $" + (amountPaid - currentBalance));
            currentBalance = 0;
        }


    }

    public void shoppingCart() {
        boolean isShopping = true;
//        int[] pendingItems = new int[ourInventory.itemsList.length];

        int quantity = 0;
        int itemIndex= Integer.MAX_VALUE;

        while (isShopping) {
            boolean indexIsInteger = false;
            boolean indexInBound = false;
            while (!indexIsInteger && itemIndex >= ourInventory.itemsList.length){
                try {
                    System.out.println("Enter the item number you desired:");
                    itemIndex = scanner.nextInt();
                    String itemExists = ourInventory.itemsList[itemIndex].name;
                    scanner.nextLine();
                    indexIsInteger = true;
                } catch (InputMismatchException ime){
                    System.out.println("Invalid character found, please enter numeric values between 0-9 only!");
                    scanner.nextLine();
                } catch(ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid item number, please enter numeric values between 0-9 only!");
                    scanner.nextLine();
                }
            }

            boolean quantityIsInteger = false;
            while (!quantityIsInteger){
                try {
                    System.out.println("How many " +  ourInventory.itemsList[itemIndex].name  + " would you like?");
                    quantity = scanner.nextInt();
                    scanner.nextLine();

                    //check quantity
                    if (quantity > ourInventory.itemsList[itemIndex].numOfProductAvailable) {
                        System.out.println("We only have " + ourInventory.itemsList[itemIndex].numOfProductAvailable + " left of " + ourInventory.itemsList[itemIndex].name + " in the inventory.");
                        quantity = ourInventory.itemsList[itemIndex].numOfProductAvailable;
                    }
                    // update the currentBalance
                    currentBalance += ourInventory.itemsList[itemIndex].price * quantity;
                    ourInventory.decreaseItemQuantity(itemIndex, quantity);

                    quantityIsInteger = true;
                } catch (InputMismatchException ime){
                    System.out.println("Invalid character found, please enter a numeric value!");
                    scanner.nextLine();
                }
            }

            System.out.println("Current total is: $" + currentBalance);
            System.out.println("Type c to checkout or any other key to continue shopping ");
            String isContinue = scanner.nextLine();
            if (isContinue.equals("c")) {
                isShopping = false;
                checkout();
                scanner.close();
            }
        }
    }
}
