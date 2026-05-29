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

        builder.append( "\n=============== Garlic Knots " + flavor + " ===============\n");
        builder.append( " Flavor      :" + flavor + "\n");
        builder.append( "\n=============== Price ===============\n" );
        builder.append( "price: $" + String.format("%.2f", getPrice()) );

        return builder.toString();
    }
}
