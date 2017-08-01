package com.sergey.prykhodko.model.products.flowers;

import sun.util.calendar.BaseCalendar;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
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
