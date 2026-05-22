package com.pluralsight.Plaza.Pizzeria.toppings;

public class PremiumMeatTopping extends PremiumTopping{
    public PremiumMeatTopping(String option, boolean isExtra) {
        super(option, isExtra);
    }

    @Override
    public double getPrice(int size) {
        if (size == 8) {
            return 1.0;
        } else if (size == 12) {
            return 2.0;
        } else if (size == 16) {
            return 3.0;
        } else return 0;
    }
}
