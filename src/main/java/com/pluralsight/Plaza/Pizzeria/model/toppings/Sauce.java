package com.pluralsight.Plaza.Pizzeria.model.toppings;

public class Sauce extends Topping{

    public Sauce(String option) {
        super(option);
    }

    @Override
    public double getPrice(int size) {
        return 0;
    }
}
