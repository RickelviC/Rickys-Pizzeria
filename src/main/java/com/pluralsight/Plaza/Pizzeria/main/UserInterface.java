package com.pluralsight.Plaza.Pizzeria.main;


import com.pluralsight.Plaza.Pizzeria.products.Drink;
import com.pluralsight.Plaza.Pizzeria.products.GarlicKnots;
import com.pluralsight.Plaza.Pizzeria.products.Pizza;
import com.pluralsight.Plaza.Pizzeria.toppings.Cheese;
import com.pluralsight.Plaza.Pizzeria.toppings.Meat;
import com.pluralsight.Plaza.Pizzeria.toppings.Topping;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class UserInterface {

    private Scanner scanner;
    private Order order;
    private int size;
    String crust;
    boolean stuffed;
    List<Topping> allTops = new ArrayList<>();

    public UserInterface() {
        //UUID is a 36-character string made up of 5 groups of hexadecimal digits separated by hyphens
        //example 123e4567-e89b-12d3-a456-426614174000
        UUID Id = UUID.randomUUID();
        scanner = new Scanner(System.in);
        order = new Order(Id);
    }

    public void display() {

        boolean quit = false;
        while (!quit) {
            System.out.println("---------- Menu ----------");
            System.out.println("1) make your pizza");
            System.out.println("2) get your drink");
            System.out.println("3) get Garlic Knot");
            System.out.println("4) check out");
            System.out.println("5) cancel order");
            System.out.println("0) Quit");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    pizzaMenu();
                    break;
                case "2":
                    makeDrink();
                    break;
                case "3":
                    makeGarlicKnot();
                    break;
                case "4":
                    checkOut();
                    break;
                case "0":
                    cancelOrder();
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void pizzaMenu() {
        boolean quit = false;
        while (!quit) {
            System.out.println("---------- Pizza Menu ----------");
            System.out.println("1) size of pizza");
            System.out.println("2) type of crust");
            System.out.println("3) stuffed crust");
            System.out.println("4) Topping");
            System.out.println("0) go back");


            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    size = pizzaSize();
                    break;
                case "2":
                    crust = crustType();
                    break;
                case "3":
                    stuffed = stuffed();
                    break;
                case "4":
                    pizzaToppingMenu();
                    break;
                case "0":
                    finishPizza();
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void pizzaToppingMenu() {
        boolean quit = false;
        while (!quit) {
            System.out.println("---------- Topping Menu ----------");
            System.out.println("1) meat options");
            System.out.println("2) cheese options");
            System.out.println("3) regular toppings");
            System.out.println("4) sauce topping");
            System.out.println("5) side topping");
            System.out.println("0) go back");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    meatTopping();
                    break;
                case "2":
                    cheeseTopping();
                    break;
                case "3":
                    regularTopping();
                    break;
                case "4":
                    sauceTopping();
                    break;
                case "5":
                    sideTopping();
                    break;
                case "0":
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /*
      making all the items that are the same in to one on display
      example drink small 4
        HashSet<Product> uniqueProduct = new HashSet<>(cart);

        for (Product product : uniqueProduct) {
            System.out.println(product + " " + Collections.frequency(cart, product));
        }
     */
    public boolean stuffed() {
        System.out.println("do you want your crust stuffed? (Yes/No)");
        String type = scanner.nextLine();
        return type.equalsIgnoreCase("yes");
    }

    public String crustType() {
        //- thin - regular - thick - cauliflower
        System.out.println("what type of crust would you like");
        System.out.println();
        System.out.println("1) thin");
        System.out.println("2) regular");
        System.out.println("3) thick");
        System.out.println("4) cauliflower");
        System.out.println();

        int type = scanner.nextInt();
        if (type == 1) {
            return "thin";
        } else if (type == 2) {
            return "regular";
        } else if (type == 3) {
            return "thick";
        } else {
            return "cauliflower";
        }
    }

    public int pizzaSize() {

        System.out.println("8) Small $8.50");
        System.out.println("12) Medium $12.0");
        System.out.println("16) Large $16.50");

        int size = scanner.nextInt();
        scanner.nextLine();

        return size;
    }

    public void meatTopping() {

        boolean quit = false;
        Meat topping;
        String meat;
        boolean extra;

        while (!quit) {
            System.out.println("what type of meat would you like");
            System.out.println();
            System.out.println("1) pepperoni");
            System.out.println("2) sausage");
            System.out.println("3) ham");
            System.out.println("4) bacon");
            System.out.println("5) chicken");
            System.out.println("6) meatball");
            System.out.println("0) go back");
            System.out.println();

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    meat = "pepperoni";
                    extra = isExtra(meat);
                    topping = new Meat(meat, extra);
                    allTops.add(topping);
                    break;
                case "2":
                    meat = "sausage";
                    extra = isExtra(meat);
                    topping = new Meat(meat, extra);
                    allTops.add(topping);
                    break;
                case "3":
                    meat = "ham";
                    extra = isExtra(meat);
                    topping = new Meat(meat, extra);
                    allTops.add(topping);
                    break;
                case "4":
                    meat = "bacon";
                    extra = isExtra(meat);
                    topping = new Meat(meat, extra);
                    allTops.add(topping);
                    break;
                case "5":
                    meat = "chicken";
                    extra = isExtra(meat);
                    topping = new Meat(meat, extra);
                    allTops.add(topping);
                    break;
                case "6":
                    meat = "meatball";
                    extra = isExtra(meat);
                    topping = new Meat(meat, extra);
                    allTops.add(topping);
                    break;
                case "0":
                    cancelOrder();
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }

    public void cheeseTopping() {
        boolean quit = false;
        Cheese topping;
        String cheese;
        boolean extra;

        while (!quit) {
            System.out.println("what type of cheese would you like");
            System.out.println();
            System.out.println("1) Mozzarella");
            System.out.println("2) Parmesan");
            System.out.println("3) Ricotta");
            System.out.println("4) Goat Cheese");
            System.out.println("5) Buffalo");
            System.out.println("0) go back");
            System.out.println();

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    cheese = "Mozzarella";
                    extra = isExtra(cheese);
                    topping = new Cheese(cheese, extra);
                    allTops.add(topping);
                    break;
                case "2":
                    cheese = "Parmesan";
                    extra = isExtra(cheese);
                    topping = new Cheese(cheese, extra);
                    allTops.add(topping);
                    break;
                case "3":
                    cheese = "Ricotta";
                    extra = isExtra(cheese);
                    topping = new Cheese(cheese, extra);
                    allTops.add(topping);
                    break;
                case "4":
                    cheese = "Goat Cheese";
                    extra = isExtra(cheese);
                    topping = new Cheese(cheese, extra);
                    allTops.add(topping);
                    break;
                case "5":
                    cheese = "Buffalo";
                    extra = isExtra(cheese);
                    topping = new Cheese(cheese, extra);
                    allTops.add(topping);
                    break;
                case "0":
                    cancelOrder();
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void regularTopping() {
    }

    public void sauceTopping() {
    }

    public void sideTopping() {
    }

    public void finishPizza() {
        Pizza pizza = new Pizza(allTops,size,stuffed,crust);
        order.addItem(pizza);
    }

    public void makeDrink() {

        System.out.println("======= Drink sizes ======");
        // change to numbers later
        System.out.println("1) Small");
        System.out.println("2) Medium");
        System.out.println("3) Large");

        System.out.print("enter the size of your drink: ");
        String size = scanner.nextLine();

        System.out.println("enter the flavor of your drink: ");
        String flavor = scanner.nextLine();

        Drink drink = new Drink(size, flavor);
        order.addItem(drink);
    }

    public void makeGarlicKnot() {
        System.out.println("enter the flavor of your Garlic Knots: ");
        String flavor = scanner.nextLine();

        GarlicKnots knots = new GarlicKnots(flavor);
        order.addItem(knots);
    }

    public void checkOut() {
        double price = order.getTotalPrice();
        System.out.println(price);
    }

    public void cancelOrder() {
    }

    public boolean isExtra(String option) {
        boolean isExtra;
        System.out.println("do you want extra " + option + "?(Yes/No): ");
        String extra = scanner.nextLine();
        if (extra.equalsIgnoreCase("yes")) {
            isExtra = true;
        } else {
            isExtra = false;
        }

        return isExtra;
    }

}
