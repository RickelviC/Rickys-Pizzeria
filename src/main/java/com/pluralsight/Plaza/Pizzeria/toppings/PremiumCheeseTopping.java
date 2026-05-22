package com.pluralsight.Plaza.Pizzeria.toppings;

public class PremiumCheeseTopping extends PremiumTopping{
    private String option;

    public PremiumCheeseTopping(String option, boolean isExtra) {
        super(option, isExtra);
    }

    public PremiumCheeseTopping(String option, boolean isExtra, String option1) {
        super(option, isExtra);
        this.option = option1;
    }

    @Override
    public double getPrice(int size) {

        if (size == 8){
            return .75;
        }
        return 1;
    }
}
