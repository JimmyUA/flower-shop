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

    public abstract int price();


}
