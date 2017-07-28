package com.sergey.prykhodko.model.products;

import sun.util.calendar.BaseCalendar;

/**
 *
 */
public abstract class Flower {
    private BaseCalendar.Date dateOfCuttingDown;
    protected String color;

    public abstract int price();

}
