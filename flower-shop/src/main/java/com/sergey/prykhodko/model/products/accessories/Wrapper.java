package com.sergey.prykhodko.model.products.accessories;

public abstract class Wrapper extends Accessory{

    public Wrapper(int price){
        super(price);
    }
    public int getPrice() {
        return super.price;
    }
}
