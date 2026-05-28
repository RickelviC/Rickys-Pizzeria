package com.pluralsight.Plaza.Pizzeria.ui;


import com.pluralsight.Plaza.Pizzeria.model.Order;
import com.pluralsight.Plaza.Pizzeria.model.products.Drink;
import com.pluralsight.Plaza.Pizzeria.model.products.GarlicKnots;
import com.pluralsight.Plaza.Pizzeria.interfaces.IPriceable;
import com.pluralsight.Plaza.Pizzeria.model.products.Pizza;
import com.pluralsight.Plaza.Pizzeria.model.toppings.*;
import com.pluralsight.Plaza.Pizzeria.util.FileManager;

import java.util.*;

public class UserInterface {

    private static final String BOLD = "\u001B[1m";
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String CYAN = "\u001B[36m";
    private static final String YELLOW = "\u001B[33m";


    private Scanner scanner;
    private Order order;
    private int size;
    private String crust;
    private boolean stuffed;
    private String name = "custom";
    private List<Topping> allTops = new ArrayList<>();

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
            System.out.println(CYAN + BOLD + "=========== Menu ==========" + RESET);
            System.out.println(YELLOW + "1) " + RESET + CYAN + "Make A Pizza");
            System.out.println(YELLOW + "2) " + RESET + CYAN + "Drinks");
            System.out.println(YELLOW + "3) " + RESET + CYAN + "Garlic Knots");
            System.out.println(YELLOW + "4) " + RESET + CYAN + "CheckOut");
            System.out.println(YELLOW + "5) " + RESET + CYAN + "Cancel Order");
            System.out.println(RED + "0) " + RESET + CYAN + "Go Back" + RESET);
            System.out.println(CYAN + BOLD + "===========================" + RESET);

            System.out.print(YELLOW + "→ Enter your choice: " + RESET);
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
                    displayOrder();
                    break;
                case "5":
                    cancelOrder();
                    break;
                case "0":
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
            System.out.println(YELLOW + "1) " + RESET + CYAN + "Signature Pizza");
            System.out.println(YELLOW + "2) " + RESET + CYAN + "Size Of Pizza");
            System.out.println(YELLOW + "3) " + RESET + CYAN + "Type Of Crust");
            System.out.println(YELLOW + "4) " + RESET + CYAN + "Stuffed Crust");
            System.out.println(YELLOW + "5) " + RESET + CYAN + "Topping");
            System.out.println(YELLOW + "6) " + RESET + CYAN + "Finish Pizza");
            System.out.println(RED + "0) " + RESET + CYAN + "Go Back" + RESET);
            System.out.println(CYAN + BOLD + "===========================" + RESET);


