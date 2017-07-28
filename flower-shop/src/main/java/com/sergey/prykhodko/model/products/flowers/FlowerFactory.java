package com.sergey.prykhodko.model.products.flowers;

public interface FlowerFactory {
    public Flower createFlower(String type, String color);
}
