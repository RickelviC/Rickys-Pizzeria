package com.pluralsight.Plaza.Pizzeria.model.toppings;

public class Cheese extends PremiumTopping {

    public Cheese(String option, boolean isExtra) {
        super(option, isExtra);
    }


    @Override
    public double getPrice(int size) {
        double price;
        if (size == 8) {
            price = .75;
            if (isExtra()) {
                price += .30;
            }
            return price;

        } else if (size == 12) {
            price = 1.50;
            if (isExtra()) {
                price += .60;
            }
            return price;

        } else if (size == 16) {
            price = 2.25;
            if (isExtra()) {
                price += .90;
            }
            return price;

        } else return 0;
    }
}
