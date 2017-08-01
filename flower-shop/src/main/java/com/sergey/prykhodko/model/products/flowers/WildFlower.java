package com.sergey.prykhodko.model.products.flowers;


import java.time.LocalDateTime;


public class WildFlower extends Flower {
    private WildFlowersTypes type;

    public WildFlower(WildFlowersTypes type, String color) {
        this.type = type;
        super.color = color;
        super.dateOfCuttingDown = LocalDateTime.now().minusDays(1);
        super.stemLength = type.getStemLength();
    }

    public int price() {
        return this.type.getPrice();
    }

    public int stemLength() {
        return this.type.getStemLength();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+ " " + super.color + " " + type + " | stem length " +
                type.getStemLength() + " | price " + calculatePriceInUSD() + "\nWere cut down: "
                + dateOfCuttingDown.getMonth() + " " + dateOfCuttingDown.getDayOfMonth() +
                " " + dateOfCuttingDown.getHour() + ":" + dateOfCuttingDown.getMinute();
    }

    private double calculatePriceInUSD() {
        return type.getPrice()/100.0;
    }
}
