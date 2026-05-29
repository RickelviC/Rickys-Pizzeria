package com.pluralsight.Plaza.Pizzeria.model.products;

import com.pluralsight.Plaza.Pizzeria.interfaces.IPriceable;
import com.pluralsight.Plaza.Pizzeria.model.toppings.Topping;

import java.util.List;

public class Pizza implements IPriceable {
    private String name;
    private List<Topping> toppings;
    private int size;
    private boolean stuffed;
    private String crustType;

    public Pizza(List<Topping> toppings, int size, boolean stuffed, String crustType, String name) {
        this.name = name;
        this.toppings = toppings;
        this.size = size;
        this.stuffed = stuffed;
        this.crustType = crustType;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isStuffed() {
        return stuffed;
    }

    public void setStuffed(boolean stuffed) {
        this.stuffed = stuffed;
    }

    public String getCrustType() {
        return crustType;
    }

    public void setCrustType(String crustType) {
        this.crustType = crustType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void AddTopping(Topping topping) {
        toppings.add(topping);
    }

    /*
     * over the getPrice() method from IPriceable to do
     * the match behind the size of the pizza and all the toppings chosen
     */

    @Override
    public double getPrice() {
        if (size == 8) {
            double price = 8.50;
            for (Topping topping : toppings) {
                price += topping.getPrice(size);
            }
            return price;

        } else if (size == 12) {
            double price = 12.0;
            for (Topping topping : toppings) {
                price += topping.getPrice(size);
            }
            return price;

        } else if (size == 16) {
            double price = 16.50;
            for (Topping topping : toppings) {
                price += topping.getPrice(size);
            }
            return price;

        } else return 0;
    }

    @Override
    public String toString() {
        final String BOLD = "\u001B[1m";
        final String RESET = "\u001B[0m";
        final String RED = "\u001B[31m";
        final String GREEN = "\u001B[32m";
        final String CYAN = "\u001B[36m";
        final String YELLOW = "\u001B[33m";

        StringBuilder builder = new StringBuilder();


        builder.append(CYAN + BOLD + "\n=============== " + name + " Pizza ===============\n");
        builder.append(String.format(YELLOW + " size      :" + GREEN + " %d inch\n", size));
        builder.append(String.format(YELLOW + " crust type: " + GREEN + "%s\n", crustType));
        builder.append(String.format(YELLOW + " stuffed   : %s\n", stuffed ? GREEN + "Yes" : RED + "No"));

        builder.append(YELLOW + " toppings  :\n" + RESET);

        if (toppings.isEmpty()) {
            builder.append(RED + "            - none\n");
        } else {
            for (Topping topping : toppings) {
                builder.append("            - " + GREEN).append(topping).append("\n" + RESET);
            }
        }

        builder.append(CYAN + BOLD + "\n=============== Price ===============\n" + RESET);
        builder.append(RED + "price: $" + String.format("%.2f", getPrice()) + RESET);

        return builder.toString();
    }
}
