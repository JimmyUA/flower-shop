package com.sergey.prykhodko.controler;

import com.sergey.prykhodko.model.products.Accessory;
import com.sergey.prykhodko.model.products.Bouquet;
import com.sergey.prykhodko.model.products.flowers.Flower;
import com.sergey.prykhodko.model.stock.Stok;

import java.util.List;

public class ConsolePrinter {
    public void showFlower(Flower flower){

    }

    public void notifySavingStokToFile() {
        System.out.println("Stok state was stored!");
    }

    public void showStok(Stok stok) {
        StringBuilder stokRepresantation = new StringBuilder();
        stokRepresantation.append("///////////////////////////////////FLOWERS//////////////////////////////////\n");
        List<Flower> flowers = stok.getFlowers();
        if (flowers.isEmpty()){
            stokRepresantation.append("                               EMPTY                                     \n");
        }
        else {
            for (Flower flower : stok.getFlowers()
                    ) {
                stokRepresantation.append(flower.toString() + "\n");
            }
        }
        List<Bouquet> bouquets = stok.getBouquets();
        if(bouquets.isEmpty()){
            stokRepresantation.append("                               EMPTY                                     \n");
        }
        else {
            for (Bouquet bouquet : bouquets
                    ) {
                stokRepresantation.append(bouquet.toString() + "\n");
            }
        }
        List<Accessory> accessories = stok.getAccessories();
        if(accessories.isEmpty()){
            stokRepresantation.append("                               EMPTY                                     \n");
        }
        else {
            for (Accessory accessory : stok.getAccessories()
                    ) {
                stokRepresantation.append(accessory.toString() + "\n");
            }
        }
        stokRepresantation.append("////////////////////////////////////////////////////////////////////////////");

        System.out.println(stokRepresantation);
    }

    public void askFlowerClass() {
        System.out.println("What flower do you want to create?\nPossible vriants are:\n");   //"- rose\n- lilly\n- tulip\nchrisanthemum\n-"

    }

    public void askFlowerTypeAndColor() {
        System.out.println("What flower type do you want to create?\nPossible vriants are:\n");
    }

    public void notifySavingFlowerToStok(Flower flower) {
        System.out.println(flower.toString() + " were put to stok\n");
    }
}
