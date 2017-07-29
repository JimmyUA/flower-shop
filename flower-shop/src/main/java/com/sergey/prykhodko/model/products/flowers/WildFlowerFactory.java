package com.sergey.prykhodko.model.products.flowers;

public class WildFlowerFactory implements FlowerFactory {
    @Override
    public WildFlower createFlower(String type, String color) throws IllegalArgumentException{
        switch (type.toLowerCase()){
            case "chamomile":
                return new WildFlower(WildFlowersTypes.CHAMOMILE, color);
            case "sunflower":
                return new WildFlower(WildFlowersTypes.SUNFLOWER, color);
            case "orchid":
                return new WildFlower(WildFlowersTypes.ORCHID, color);
            case "forgetmonotflower":
                return new WildFlower(WildFlowersTypes.FORGETMENOTFLOWER, color);
            case "cornflower":
                return new WildFlower(WildFlowersTypes.CORNFLOWER, color);
            default:
                throw new IllegalArgumentException("No such flower type found");
        }
    }
}