            System.out.print(YELLOW + "→ Enter your choice: " + RESET);
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    signatureMenu();
                    break;
                case "2":
                    size = pizzaSize();
                    break;
                case "3":
                    crust = crustType();
                    break;
                case "4":
                    stuffed = chooseStuffed();
                    break;
                case "5":
                    pizzaToppingMenu();
                    break;
                case "6":
                    finishPizza();
                    quit = true;
                    break;
                case "0":
                    quit = true;
                    break;
                default:
                    System.err.println("Invalid choice. 1-6 or 0 to back");
            }
        }
    }

    public void signatureMenu() {
        boolean quit = false;
        while (!quit) {
            System.out.println("---------- Signature Menu ----------");
            System.out.println("1) Margherita");
            System.out.println("2) Veggie");
            System.out.println(RED + "0) " + RESET + CYAN + "Quit" + RESET);
            System.out.println(CYAN + BOLD + "===========================" + RESET);

            System.out.print(YELLOW + "→ Enter your choice: " + RESET);
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    makeMargherita();
                    pizzaToppingMenu();
                    quit = true;
                    break;
                case "2":
                    makeVeggie();
                    pizzaToppingMenu();
                    quit = true;
                    break;
                case "0":
                    quit = true;
                    break;
                default:
                    System.err.println("Invalid choice. 1-2 or 0 to back");
            }
        }
    }

    public void makeMargherita() {

        Topping cheese = new Cheese("Mozzarella", false);
        allTops.add(cheese);

        Topping tomatoes = new Regular("tomatoes");
        allTops.add(tomatoes);

        Topping basil = new Regular("basil");
        allTops.add(basil);

        Topping marinara = new Regular("marinara");
        allTops.add(marinara);

        Topping oliveOil = new Regular("olive Oil");
        allTops.add(oliveOil);

        size = 12;

        stuffed = false;

        crust = "regular";

        name = "Margherita";

        System.out.println("added Margherita Pizza to the order");

    }

    public void makeVeggie() {

        Topping cheese = new Cheese("Mozzarella", false);
        allTops.add(cheese);

        Topping bellPeppers = new Regular("Bell Peppers");
        allTops.add(bellPeppers);

        Topping spinach = new Regular("Spinach");
        allTops.add(spinach);

        Topping marinara = new Regular("marinara");
        allTops.add(marinara);

        Topping olive = new Regular("Olives");
        allTops.add(olive);

        Topping onions = new Regular("Onions");
        allTops.add(onions);

        size = 8;

        stuffed = false;

        crust = "regular";

        name = "Veggie";


        System.out.println("added Veggie Pizza to the order");
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
            System.out.println(RED + "0) " + RESET + CYAN + "Quit" + RESET);
            System.out.println(CYAN + BOLD + "===========================" + RESET);

            System.out.print(YELLOW + "→ Enter your choice: " + RESET);
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

    public boolean chooseStuffed() {
        System.out.println("do you want your crust stuffed? (Yes/No)");
        System.out.println("1) yes");
        System.out.println("2) no");
        System.out.println();
        System.out.print(YELLOW + "→ Enter your choice: " + RESET);

        boolean pass = false;

        while (!pass) {

            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("1")) {
                stuffed = true;
                System.out.println("you chose stuffed crust");
                pass = true;
            } else if (input.equalsIgnoreCase("2")) {
                System.out.println("you chose no stuffed crust");
                pass = true;
            } else {
                System.err.println("Invalid choice. 1-2");
            }
        }
        return stuffed;
    }

    public String crustType() {
        System.out.println("what type of crust would you like");
        System.out.println();
        System.out.println("1) thin");
        System.out.println("2) regular");
        System.out.println("3) thick");
        System.out.println("4) cauliflower");
        System.out.println();
        System.out.print(YELLOW + "→ Enter your choice: " + RESET);

        boolean pass = false;
        while (!pass) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("1")) {
                crust = "think";
                System.out.println("you chose a " + crust + " crust");
                pass = true;
            } else if (input.equalsIgnoreCase("2")) {
                crust = "regular";
                System.out.println("you chose a " + crust + " crust");
                pass = true;
            } else if (input.equalsIgnoreCase("3")) {
                crust = "thick";
                System.out.println("you chose a " + crust + " crust");
                pass = true;

            } else if (input.equalsIgnoreCase("4")) {
                crust = "cauliflower";
                System.out.println("you chose a " + crust + " crust");
                pass = true;
            } else {
                System.out.println("enter one of the options");
            }
        }
        return crust;
    }

    public int pizzaSize() {

        System.out.println("1) 8 inch Small $8.50");
        System.out.println("2) 12 inch Medium $12.0");
        System.out.println("3) 16 inch Large $16.50");
        System.out.print(YELLOW + "→ Enter your choice: " + RESET);

        boolean pass = false;
        while (!pass) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("1")) {
                size = 8;
                System.out.println("you chose a " + size + " inch pizza");
                pass = true;
            } else if (input.equalsIgnoreCase("2")) {
                size = 12;
                System.out.println("you chose a " + size + " inch pizza");
                pass = true;
            } else if (input.equalsIgnoreCase("3")) {
                size = 16;
                System.out.println("you chose a " + size + " inch pizza");
                pass = true;
            } else {
                System.out.println("enter one of the options");
            }

        }

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
            System.out.println(RED + "0) " + RESET + CYAN + "Quit" + RESET);
            System.out.println(CYAN + BOLD + "===========================" + RESET);
            System.out.println();

            System.out.print(YELLOW + "→ Enter your choice: " + RESET);
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
            System.out.println(RED + "0) " + RESET + CYAN + "Quit" + RESET);
            System.out.println(CYAN + BOLD + "===========================" + RESET);
            System.out.println();

            System.out.print(YELLOW + "→ Enter your choice: " + RESET);
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
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void regularTopping() {

        boolean quit = false;
        Regular topping;
        String regular;

        while (!quit) {
            System.out.println("what type of Regular Toppings would you like");
            System.out.println();
            System.out.println("1) onions");
            System.out.println("2) mushrooms");
            System.out.println("3) bell peppers");
            System.out.println("4) olives");
            System.out.println("5) tomatoes");
            System.out.println("6) spinach");
            System.out.println("7) basil");
            System.out.println("8) pineapple");
            System.out.println("9) anchovies");
            System.out.println(RED + "0) " + RESET + CYAN + "Quit" + RESET);
            System.out.println(CYAN + BOLD + "===========================" + RESET);
            System.out.println();

            System.out.print(YELLOW + "→ Enter your choice: " + RESET);
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    regular = "onions";
                    topping = new Regular(regular);
                    allTops.add(topping);
                    break;
                case "2":
                    regular = "mushrooms";
                    topping = new Regular(regular);
                    allTops.add(topping);
                    break;
                case "3":
                    regular = "bell peppers";
                    topping = new Regular(regular);
                    allTops.add(topping);
                    break;
                case "4":
                    regular = "olives";
                    topping = new Regular(regular);
                    allTops.add(topping);
                    break;
                case "5":
                    regular = "tomatoes";
                    topping = new Regular(regular);
                    allTops.add(topping);
                    break;
                case "6":
                    regular = "spinach";
                    topping = new Regular(regular);
                    allTops.add(topping);
                    break;
                case "7":
                    regular = "basil";
                    topping = new Regular(regular);
                    allTops.add(topping);
                    break;
                case "8":
                    regular = "pineapple";
                    topping = new Regular(regular);
                    allTops.add(topping);
                    break;
                case "9":
                    regular = "anchovies";
                    topping = new Regular(regular);
                    allTops.add(topping);
                    break;
                case "0":
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void sauceTopping() {

        boolean quit = false;
        Sauce topping;
        String sauce;

        while (!quit) {
            System.out.println("what type of Sauce would you like");
            System.out.println();
            System.out.println("1) marinara");
            System.out.println("2) Alfredo");
            System.out.println("3) pesto");
            System.out.println("4) bbq");
            System.out.println("5) buffalo");
            System.out.println("6) olive oil");
            System.out.println(RED + "0) " + RESET + CYAN + "Quit" + RESET);
            System.out.println(CYAN + BOLD + "===========================" + RESET);
            System.out.println();

            System.out.print(YELLOW + "→ Enter your choice: " + RESET);
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    sauce = "marinara";
                    topping = new Sauce(sauce);
                    allTops.add(topping);
                    break;
                case "2":
                    sauce = "Alfredo";
                    topping = new Sauce(sauce);
                    allTops.add(topping);
                    break;
                case "3":
                    sauce = "pesto";
                    topping = new Sauce(sauce);
                    allTops.add(topping);
                    break;
                case "4":
                    sauce = "bbq";
                    topping = new Sauce(sauce);
                    allTops.add(topping);
                    break;
                case "5":
                    sauce = "buffalo";
                    topping = new Sauce(sauce);
                    allTops.add(topping);
                    break;
                case "6":
                    sauce = "olive oil";
                    topping = new Sauce(sauce);
                    allTops.add(topping);
                    break;
                case "0":
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void sideTopping() {

        boolean quit = false;
        Side topping;
        String side;

        while (!quit) {
            System.out.println("what type of sides would you like");
            System.out.println();
            System.out.println("1) red pepper");
            System.out.println("2) Parmesan");
            System.out.println(RED + "0) " + RESET + CYAN + "Quit" + RESET);
            System.out.println(CYAN + BOLD + "===========================" + RESET);
            System.out.println();

            System.out.print(YELLOW + "→ Enter your choice: " + RESET);
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    side = "red pepper";
                    topping = new Side(side);
                    allTops.add(topping);
                    break;
                case "2":
                    side = "Parmesan";
                    topping = new Side(side);
                    allTops.add(topping);
                    break;
                case "0":
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void finishPizza() {

        if (size != 0) {
            Pizza pizza = new Pizza(allTops, size, stuffed, crust, name);
            order.addItem(pizza);
        } else {
            System.out.println("more options needed to make the pizza");
        }
    }

    public void makeDrink() {

        System.out.println("======= Drink sizes ======");
        System.out.println("1) Small");
        System.out.println("2) Medium");
        System.out.println("3) Large");

        System.out.print(YELLOW + "→ Enter your choice: " + RESET);

        boolean pass = false;
        String size = "";
        while (!pass) {

            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("1")) {
                size = "small";
                System.out.println("you chose a " + size + " Drink");
                pass = true;
            } else if (input.equalsIgnoreCase("2")) {
                size = "medium";
                System.out.println("you chose a " + size + " Drink");
                pass = true;
            } else if (input.equalsIgnoreCase("3")) {
                size = "large";
                System.out.println("you chose a " + size + " Drink");
                pass = true;
            } else {
                System.out.println("enter one of the options");
            }
        }
        System.out.print(YELLOW + "→ Enter The Flavor Of Your Drink: " + RESET);
        String flavor = scanner.nextLine();

        Drink drink = new Drink(size, flavor);
        order.addItem(drink);
    }

    public void makeGarlicKnot() {
        System.out.print(YELLOW + "→ Enter The Flavor Of Your Garlic Knots: " + RESET);
        String flavor = scanner.nextLine();

        GarlicKnots knots = new GarlicKnots(flavor);
        order.addItem(knots);
    }

    public void checkOut() {
        FileManager fileManager = new FileManager();
        fileManager.saveOrder(order);

        cancelOrder();
    }

    public void displayOrder() {

        boolean pass = false;
        while (!pass) {
            if (!(order.getTotalPrice() == 0)) {
                HashSet<IPriceable> uniqueItems = new HashSet<>(order.getItems());

                for (IPriceable item : uniqueItems) {
                    System.out.println(item);
                }

                double total = 0.0;

                for (IPriceable uniqueItem : uniqueItems) {
                    total += uniqueItem.getPrice();
                }
                System.out.println("-----------------------------");
                System.out.println("total price: $" + String.format("%.2f", total));
                System.out.println("-----------------------------");

                System.out.println();
                System.out.println();
                System.out.println("do you want to check out?");
                System.out.println("1) Yes");
                System.out.println("2) No");

                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("1")) {
                    checkOut();
                    System.out.println(" you paid: $" + String.format("%.2f", total));
                    pass = true;
                } else if (input.equalsIgnoreCase("2")) {
                    pass = true;
                } else {
                    System.out.println("enter one of the options");
                }
            } else if (order.getTotalPrice() == 0) {
                System.out.println("get something first to check out");
                pass = true;
            }
        }
    }

    public void cancelOrder() {

        if (!order.getItems().isEmpty()) {
            order.getItems().clear();
            System.out.println("order cleared");
        } else {
            System.out.println("there is nothing to cancel");
        }


    }

    public boolean isExtra(String option) {
        boolean isExtra = false;
        System.out.println("do you want extra " + option + "?(Yes/No): ");
        System.out.println("1) Yes");
        System.out.println("2) NO");
        System.out.println();

        boolean pass = false;
        while (!pass) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("1")) {
                isExtra = true;
                System.out.println("you chose to get extra " + option + " on your pizza");
                pass = true;
            } else if (input.equalsIgnoreCase("2")) {
                System.out.println("you chose to get extra " + option + " on your pizza");
                pass = true;
            } else {
                System.out.println("enter one of the options");
            }
        }
        return isExtra;
    }
}