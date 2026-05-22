package com.pluralsight.Plaza.Pizzeria.toppings;

public abstract class Topping {
    private String option;

    public Topping(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }
    public abstract double getPrice(int size);
}
