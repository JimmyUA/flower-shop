package com.sergey.prykhodko.model.products.flowers;

public enum WildFlowersTypes implements FlowerType{
    CHAMOMILE(100, 400), SUNFLOWER(200, 500), ORCHID(140, 300), FORGETMENOTFLOWER(90, 200), CORNFLOWER(120, 220);
    private int price;
    private int stemLength;

    WildFlowersTypes(int price, int stemLength) {
        this.price = price;
        this.stemLength = stemLength;
    }

    public int getPrice(){
        return this.price;
    }

    public int getStemLength() {
        return stemLength;
    }

    public void setStemLength(int stemLength) {
        this.stemLength = stemLength;
    }
}
