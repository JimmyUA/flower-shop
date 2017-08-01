package com.sergey.prykhodko.model.stock;

import com.sergey.prykhodko.model.products.Bouquet;
import com.sergey.prykhodko.model.products.flowers.DecorativeFlower;
import com.sergey.prykhodko.model.products.flowers.Flower;
import com.sergey.prykhodko.model.products.flowers.WildFlower;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for storing flowers and bouquets
 */
public class Stock {
    private List<WildFlower> wildFlowers;
    private List<DecorativeFlower> decorativeFlowers;
    private List<Bouquet<Flower>> bouquets;


    public Stock() {
        wildFlowers = new ArrayList<WildFlower>();
        decorativeFlowers = new ArrayList<DecorativeFlower>();
        bouquets = new ArrayList<Bouquet<Flower>>();
    }


    public void setWildFlowers(List<WildFlower> wildFlowers) {
        this.wildFlowers = wildFlowers;
    }

    public void setDecorativeFlowers(List<DecorativeFlower> decorativeFlowers) {
        this.decorativeFlowers = decorativeFlowers;
    }
    
    public void storeWildFlower(WildFlower flower){
        wildFlowers.add(flower);
    }

    public void storeDecorativeFlower(DecorativeFlower flower){
        decorativeFlowers.add(flower);
    }

    public void storeBouquet(Bouquet bouquet){
        bouquets.add(bouquet);
    }

    public List<WildFlower> getWildFlowers() {
        return wildFlowers;
    }

    public List<DecorativeFlower> getDecorativeFlowers() {
        return decorativeFlowers;
    }

    public List<Bouquet<Flower>> getBouquets() {
        return bouquets;
    }

}
