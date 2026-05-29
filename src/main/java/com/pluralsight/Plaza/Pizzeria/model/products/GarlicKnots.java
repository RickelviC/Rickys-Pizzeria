package com.pluralsight.Plaza.Pizzeria.model.products;

import com.pluralsight.Plaza.Pizzeria.interfaces.IPriceable;

public class GarlicKnots implements IPriceable {
    private String flavor;

    public GarlicKnots(String flavor) {
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public double getPrice() {
        return 1.50;
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

        builder.append(CYAN + BOLD + "\n=============== Garlic Knots " + flavor + " ===============\n");
        builder.append(YELLOW + " Flavor      :" + GREEN + flavor + "\n");
        builder.append(CYAN + BOLD + "\n=============== Price ===============\n" + RESET);
        builder.append(RED + "price: $" + String.format("%.2f", getPrice()) + RESET);

        return builder.toString();
    }
}
