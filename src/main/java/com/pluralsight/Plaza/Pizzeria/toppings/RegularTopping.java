package com.pluralsight.Plaza.Pizzeria.toppings;

public class RegularTopping extends Topping {

    public RegularTopping(String option) {
        super(option);
    }

    @Override
    public double getPrice(int size) {
        return 0;
    }
}
