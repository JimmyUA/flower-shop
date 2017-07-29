package com.sergey.prykhodko.model.products.flowers;

import java.time.LocalDateTime;

public class DecorativeFlower extends Flower {
    private DecorativeFlowersTypes type;

    public DecorativeFlower(DecorativeFlowersTypes type, String color) {
        this.type = type;
        super.color = color;
        super.dateOfCuttingDown = LocalDateTime.now().minusDays(1);
    }

    public int price(){
        return this.type.getPrice();
    }

    public int stemLength(){
        return this.type.getStemLength();
    }

}
