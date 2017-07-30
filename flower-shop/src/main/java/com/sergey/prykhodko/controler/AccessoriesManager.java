package com.sergey.prykhodko.controler;

import com.sergey.prykhodko.model.products.Bouquet;
import com.sergey.prykhodko.model.products.accessories.Accessory;
import com.sergey.prykhodko.model.products.flowers.Flower;

public class AccessoriesManager {

    public void addAccessoryToBouquet(Bouquet<? extends Flower> bouquet, Accessory accessory){
        bouquet.addAccessory(accessory);
    }
}
