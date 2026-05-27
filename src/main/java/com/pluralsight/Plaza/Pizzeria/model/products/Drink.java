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

        StringBuilder builder = new StringBuilder();

        builder.append("---- Drink ----\n");
        builder.append("size    : " + size + "\n");
        builder.append("flavor  : " + flavor + "\n");

        return builder.toString();
    }
}
