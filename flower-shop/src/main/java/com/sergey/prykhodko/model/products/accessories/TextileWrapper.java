package com.sergey.prykhodko.model.products.accessories;

public class TextileWrapper extends Wrapper {

    public TextileWrapper() {
        super(8);
    }

    @Override
    public String toString() {
        return "" + getClass().getSimpleName() + " | price " + price ;
    }
}
