package com.pluralsight.Plaza.Pizzeria.main;

import com.pluralsight.Plaza.Pizzeria.products.Drink;
import com.pluralsight.Plaza.Pizzeria.products.GarlicKnots;

import java.util.Scanner;
import java.util.UUID;

public class UserInterface {

    private Scanner scanner;
    private Order order;

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
            System.out.println("1. make your pizza");
            System.out.println("2. get your drink");
            System.out.println("3. get Garlic Knot");
            System.out.println("4. check out");
            System.out.println("5. cancel order");
            System.out.println("6. Quit");

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
        int size = pizzaSize();
        boolean quit = false;
        while (!quit) {
            System.out.println("---------- Topping Menu ----------");
            System.out.println("1. meat options");
            System.out.println("2. cheese options");
            System.out.println("3. regular toppings");
            System.out.println("4. sauce topping");
            System.out.println("5. side topping");
            System.out.println("6. finish your pizza");
            System.out.println("7. go back");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":

                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "5":

                    break;

                case "6":

                    break;
                case "7":
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

    public int pizzaSize() {

        System.out.println("8) Small $8.50");
        System.out.println("12) Medium $12.0");
        System.out.println("16) Large $16.50");

        int size = scanner.nextInt();
        scanner.nextLine();

        return size;

    }

    public void meatTopping(int size) {

        System.out.println("what type of meat would you like");
        System.out.println();
        System.out.println("1) pepperoni");
        System.out.println("2) sausage");
        System.out.println("3) ham");
        System.out.println("4) bacon");
        System.out.println("5) chicken");
        System.out.println("6) meatball");
        System.out.println();


    }

    public void cheeseTopping() {
    }

    public void regularTopping() {
    }

    public void sauceTopping() {
    }

    public void sideTopping() {
    }

    public void finishPizza() {
    }

    public void makeDrink() {

        System.out.println("======= Drink sizes ======");

        System.out.println("Small");
        System.out.println("Medium");
        System.out.println("Large");

        System.out.print("enter the size of your drink: ");
        String size = scanner.nextLine();

        System.out.println("enter the flavor of your drink: ");
        String flavor = scanner.nextLine();

        Drink drink = new Drink(size, flavor);
        order.addItem(drink);
    }

    public void makeGarlicKnot() {
        System.out.println("enter the flavor of your drink: ");
        String flavor = scanner.nextLine();

        GarlicKnots knots = new GarlicKnots(flavor);
        order.addItem(knots);
    }

    public void checkOut() {
    }

    public void cancelOrder() {
    }

}
