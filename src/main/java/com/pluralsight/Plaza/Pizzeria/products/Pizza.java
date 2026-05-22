package com.pluralsight.Plaza.Pizzeria.products;

import com.pluralsight.Plaza.Pizzeria.toppings.Topping;

import java.util.List;

public class Pizza implements IPriceable{
    private List<Topping> toppings;
    private int size;
    private boolean stuffed;
    private String crustType;

    @Override
    public double getPrice() {
        if (size == 8) {
            return 8.50;
        } else if (size == 12) {
            return 12.0;
        } else if (size == 16) {
            return 16.50;
        } else return 0;
    }
}
