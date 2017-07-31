package com.sergey.prykhodko.model.products.accessories;

public class BowKnot extends Accessory{
    public BowKnot() {
        super(3);
    }

    @Override
    public String toString() {
        return "" + getClass().getSimpleName() + " | price " + price ;
    }
}
