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
        return 0;
    }
}
