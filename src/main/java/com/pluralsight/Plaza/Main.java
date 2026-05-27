package com.pluralsight.Plaza;

import com.pluralsight.Plaza.Pizzeria.ui.UserInterface;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean quit = false;
        while (!quit) {
            System.out.println("where would you like to place an order at today?");
            System.out.println();
            System.out.println("1) Ricky's Pizzeria");
            System.out.println("0) to quit");
            System.out.print("Enter your choice: ");
            System.out.println();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    UserInterface ui = new UserInterface();
                    ui.display();
                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "0":
                    quit = true;
                    break;
                default:
                    System.out.println("that's not a real place here");
            }
        }
        scanner.close();
    }
}
