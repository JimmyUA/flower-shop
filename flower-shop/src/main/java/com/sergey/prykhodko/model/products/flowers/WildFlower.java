package com.sergey.prykhodko.model.products;

public class WildFlower extends Flower {
    private WildFlowersTypes type;

    public WildFlower(WildFlowersTypes type, String color) {
        this.type = type;
        super.color = color;
    }

    public int price(){
        return this.type.getPrice();
    }


}
