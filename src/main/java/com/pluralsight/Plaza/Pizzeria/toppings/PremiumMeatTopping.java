package com.pluralsight.Plaza.Pizzeria.toppings;

public class PremiumMeatTopping extends PremiumTopping{
    public PremiumMeatTopping(String option, boolean isExtra) {
        super(option, isExtra);
    }

    @Override
    public int getPrice(int size) {
        return 1;
    }
}
