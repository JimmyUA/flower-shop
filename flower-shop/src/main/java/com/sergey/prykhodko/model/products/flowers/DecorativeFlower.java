package com.sergey.prykhodko.model.products.flowers;

public class DecorativeFlower extends Flower {
    private DecorativeFlowersTypes type;

    public DecorativeFlower(DecorativeFlowersTypes type, String color) {
        this.type = type;
        super.color = color;
    }

    public int price(){
        return this.type.getPrice();
    }

    public int stemLength(){
        return this.type.getStemLength();
    }

}
