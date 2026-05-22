package com.pluralsight.Plaza.Pizzeria.toppings;

public class SouceTopping extends Topping{

    public SouceTopping(String option) {
        super(option);
    }

    @Override
    public int getPrice(int size) {
        return 0;
    }
}
