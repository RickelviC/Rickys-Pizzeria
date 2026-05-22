package com.pluralsight.Plaza.Pizzeria.toppings;

public class SideTopping extends Topping{
    public SideTopping(String option) {
        super(option);
    }

    @Override
    public int getPrice(int size) {
        return 0;
    }
}
