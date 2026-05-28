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
        StringBuilder builder = new StringBuilder();

        builder.append("---- Garlic Knots ----\n");
        builder.append("flavor  : " + flavor + "\n");
        builder.append("---- Garlic Knots Price ----\n");
        builder.append("price: $" + String.format("%.2f", getPrice()) + "\n");

        return builder.toString();
    }
}
