package com.sergey.prykhodko.model.products.flowers;

/**
 * Enum represanting types of decorative flowers and contains data, such as price and stem length
 * accordingly to the flower type
 */

public enum DecorativeFlowersTypes {
    ROSE(400, 500), LILY(350, 300), TULIP(200, 200),  CHRYSANTHEMUM(220, 250), IRIS(240, 300);

    private int price;
    private int stemLength;

    DecorativeFlowersTypes(int price, int stemLength) {
        this.price = price;
        this.stemLength = stemLength;
    }

    public int getPrice(){
        return this.price;
    }

    public int getStemLength() {
        return stemLength;
    }
}
