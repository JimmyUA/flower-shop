package com.sergey.prykhodko.model.products.flowers;

import java.time.LocalDateTime;

public class DecorativeFlower extends Flower {
    private DecorativeFlowersTypes type;

    public DecorativeFlower(DecorativeFlowersTypes type, String color) {
        this.type = type;
        super.color = color;
        super.dateOfCuttingDown = LocalDateTime.now().minusDays(1);
        super.stemLength = type.getStemLength();
    }

    public int price(){
        return this.type.getPrice();
    }

    public int stemLength(){
        return this.type.getStemLength();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+ " " + super.color + " " + type + " | stem length " +
                type.getStemLength() + " | price " + type.getPrice()/100.0 + "\nWere cut down: "
                + dateOfCuttingDown.getMonth() + " " + dateOfCuttingDown.getDayOfMonth() +
                " " + dateOfCuttingDown.getHour() + ":" + dateOfCuttingDown.getMinute();
    }
}
