package com.pluralsight.Plaza.Pizzeria.main;

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
                    makePizza();
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

    public void makePizza() {
    }

    public void makeDrink() {
    }

    public void makeGarlicKnot() {
    }

    public void checkOut() {
    }

    public void cancelOrder() {
    }

}
