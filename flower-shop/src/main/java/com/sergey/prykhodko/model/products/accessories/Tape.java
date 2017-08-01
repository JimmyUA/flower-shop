package com.sergey.prykhodko.model.products.accessories;

public class Tape extends Accessory{
    public Tape() {
        super(20);
    }

    @Override
    public String toString() {
        return "" + getClass().getSimpleName() + " | price " + price/100.0 ;
    }
}
