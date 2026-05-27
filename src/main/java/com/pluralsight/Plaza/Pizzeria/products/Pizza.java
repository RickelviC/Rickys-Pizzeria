package com.pluralsight.Plaza.Pizzeria.products;

import com.pluralsight.Plaza.Pizzeria.toppings.Topping;

import java.util.List;

public class Pizza implements IPriceable{
    private List<Topping> toppings;
    private int size;
    private boolean stuffed;
    private String crustType;

    public Pizza(List<Topping> toppings, int size, boolean stuffed, String crustType) {
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

    public void AddTopping(Topping topping){
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
        return "Pizza | toppings: \n" + toppings +
                "| size: " + size +
                "| stuffed: " + stuffed +
                "| crustType: " + crustType;
    }
}
