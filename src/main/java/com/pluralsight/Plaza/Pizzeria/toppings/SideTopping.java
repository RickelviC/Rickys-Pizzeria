package com.pluralsight.Plaza.Pizzeria.toppings;

public class SideTopping extends Topping{
    public SideTopping(String option) {
        super(option);
    }

    @Override
    public double getPrice(int size) {
        return 0;
    }
}
