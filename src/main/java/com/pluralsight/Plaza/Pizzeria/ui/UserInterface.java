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
            System.out.println(CYAN + BOLD + "===== Rickys Pizzeria =====" + RESET);
            System.out.println(YELLOW + "1) " + RESET + CYAN + "Make A Pizza");
            System.out.println(YELLOW + "2) " + RESET + CYAN + "Drinks");
            System.out.println(YELLOW + "3) " + RESET + CYAN + "Garlic Knots");
            System.out.println(YELLOW + "4) " + RESET + CYAN + "CheckOut");
            System.out.println(YELLOW + "5) " + RESET + CYAN + "Cancel Order");
            System.out.println(RED + "0) " + RESET + CYAN + "Go Back" + RESET);
            System.out.println(CYAN + BOLD + "===========================" + RESET);

            System.out.print(YELLOW + "→ Enter your Choice: " + RESET);
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
                    System.err.println("Invalid Choice. 1-5 or 0");
            }
        }
    }

    public void pizzaMenu() {
        boolean quit = false;
        while (!quit) {
            System.out.println(CYAN + BOLD + "======== Pizza Menu =======" + RESET);
            System.out.println(YELLOW + "1) " + RESET + CYAN + "Signature Pizza");
            System.out.println(YELLOW + "2) " + RESET + CYAN + "Size Of Pizza");
            System.out.println(YELLOW + "3) " + RESET + CYAN + "Type Of Crust");
            System.out.println(YELLOW + "4) " + RESET + CYAN + "Stuffed Crust");
            System.out.println(YELLOW + "5) " + RESET + CYAN + "Topping");
            System.out.println(YELLOW + "6) " + RESET + CYAN + "Finish Pizza");
            System.out.println(RED + "0) " + RESET + CYAN + "Go Back" + RESET);
            System.out.println(CYAN + BOLD + "===========================" + RESET);


            System.out.print(YELLOW + "→ Enter your Choice: " + RESET);
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
                    System.err.println("Invalid Choice. 1-6 or 0");
            }
        }
    }

    public void signatureMenu() {
        boolean quit = false;
        while (!quit) {
            System.out.println(CYAN + BOLD + "======== Signature ========" + RESET);
            System.out.println(YELLOW + "1) " + RESET + CYAN + "Margherita");
            System.out.println(YELLOW + "2) " + RESET + CYAN + "Veggie");
            System.out.println(RED + "0) " + RESET + CYAN + "Quit" + RESET);
            System.out.println(CYAN + BOLD + "===========================" + RESET);

            System.out.print(YELLOW + "→ Enter your Choice: " + RESET);
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
                    System.err.println("Invalid Choice. 1-2 or 0");
            }
        }
    }

    public void makeMargherita() {

        Topping cheese = new Cheese("Mozzarella", false);
        allTops.add(cheese);

        Topping tomatoes = new Regular("Tomatoes");
        allTops.add(tomatoes);

        Topping basil = new Regular("Basil");
        allTops.add(basil);

        Topping marinara = new Regular("Marinara");
        allTops.add(marinara);

        Topping oliveOil = new Regular("Olive Oil");
        allTops.add(oliveOil);

        size = 12;
        stuffed = false;
        crust = "Regular";
        name = "Margherita";

        System.out.println(GREEN + "✔ Added Margherita Pizza To Order" + RESET);

    }

    public void makeVeggie() {

        Topping cheese = new Cheese("Mozzarella", false);
        allTops.add(cheese);

        Topping bellPeppers = new Regular("Bell Peppers");
        allTops.add(bellPeppers);

        Topping spinach = new Regular("Spinach");
        allTops.add(spinach);

        Topping marinara = new Regular("Marinara");
        allTops.add(marinara);

        Topping olive = new Regular("Olives");
        allTops.add(olive);

        Topping onions = new Regular("Onions");
        allTops.add(onions);

        size = 8;
        stuffed = false;
        crust = "Regular";
        name = "Veggie";

        System.out.println(GREEN + "✔ Added Veggie Pizza To Order" + RESET);
    }

    public void pizzaToppingMenu() {
        boolean quit = false;
        while (!quit) {
            System.out.println(CYAN + BOLD + "========= Topping =========" + RESET);
            System.out.println(YELLOW + "1) " + RESET + CYAN + "Meats");
            System.out.println(YELLOW + "2) " + RESET + CYAN + "Cheese");
            System.out.println(YELLOW + "3) " + RESET + CYAN + "Regular");
            System.out.println(YELLOW + "4) " + RESET + CYAN + "Sauces");
            System.out.println(YELLOW + "5) " + RESET + CYAN + "Sides");
            System.out.println(RED + "0) " + RESET + CYAN + "Quit" + RESET);
            System.out.println(CYAN + BOLD + "===========================" + RESET);

            System.out.print(YELLOW + "→ Enter your Choice: " + RESET);
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
                    System.err.println("Invalid Choice. 1-5 or 0");
            }
        }
    }

    public boolean chooseStuffed() {
        System.out.println(CYAN + BOLD + "====== Stuffed Crust ======" + RESET);
        System.out.println(YELLOW + "1) " + RESET + CYAN + "Yes");
        System.out.println(YELLOW + "2) " + RESET + CYAN + "No");
        System.out.println(CYAN + BOLD + "===========================" + RESET);
        System.out.print(YELLOW + "→ Enter your Choice: " + RESET);

        boolean pass = false;

        while (!pass) {

            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("1")) {
                stuffed = true;
                System.out.println(GREEN + "✔ Stuffed Crust" + RESET);
                pass = true;
            } else if (input.equalsIgnoreCase("2")) {
                System.out.println(GREEN + "✔ No Stuffed Crust" + RESET);
                pass = true;
            } else {
                System.err.println("Invalid Choice. 1-2");
            }
        }
        return stuffed;
    }

    public String crustType() {
        System.out.println(CYAN + BOLD + "====== Crust type ======" + RESET);
        System.out.println(YELLOW + "1) " + RESET + CYAN + "Thin");
        System.out.println(YELLOW + "2) " + RESET + CYAN + "Regular");
        System.out.println(YELLOW + "3) " + RESET + CYAN + "Thick");
        System.out.println(YELLOW + "4) " + RESET + CYAN + "Cauliflower");
        System.out.println(CYAN + BOLD + "===========================" + RESET);
        System.out.print(YELLOW + "→ Enter your choice: " + RESET);

        boolean pass = false;
        while (!pass) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("1")) {
                crust = "Think";
                System.out.println(GREEN + "✔ " + crust + " Crust" + RESET);
                pass = true;
            } else if (input.equalsIgnoreCase("2")) {
                crust = "Regular";
                System.out.println(GREEN + "✔ " + crust + " Crust" + RESET);
                pass = true;
            } else if (input.equalsIgnoreCase("3")) {
                crust = "Thick";
                System.out.println(GREEN + "✔ " + crust + " Crust" + RESET);
                pass = true;

            } else if (input.equalsIgnoreCase("4")) {
                crust = "Cauliflower";
                System.out.println(GREEN + "✔ " + crust + " Crust" + RESET);
                pass = true;
            } else {
                System.err.println("Invalid Choice. 1-4");
            }
        }
        return crust;
    }

    public int pizzaSize() {
        System.out.println(CYAN + BOLD + "========== Size ==========" + RESET);
        System.out.println(YELLOW + "1) " + RESET + CYAN + "8 inch Small $8.50");
        System.out.println(YELLOW + "2) " + RESET + CYAN + "12 inch Medium $12.00");
        System.out.println(YELLOW + "3) " + RESET + CYAN + "16 inch Large $16.50");
        System.out.println(CYAN + BOLD + "===========================" + RESET);
        System.out.print(YELLOW + "→ Enter your choice: " + RESET);

        boolean pass = false;
        while (!pass) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("1")) {
                size = 8;
                System.out.println(GREEN + "✔ " + size + " inch Pizza - Small" + RESET);
                pass = true;
            } else if (input.equalsIgnoreCase("2")) {
                size = 12;
                System.out.println(GREEN + "✔ " + size + " inch Pizza - Medium" + RESET);
                pass = true;
            } else if (input.equalsIgnoreCase("3")) {
                size = 16;
                System.out.println(GREEN + "✔ " + size + " inch Pizza - Large" + RESET);
                pass = true;
            } else {
                System.err.println("Invalid Choice. 1-3");
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
            System.out.println(CYAN + BOLD + "====== Meat Options =======" + RESET);
            System.out.println(YELLOW + "1) " + RESET + CYAN + "Pepperoni");
            System.out.println(YELLOW + "2) " + RESET + CYAN + "Sausage");
            System.out.println(YELLOW + "3) " + RESET + CYAN + "Ham");
            System.out.println(YELLOW + "4) " + RESET + CYAN + "Bacon");
            System.out.println(YELLOW + "5) " + RESET + CYAN + "Chicken");
            System.out.println(YELLOW + "6) " + RESET + CYAN + "Meatball");
            System.out.println(RED + "0) " + RESET + CYAN + "Quit" + RESET);
            System.out.println(CYAN + BOLD + "===========================" + RESET);

            System.out.print(YELLOW + "→ Enter your choice: " + RESET);
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    meat = "Pepperoni";
                    extra = isExtra(meat);
                    topping = new Meat(meat, extra);
                    allTops.add(topping);
                    System.out.println(GREEN + "✔ " + meat + " Added" + RESET);
                    break;
                case "2":
                    meat = "Sausage";
                    extra = isExtra(meat);
                    topping = new Meat(meat, extra);
                    allTops.add(topping);
                    System.out.println(GREEN + "✔ " + meat + " Added" + RESET);
                    break;
                case "3":
                    meat = "Ham";
                    extra = isExtra(meat);
                    topping = new Meat(meat, extra);
                    allTops.add(topping);
                    System.out.println(GREEN + "✔ " + meat + " Added" + RESET);
                    break;
                case "4":
                    meat = "Bacon";
                    extra = isExtra(meat);
                    topping = new Meat(meat, extra);
                    allTops.add(topping);
                    System.out.println(GREEN + "✔ " + meat + " Added" + RESET);
                    break;
                case "5":
                    meat = "Chicken";
                    extra = isExtra(meat);
                    topping = new Meat(meat, extra);
                    allTops.add(topping);
                    System.out.println(GREEN + "✔ " + meat + " Added" + RESET);
                    break;
                case "6":
                    meat = "Meatball";
                    extra = isExtra(meat);
                    topping = new Meat(meat, extra);
                    allTops.add(topping);
                    System.out.println(GREEN + "✔ " + meat + " Added" + RESET);
                    break;
                case "0":
                    quit = true;
                    break;
                default:
                    System.err.println("Invalid Choice. 1-6 Or 0");
            }
        }
    }

    public void cheeseTopping() {
        boolean quit = false;
        Cheese topping;
        String cheese;
        boolean extra;

        while (!quit) {
            System.out.println(CYAN + BOLD + "===== Cheese Options ======" + RESET);
            System.out.println(YELLOW + "1) " + RESET + CYAN + "Mozzarella");
            System.out.println(YELLOW + "2) " + RESET + CYAN + "Parmesan");
            System.out.println(YELLOW + "3) " + RESET + CYAN + "Ricotta");
            System.out.println(YELLOW + "4) " + RESET + CYAN + "Goat Cheese");
            System.out.println(YELLOW + "5) " + RESET + CYAN + "Buffalo");
            System.out.println(RED + "0) " + RESET + CYAN + "Quit" + RESET);
            System.out.println(CYAN + BOLD + "===========================" + RESET);

            System.out.print(YELLOW + "→ Enter your choice: " + RESET);
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    cheese = "Mozzarella";
                    extra = isExtra(cheese);
                    topping = new Cheese(cheese, extra);
                    allTops.add(topping);
                    System.out.println(GREEN + "✔ " + cheese + " Added" + RESET);
                    break;
                case "2":
                    cheese = "Parmesan";
                    extra = isExtra(cheese);
                    topping = new Cheese(cheese, extra);
                    allTops.add(topping);
                    System.out.println(GREEN + "✔ " + cheese + " Added" + RESET);
                    break;
                case "3":
                    cheese = "Ricotta";
                    extra = isExtra(cheese);
                    topping = new Cheese(cheese, extra);
                    allTops.add(topping);
                    System.out.println(GREEN + "✔ " + cheese + " Added" + RESET);
                    break;
                case "4":
                    cheese = "Goat Cheese";
                    extra = isExtra(cheese);
                    topping = new Cheese(cheese, extra);
                    allTops.add(topping);
                    System.out.println(GREEN + "✔ " + cheese + " Added" + RESET);
                    break;
                case "5":
                    cheese = "Buffalo";
                    extra = isExtra(cheese);
                    topping = new Cheese(cheese, extra);
                    allTops.add(topping);
                    System.out.println(GREEN + "✔ " + cheese + " Added" + RESET);
                    break;
                case "0":
                    quit = true;
                    break;
                default:
                    System.err.println("Invalid Choice. 1-5 Or 0");
            }
        }
    }

    public void regularTopping() {

        boolean quit = false;
        Regular topping;
        String regular;

        while (!quit) {
            System.out.println(CYAN + BOLD + "===== Regular Options ======" + RESET);
            System.out.println(YELLOW + "1) " + RESET + CYAN + "Onions");
            System.out.println(YELLOW + "2) " + RESET + CYAN + "Mushrooms");
            System.out.println(YELLOW + "3) " + RESET + CYAN + "Bell Peppers");
            System.out.println(YELLOW + "4) " + RESET + CYAN + "Olives");
            System.out.println(YELLOW + "5) " + RESET + CYAN + "Tomatoes");
            System.out.println(YELLOW + "6) " + RESET + CYAN + "Spinach");
            System.out.println(YELLOW + "7) " + RESET + CYAN + "Basil");
            System.out.println(YELLOW + "8) " + RESET + CYAN + "Pineapple");
            System.out.println(YELLOW + "9) " + RESET + CYAN + "Anchovies");
            System.out.println(RED + "0) " + RESET + CYAN + "Quit" + RESET);
            System.out.println(CYAN + BOLD + "===========================" + RESET);

            System.out.print(YELLOW + "→ Enter your choice: " + RESET);
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    regular = "onions";
                    topping = new Regular(regular);
                    allTops.add(topping);
                    System.out.println(GREEN + "✔ " + regular + " Added" + RESET);
                    break;
                case "2":
                    regular = "mushrooms";
                    topping = new Regular(regular);
                    allTops.add(topping);
                    System.out.println(GREEN + "✔ " + regular + " Added" + RESET);
                    break;
                case "3":
                    regular = "bell peppers";
                    topping = new Regular(regular);
                    allTops.add(topping);
                    System.out.println(GREEN + "✔ " + regular + " Added" + RESET);
                    break;
                case "4":
                    regular = "olives";
                    topping = new Regular(regular);
                    allTops.add(topping);
                    System.out.println(GREEN + "✔ " + regular + " Added" + RESET);
                    break;
                case "5":
                    regular = "tomatoes";
                    topping = new Regular(regular);
                    allTops.add(topping);
                    System.out.println(GREEN + "✔ " + regular + " Added" + RESET);
                    break;
                case "6":
                    regular = "spinach";
                    topping = new Regular(regular);
                    allTops.add(topping);
                    System.out.println(GREEN + "✔ " + regular + " Added" + RESET);
                    break;
                case "7":
                    regular = "basil";
                    topping = new Regular(regular);
                    allTops.add(topping);
                    System.out.println(GREEN + "✔ " + regular + " Added" + RESET);
                    break;
                case "8":
                    regular = "pineapple";
                    topping = new Regular(regular);
                    allTops.add(topping);
                    System.out.println(GREEN + "✔ " + regular + " Added" + RESET);
                    break;
                case "9":
                    regular = "anchovies";
                    topping = new Regular(regular);
                    allTops.add(topping);
                    System.out.println(GREEN + "✔ " + regular + " Added" + RESET);
                    break;
                case "0":
                    quit = true;
                    break;
                default:
                    System.err.println("Invalid Choice. 1-9 Or 0");
            }
        }
    }

    public void sauceTopping() {

        boolean quit = false;
        Sauce topping;
        String sauce;

        while (!quit) {
            System.out.println(CYAN + BOLD + "===== Sauce Options ======" + RESET);
            System.out.println(YELLOW + "1) " + RESET + CYAN + "Marinara");
            System.out.println(YELLOW + "2) " + RESET + CYAN + "Alfredo");
            System.out.println(YELLOW + "3) " + RESET + CYAN + "Pesto");
            System.out.println(YELLOW + "4) " + RESET + CYAN + "BBQ");
            System.out.println(YELLOW + "5) " + RESET + CYAN + "Buffalo");
            System.out.println(YELLOW + "6) " + RESET + CYAN + "Olive Oil");
            System.out.println(RED + "0) " + RESET + CYAN + "Quit" + RESET);
            System.out.println(CYAN + BOLD + "===========================" + RESET);

            System.out.print(YELLOW + "→ Enter your choice: " + RESET);
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    sauce = "Marinara";
                    topping = new Sauce(sauce);
                    allTops.add(topping);
                    System.out.println(GREEN + "✔ " + sauce + " Added" + RESET);
                    break;
                case "2":
                    sauce = "Alfredo";
                    topping = new Sauce(sauce);
                    allTops.add(topping);
                    System.out.println(GREEN + "✔ " + sauce + " Added" + RESET);
                    break;
                case "3":
                    sauce = "Pesto";
                    topping = new Sauce(sauce);
                    allTops.add(topping);
                    System.out.println(GREEN + "✔ " + sauce + " Added" + RESET);
                    break;
                case "4":
                    sauce = "BBQ";
                    topping = new Sauce(sauce);
                    allTops.add(topping);
                    System.out.println(GREEN + "✔ " + sauce + " Added" + RESET);
                    break;
                case "5":
                    sauce = "Buffalo";
                    topping = new Sauce(sauce);
                    allTops.add(topping);
                    System.out.println(GREEN + "✔ " + sauce + " Added" + RESET);
                    break;
                case "6":
                    sauce = "Olive oil";
                    topping = new Sauce(sauce);
                    allTops.add(topping);
                    System.out.println(GREEN + "✔ " + sauce + " Added" + RESET);
                    break;
                case "0":
                    quit = true;
                    break;
                default:
                    System.err.println("Invalid Choice. 1-6 Or 0");
            }
        }
    }

    public void sideTopping() {

        boolean quit = false;
        Side topping;
        String side;

        while (!quit) {
            System.out.println(CYAN + BOLD + "===== sides Options ======" + RESET);
            System.out.println(YELLOW + "1) " + RESET + CYAN + "Red Pepper");
            System.out.println(YELLOW + "1) " + RESET + CYAN + "Parmesan");
            System.out.println(RED + "0) " + RESET + CYAN + "Quit" + RESET);
            System.out.println(CYAN + BOLD + "===========================" + RESET);

            System.out.print(YELLOW + "→ Enter your choice: " + RESET);
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    side = "Red Pepper";
                    topping = new Side(side);
                    allTops.add(topping);
                    System.out.println(GREEN + "✔ " + side + " Added" + RESET);
                    break;
                case "2":
                    side = "Parmesan";
                    topping = new Side(side);
                    allTops.add(topping);
                    System.out.println(GREEN + "✔ " + side + " Added" + RESET);
                    break;
                case "0":
                    quit = true;
                    break;
                default:
                    System.err.println("Invalid Choice. 1-2 Or 0");
            }
        }
    }

    public void finishPizza() {

        if (size != 0) {
            Pizza pizza = new Pizza(allTops, size, stuffed, crust, name);
            order.addItem(pizza);
        } else {
            System.err.println("Choose a Size to Make The Pizza");
        }
    }

    public void makeDrink() {

        System.out.print(YELLOW + "→ Enter The Flavor Of Your Drink: " + RESET);
        String flavor = scanner.nextLine();

        String drinkSize = "";
        boolean quit = false;
        while (!quit) {
            System.out.println(CYAN + BOLD + "===== Drink Sizes ======" + RESET);
            System.out.println(YELLOW + "1) " + RESET + CYAN + "Small");
            System.out.println(YELLOW + "2) " + RESET + CYAN + "Medium");
            System.out.println(YELLOW + "3) " + RESET + CYAN + "Large");
            System.out.println(RED + "0) " + RESET + CYAN + "Quit" + RESET);
            System.out.println(CYAN + BOLD + "===========================" + RESET);

            System.out.print(YELLOW + "→ Enter your choice: " + RESET);
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    drinkSize = "Small";
                    System.out.println(GREEN + "✔ " + drinkSize + " " + flavor + " Drink Added" + RESET);
                    quit = true;
                    break;
                case "2":
                    drinkSize = "Medium";
                    System.out.println(GREEN + "✔ " + drinkSize + " " + flavor + " Drink Added" + RESET);
                    quit = true;
                    break;
                case "3":
                    drinkSize = "Large";
                    System.out.println(GREEN + "✔ " + drinkSize + " " + flavor + " Drink Added" + RESET);
                    quit = true;
                    break;
                case "0":
                    quit = true;
                    break;
                default:
                    System.err.println("Invalid Choice. 1-3 Or 0");
            }
        }

        Drink drink = new Drink(drinkSize, flavor);
        order.addItem(drink);
    }

    public void makeGarlicKnot() {
        System.out.print(YELLOW + "→ Enter The Flavor Of Your Garlic Knots: " + RESET);
        String flavor = scanner.nextLine();

        GarlicKnots knots = new GarlicKnots(flavor);
        order.addItem(knots);

        System.out.println(GREEN + "✔ " + flavor + " Garlic Knots Added" + RESET);
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
                    System.err.println("Invalid Choice. 1-2");
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
            System.out.println(GREEN + "✔ Order Cleared" + RESET);
        } else {
            System.out.println(RED + "No Order To Cancel" + RESET);
        }


    }

    public boolean isExtra(String option) {
        boolean isExtra = false;
        System.out.println(CYAN + BOLD + "do you want extra " + option + "?(Yes/No): " + RESET);
        System.out.println(YELLOW + "1) " + RESET + CYAN + "Yes");
        System.out.println(YELLOW + "1) " + RESET + CYAN + "No");
        System.out.println(CYAN + BOLD + "===========================" + RESET);
        System.out.print(YELLOW + "→ Enter your choice: " + RESET);

        boolean pass = false;
        while (!pass) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("1")) {
                isExtra = true;
                System.out.println(GREEN + "✔ Extra " + option + " Added" + RESET);
                pass = true;
            } else if (input.equalsIgnoreCase("2")) {
                System.out.println(RED + "✘ Extra " + option + " Was Not Added" + RESET);
                pass = true;
            } else {
                System.err.println("Invalid Choice. 1-2");
            }
        }
        return isExtra;
    }
}