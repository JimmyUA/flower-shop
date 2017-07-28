package com.sergey.prykhodko.model;

import java.util.List;

public abstract class Bouquet<T extends Flower> {
    private List<Flower> flowers;
    private List<Accessory> accessories;
    private int cost;

    public void addFlower(T flower){
        flowers.add(flower);
        cost += flower.getPrice();
    }

    public void addAccessory(Accessory accessory){
        accessories.add(accessory);
        cost += accessory.getPrice();

    }

    public int totalCost(){
        return cost;
    }
}
