package com.pluralsight.Plaza.Pizzeria.main;

import com.pluralsight.Plaza.Pizzeria.products.IPriceable;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int Id;
    private List<IPriceable> items;

    public Order(int id) {
        Id = id;
        this.items = new ArrayList<>();
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public List<IPriceable> getItems() {
        return items;
    }

    public void setItems(List<IPriceable> items) {
        this.items = items;
    }

    public void addItem(IPriceable item){
        items.add(item);
    }

    public double getTotalPrice(){
        double totalPrice = 0;

        for (IPriceable price : items) {
            totalPrice += price.getPrice();
        }
        return totalPrice;
    }
}
