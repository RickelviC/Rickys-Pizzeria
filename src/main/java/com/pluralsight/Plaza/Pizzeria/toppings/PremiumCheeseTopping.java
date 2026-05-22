package com.pluralsight.Plaza.Pizzeria.toppings;

public class PremiumCheeseTopping extends PremiumTopping {

    public PremiumCheeseTopping(String option, boolean isExtra) {
        super(option, isExtra);
    }


    @Override
    public double getPrice(int size) {

        if (size == 8) {
            return .75;
        }
        return 1;
    }
}
