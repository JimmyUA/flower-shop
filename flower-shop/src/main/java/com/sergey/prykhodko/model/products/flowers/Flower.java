package com.sergey.prykhodko.model.products.flowers;


import java.time.LocalDateTime;

/**
 * Class describes general flower properties
 */
public abstract class Flower {
    protected LocalDateTime dateOfCuttingDown;
    protected String color;
    protected int stemLength;

    public abstract int price();

    public LocalDateTime getDateOfCuttingDown(){
        return dateOfCuttingDown;
    }

    public int getStemLength() {
        return stemLength;
    }
}
