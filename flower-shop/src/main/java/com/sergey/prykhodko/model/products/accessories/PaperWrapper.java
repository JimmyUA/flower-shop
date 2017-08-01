package com.sergey.prykhodko.model.products.accessories;

public class PaperWrapper extends Wrapper{
    public PaperWrapper() {
        super(50);
    }

    @Override
    public String toString() {
        return "" + getClass().getSimpleName() + " | price " + price/100.0 ;
    }
}
