package com.sergey.prykhodko.model.products.flowers;

public class DecorativeFlowerFactory implements FlowerFactory{
    @Override
    public Flower createFlower(String type, String color) throws IllegalArgumentException{
        switch (type.toLowerCase()){
            case "rose":
                return new DecorativeFlower(DecorativeFlowersTypes.ROSE, color);
            case "lilly":
                return new DecorativeFlower(DecorativeFlowersTypes.LILY, color);
            case "tulip":
                return new DecorativeFlower(DecorativeFlowersTypes.TULIP, color);
            case "chrysanthemum":
                return new DecorativeFlower(DecorativeFlowersTypes.CHRYSANTHEMUM, color);
            case "iris":
                return new DecorativeFlower(DecorativeFlowersTypes.IRIS, color);
            default:
                throw new IllegalArgumentException("No such flower type found");
        }
    }
}
