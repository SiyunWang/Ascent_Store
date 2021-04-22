package com.monica;

public class Main {
    /*
     * create a new java app

     * create a store that sells items
     * there should be a class that handles inventory,
     *      Inventory should be stored in an array (you can use other collection types if you have more than one, but include at least one array)
     * a class that handles items
     *        Items (and others, maybe) should be built using a constructor, not hard coded
     * a class that handles sales (at a minimum)

     *

     *
     * */
    public static void main(String[] args) {
        Store ourStore = new Store();
        ourStore.welcome();
        ourStore.display();
        ourStore.shoppingCart();
    }
}