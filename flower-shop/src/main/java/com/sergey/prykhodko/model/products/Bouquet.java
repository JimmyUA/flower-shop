package com.sergey.prykhodko.model.products;

import com.sergey.prykhodko.model.products.accessories.Accessory;
import com.sergey.prykhodko.model.products.flowers.Flower;
import com.sergey.prykhodko.model.products.flowers.WildFlower;

import java.util.ArrayList;
import java.util.List;

public class Bouquet<T extends Flower> {
    private List<Flower> flowers;
    private List<Accessory> accessories;
    private int cost;

    public Bouquet() {
        flowers = new ArrayList<Flower>();
        accessories = new ArrayList<Accessory>();
    }

    public void addFlower(T flower){
        flowers.add(flower);
        cost += flower.price();
    }

    public void addAccessory(Accessory accessory){
        accessories.add(accessory);
        cost += accessory.getPrice();

    }

    public int totalCost(){
        return cost;
    }

    @Override
    public String toString() {
        return "" + getClass().getSimpleName() + " | total cost " + cost/100.0 ;
    }
}
