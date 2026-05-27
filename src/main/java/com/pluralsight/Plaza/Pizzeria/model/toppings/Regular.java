package com.pluralsight.Plaza.Pizzeria.model.toppings;

public class Regular extends Topping {

    public Regular(String option) {
        super(option);
    }

    @Override
    public double getPrice(int size) {
        return 0;
    }
}
