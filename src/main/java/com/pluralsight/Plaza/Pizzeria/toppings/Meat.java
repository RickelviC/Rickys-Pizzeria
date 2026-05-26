package com.pluralsight.Plaza.Pizzeria.toppings;

public class Meat extends PremiumTopping{
    public Meat(String option, boolean isExtra) {
        super(option, isExtra);
    }

    @Override
    public double getPrice(int size) {
        double price;
        if (size == 8) {
            price = 1.0;
            if (isExtra()){
                 price += .50;
            }
            return price;
        } else if (size == 12) {
            price = 2.0;
            if (isExtra()){
                price += 1;
            }
            return price;
        } else if (size == 16) {
            price = 3.0;
            if (isExtra()){
                price += 1.50;
            }
            return price;
        } else return 0;
    }
}
