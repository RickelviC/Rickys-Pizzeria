package com.pluralsight.Plaza.Pizzeria.main;

import com.pluralsight.Plaza.Pizzeria.products.IPriceable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {
    private UUID Id;
    private List<IPriceable> items;

    public Order(UUID id) {
        Id = id;
        this.items = new ArrayList<>();
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
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

    public void removeItem(IPriceable item){
        items.remove(item);
    }

    public double getTotalPrice(){
        double totalPrice = 0;

        for (IPriceable price : items) {
            totalPrice += price.getPrice();
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Id: " + Id + " | items: " + items;
    }
}
