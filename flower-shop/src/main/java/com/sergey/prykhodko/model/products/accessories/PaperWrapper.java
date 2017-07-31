package com.sergey.prykhodko.model.products.accessories;

public class PaperWrapper extends Wrapper{
    public PaperWrapper() {
        super(5);
    }

    @Override
    public String toString() {
        return "" + getClass().getSimpleName() + " | price " + price ;
    }
}
