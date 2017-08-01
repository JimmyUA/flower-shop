package com.sergey.prykhodko.model.products.accessories;

public class BowKnot extends Accessory{
    public BowKnot() {
        super(30);
    }

    @Override
    public String toString() {
        return "" + getClass().getSimpleName() + " | price " + price/100.0 ;
    }
}
