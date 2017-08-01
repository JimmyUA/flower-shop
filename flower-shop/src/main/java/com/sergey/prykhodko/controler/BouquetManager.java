package com.sergey.prykhodko.controler;

import com.sergey.prykhodko.model.products.Bouquet;
import com.sergey.prykhodko.model.products.flowers.*;


public class BouquetManager {

    public Bouquet<WildFlower> createNewWildFlowersBouquet(WildFlower...flowers){
        Bouquet<WildFlower> createdBouquet = new Bouquet<>();
        for (WildFlower flower : flowers
             ) {
            createdBouquet.addFlower(flower);
        }
        return createdBouquet;
    }

    public Bouquet<DecorativeFlower> createNewDecorativeFlowersBouquet(DecorativeFlower...flowers){
        Bouquet<DecorativeFlower> createdBouquet = new Bouquet<>();
        for (DecorativeFlower flower : flowers
                ) {
            createdBouquet.addFlower(flower);
        }
        return createdBouquet;
    }

    public Bouquet<Flower> createNewMixedFlowersBouquet(Flower...flowers){
        Bouquet<Flower> createdBouquet = new Bouquet<>();
        for (Flower flower : flowers
                ) {
            createdBouquet.addFlower(flower);
        }
        return createdBouquet;
    }


}
