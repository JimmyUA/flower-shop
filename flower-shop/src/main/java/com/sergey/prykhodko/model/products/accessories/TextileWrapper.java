package com.sergey.prykhodko.model.products.accessories;

public class TextileWrapper extends Wrapper {

    public TextileWrapper() {
        super(80);
    }

    @Override
    public String toString() {
        return "" + getClass().getSimpleName() + " | price " + price/100.0 ;
    }
}
