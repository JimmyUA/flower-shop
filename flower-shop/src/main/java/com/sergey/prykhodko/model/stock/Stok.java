package com.sergey.prykhodko.model.stock;

import com.sergey.prykhodko.model.products.Accessory;
import com.sergey.prykhodko.model.products.Bouquet;
import com.sergey.prykhodko.model.products.flowers.Flower;

import java.util.ArrayList;
import java.util.List;

public class Stok {
    private List<Flower> flowers;
    private List<Bouquet> bouquets;
    private List<Accessory> accessories;

    public Stok() {
        flowers = new ArrayList<Flower>();
        bouquets = new ArrayList<Bouquet>();
        accessories = new ArrayList<Accessory>();
    }




    public void storeFlower(Flower flower){
        flowers.add(flower);
    }

    public void storeBouquet(Bouquet bouquet){
        bouquets.add(bouquet);
    }

    public void storeAccessory(Accessory accessory){
        accessories.add(accessory);
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

    public List<Bouquet> getBouquets() {
        return bouquets;
    }

    public List<Accessory> getAccessories() {
        return accessories;
    }
}
