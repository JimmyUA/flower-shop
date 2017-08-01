package com.sergey.prykhodko.model.products.accessories;

public class CellophaneWrapper extends Wrapper{
    public CellophaneWrapper() {
        super(10);
    }

    @Override
    public String toString() {
        return "" + getClass().getSimpleName() + " | price " + price/100.0 ;
    }
}
