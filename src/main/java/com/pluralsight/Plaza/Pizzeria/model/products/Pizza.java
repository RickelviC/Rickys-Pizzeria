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

    public Pizza(List<Topping> toppings, int size, boolean stuffed, String crustType) {
        this.name = "custom";
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
        StringBuilder builder = new StringBuilder();
        builder.append("---- " + name + " Pizza ----\n");
        builder.append(String.format(" size     : %d\n", size));
        builder.append(String.format("crust type: %s\n", crustType));
        builder.append(String.format("stuffed   : %s\n", stuffed ? "Yes" : "No"));
        builder.append("  toppings   :\n");

        if (toppings.isEmpty()) {
            builder.append(" - none\n");
        } else {
            for (Topping topping : toppings) {
                builder.append(" - ").append(topping).append("\n");
            }
        }

        builder.append("---- Pizza Price ----\n");
        builder.append("price: $" + String.format("%.2f", getPrice()) + "\n");

        return builder.toString();
    }
}
