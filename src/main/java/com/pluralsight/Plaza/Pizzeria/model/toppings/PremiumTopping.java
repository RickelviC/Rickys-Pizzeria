package com.pluralsight.Plaza.Pizzeria.model.toppings;

public abstract class PremiumTopping extends Topping{
    private boolean isExtra;

    public PremiumTopping(String option, boolean isExtra) {
        super(option);
        this.isExtra = isExtra;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public void setExtra(boolean extra) {
        isExtra = extra;
    }

    @Override
    public double getPrice(int size) {
        return 0;
    }
}
