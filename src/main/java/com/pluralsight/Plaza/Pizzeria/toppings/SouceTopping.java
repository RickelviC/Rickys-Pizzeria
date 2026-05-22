package com.pluralsight.Plaza.Pizzeria.toppings;

public class SouceTopping extends Topping{

    public SouceTopping(String option) {
        super(option);
    }

    @Override
    public double getPrice(int size) {
        return 0;
    }
}
