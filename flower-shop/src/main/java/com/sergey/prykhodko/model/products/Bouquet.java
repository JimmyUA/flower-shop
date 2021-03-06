package com.sergey.prykhodko.model.products;

import com.sergey.prykhodko.model.products.accessories.Accessory;
import com.sergey.prykhodko.model.products.flowers.Flower;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Class describes bouquet and contains its elements
 * @param <T>
 */

public class Bouquet<T extends Flower> {
    private List<Flower> flowers;
    private List<Accessory> accessories;
    private int cost;

    public Bouquet() {
        flowers = new ArrayList<>();
        accessories = new ArrayList<>();
    }

    public void setAccessories(List<Accessory> accessories) {
        this.accessories = accessories;
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

    public List<Flower> getFlowers() {

        return flowers;
    }


    public void sortFlowersByFreshness() {
        flowers.sort(new Comparator<Flower>() {
            @Override
            public int compare(Flower o1, Flower o2) {
                return o1.getDateOfCuttingDown().compareTo(o2.getDateOfCuttingDown());
            }
        });
    }

    public List<Flower> getFlowersWithStemInRange(int bottomLimit, int topLimit) {
        List<Flower> flowersWithStemLengthInRange = new ArrayList<>();
        for (Flower flower : flowers
             ) {
            if (flower.getStemLength() >= bottomLimit && flower.getStemLength() <= topLimit){
                flowersWithStemLengthInRange.add(flower);
            }
        }
        return flowersWithStemLengthInRange;
    }

    @Override
    public String toString() {
        return "" + getClass().getSimpleName() + " | total cost " + cost/100.0 ;
    }
}
