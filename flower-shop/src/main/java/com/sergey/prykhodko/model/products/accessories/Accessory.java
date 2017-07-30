package com.sergey.prykhodko.model.products.accessories;

public abstract class Accessory {
    public int price;

    public Accessory(int price){
        this.price =price;
    }

    public int getPrice() {
        return this.price;
    }
}
