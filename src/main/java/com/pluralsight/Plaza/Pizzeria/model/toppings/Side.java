package com.pluralsight.Plaza.Pizzeria.model.toppings;

public class Side extends Topping{
    public Side(String option) {
        super(option);
    }

    @Override
    public double getPrice(int size) {
        return 0;
    }
}
