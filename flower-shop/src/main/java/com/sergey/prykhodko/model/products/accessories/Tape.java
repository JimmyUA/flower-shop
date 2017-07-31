package com.sergey.prykhodko.model.products.accessories;

public class Tape extends Accessory{
    public Tape() {
        super(2);
    }

    @Override
    public String toString() {
        return "" + getClass().getSimpleName() + " | price " + price ;
    }
}
