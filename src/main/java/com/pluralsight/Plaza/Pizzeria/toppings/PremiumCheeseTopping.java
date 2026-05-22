package com.pluralsight.Plaza.Pizzeria.toppings;

public class PremiumCheeseTopping extends PremiumTopping {

    public PremiumCheeseTopping(String option, boolean isExtra) {
        super(option, isExtra);
    }


    @Override
    public double getPrice(int size) {

        if (size == 8) {
            return .75;
        } else if (size == 12) {
            return 1.50;
        } else if (size == 16) {
            return 2.25;
        } else return 0;
    }
}
