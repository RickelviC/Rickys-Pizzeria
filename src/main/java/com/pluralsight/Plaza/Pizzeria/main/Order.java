package com.pluralsight.Plaza.Pizzeria.main;

import com.pluralsight.Plaza.Pizzeria.products.IPriceable;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int Id;
    private List<IPriceable> item;

    public Order(int id) {
        Id = id;
        this.item = new ArrayList<>();
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public List<IPriceable> getItem() {
        return item;
    }

    public void setItem(List<IPriceable> item) {
        this.item = item;
    }
}
