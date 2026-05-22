package com.pluralsight.Plaza.Pizzeria.toppings;

public class Sauce extends Topping{

    public Sauce(String option) {
        super(option);
    }

    @Override
    public double getPrice(int size) {
        return 0;
    }
}
