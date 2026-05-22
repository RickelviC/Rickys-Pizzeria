package com.pluralsight.Plaza.Pizzeria.toppings;

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
    public int getPrice(int size) {
        return 0;
    }
}
