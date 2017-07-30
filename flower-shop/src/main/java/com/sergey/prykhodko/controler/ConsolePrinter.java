package com.sergey.prykhodko.controler;

import com.sergey.prykhodko.model.products.Accessory;
import com.sergey.prykhodko.model.products.Bouquet;
import com.sergey.prykhodko.model.products.flowers.DecorativeFlower;
import com.sergey.prykhodko.model.products.flowers.Flower;
import com.sergey.prykhodko.model.products.flowers.WildFlower;
import com.sergey.prykhodko.model.stock.Stock;

import java.util.List;

public class ConsolePrinter {
    public void showFlower(Flower flower){

    }

    public void notifySavingStockToFile() {
        System.out.println("Stock state was stored!");
    }

    public void showStock(Stock stock) { //TODO divide for smaller methods
        StringBuilder stockRepresantation = new StringBuilder();
        stockRepresantation.append("///////////////////////////////////FLOWERS//////////////////////////////////\n");
        List<WildFlower> wildFlowers = stock.getWildFlowers();
        List<DecorativeFlower> decorativeFlowers = stock.getDecorativeFlowers();
        if (wildFlowers.isEmpty() && decorativeFlowers.isEmpty()){
            stockRepresantation.append("                                    EMPTY                                     \n");
        }
        else {
            for (Flower flower : wildFlowers
                    ) {
                stockRepresantation.append(flower.toString()).append("\n");
            }
            for (Flower flower : decorativeFlowers
                    ) {
                stockRepresantation.append(flower.toString()).append("\n");
            }

        }
        stockRepresantation.append("///////////////////////////////////BOUQUETS//////////////////////////////////\n");
        List<Bouquet> bouquets = stock.getBouquets();
        if(bouquets.isEmpty()){
            stockRepresantation.append("                                    EMPTY                                     \n");
        }
        else {
            for (Bouquet bouquet : bouquets
                    ) {
                stockRepresantation.append(bouquet.toString()).append("\n");
            }
        }
        stockRepresantation.append("///////////////////////////////////ACCESSORIES//////////////////////////////////\n");
        List<Accessory> accessories = stock.getAccessories();
        if(accessories.isEmpty()){
            stockRepresantation.append("                                    EMPTY                                     \n");
        }
        else {
            for (Accessory accessory : stock.getAccessories()
                    ) {
                stockRepresantation.append(accessory.toString()).append("\n");
            }
        }
        stockRepresantation.append("////////////////////////////////////////////////////////////////////////////");

        System.out.println(stockRepresantation);
    }

    public void askFlowerClass() {
        System.out.println("What flower type do you want to create?\nPossible vriants are:\n" +
                "- wild\n-decorative\n- stop (to stop addition)");   //"- rose\n- lilly\n- tulip\nchrisanthemum\n-"

    }

    public void askFlowerTypeAndColor() {
        System.out.println("What flower do you want to create?\nPossible vriants are:\n");
    }

    public void notifySavingFlowerToStock(Flower flower) {
        System.out.println(flower.toString() + " were put to stock\n");
    }

    public void askBouquetType() {
        System.out.println("What flower type do you want to create?\nPossible vriants are:\n" +
                "- wild\n- decorative\n- mixed");
    }

    public void notifySavingBouquetToStock(Bouquet<? extends Flower> bouquet) {
        System.out.println(bouquet.toString() + " were put to stock\n");
    }
}
