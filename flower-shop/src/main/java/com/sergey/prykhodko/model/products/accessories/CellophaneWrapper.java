package com.sergey.prykhodko.model.products.accessories;

public class CellophaneWrapper extends Wrapper{
    public CellophaneWrapper() {
        super(1);
    }

    @Override
    public String toString() {
        return "" + getClass().getSimpleName() + " | price " + price ;
    }
}
