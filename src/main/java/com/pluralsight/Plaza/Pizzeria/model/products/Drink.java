package com.pluralsight.Plaza.Pizzeria.model.products;

import com.pluralsight.Plaza.Pizzeria.interfaces.IPriceable;

public class Drink implements IPriceable {
    private String size;
    private String flavor;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public double getPrice() {

        if (size.equalsIgnoreCase("small")) {
            return 2.0;
        } else if (size.equalsIgnoreCase("medium")) {
            return 2.50;
        } else if (size.equalsIgnoreCase("large")) {
            return 3.0;
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
        builder.append(CYAN + BOLD + "\n=============== Drink " + flavor + " ===============\n");
        builder.append(YELLOW + " Size      :" + GREEN + size + "\n");
        builder.append(YELLOW + " Flavor      :" + GREEN + flavor + "\n");
        builder.append(CYAN + BOLD + "\n=============== Price ===============\n" + RESET);
        builder.append(RED + "price: $" + String.format("%.2f", getPrice()) + RESET);

        return builder.toString();
    }
}
