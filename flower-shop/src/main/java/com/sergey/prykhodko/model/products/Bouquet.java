package com.sergey.prykhodko.model.products;

import com.sergey.prykhodko.model.products.accessories.Accessory;
import com.sergey.prykhodko.model.products.flowers.Flower;
import com.sergey.prykhodko.model.products.flowers.WildFlower;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Bouquet<T extends Flower> {
    private List<Flower> flowers;
    private List<Accessory> accessories;
    private int cost;

    public Bouquet() {
        flowers = new ArrayList<Flower>();
        accessories = new ArrayList<Accessory>();
    }

    public void addFlower(T flower){
        flowers.add(flower);
        cost += flower.price();
    }

    public void addAccessory(Accessory accessory){
        accessories.add(accessory);
        cost += accessory.getPrice();

    }

    public List<Accessory> getAccessories() {
        return accessories;
    }

    public void setAccessories(List<Accessory> accessories) {
        this.accessories = accessories;
    }

    public List<Flower> getFlowers() {

        return flowers;
    }

    public int totalCost(){
        return cost;
    }

    @Override
    public String toString() {
        return "" + getClass().getSimpleName() + " | total cost " + cost/100.0 ;
    }


    public void sortByFreshness() {
        Collections.sort(flowers, new Comparator<Flower>() {
            @Override
            public int compare(Flower o1, Flower o2) {
                return o1.getDateOfCuttingDown().compareTo(o2.getDateOfCuttingDown());
            }
        });
    }
}
