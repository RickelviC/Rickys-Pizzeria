package com.pluralsight.Plaza;

import com.pluralsight.Plaza.Pizzeria.ui.UserInterface;

import java.util.Scanner;

public class Main {

    private static final String BOLD = "\u001B[1m";
    public static final String RESET = "\u001B[0m";
    public static final String CYAN = "\u001B[36m";
    private static final String YELLOW = "\u001B[33m";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean quit = false;
        while (!quit) {

            System.out.println(CYAN + BOLD + "======== Ricky's Pizzeria =======" + RESET);
            System.out.println(YELLOW + "1) " + RESET + CYAN + "Enter Ricky's Pizzeria");
            System.out.println(YELLOW + "0) " + RESET + CYAN + "Leave");
            System.out.println(CYAN + BOLD + "=====================================" + RESET);

            System.out.print(YELLOW + "→ Enter your Choice: " + RESET);
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    UserInterface ui = new UserInterface();
                    ui.display();
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
