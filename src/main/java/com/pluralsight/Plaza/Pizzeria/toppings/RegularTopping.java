package com.pluralsight.Plaza.Pizzeria.toppings;

public class RegularTopping extends Topping {

    public RegularTopping(String option) {
        super(option);
    }

    @Override
    public int getPrice(int size) {
        return 0;
    }
}
