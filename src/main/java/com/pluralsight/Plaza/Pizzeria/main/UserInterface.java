package com.pluralsight.Plaza.Pizzeria.main;

import com.pluralsight.Plaza.Pizzeria.products.Drink;

import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private Order order;

    public UserInterface() {
        scanner = new Scanner(System.in);
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
                case "5":
                    cancelOrder();
                    break;
                case "6":
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

    public void makePizza() {

    }

    public Drink makeDrink() {

        System.out.println("======= Drink sizes ======");

        System.out.println("Small");
        System.out.println("Medium");
        System.out.println("Large");


        System.out.print("enter the size of your drink: ");
        String size = scanner.nextLine();

        System.out.println("enter the flavor of your drink: ");
        String flavor = scanner.nextLine();

        return new Drink(size,flavor);
    }

    public void makeGarlicKnot() {
    }

    public void checkOut() {
    }

    public void cancelOrder() {
    }



}
