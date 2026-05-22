package com.pluralsight.Plaza.Pizzeria.toppings;

public class PremiumCheeseTopping extends PremiumTopping{

    public PremiumCheeseTopping(String option, boolean isExtra) {
        super(option, isExtra);
    }

    @Override
    public int getPrice(int size) {
        return 1;
    }
}
