package com.sergey.prykhodko.controler;

import com.sergey.prykhodko.model.products.Accessory;
import com.sergey.prykhodko.model.products.Bouquet;
import com.sergey.prykhodko.model.products.flowers.Flower;
import com.sergey.prykhodko.model.stock.Stock;

import java.util.List;

public class ConsolePrinter {
    public void showFlower(Flower flower){

    }

    public void notifySavingStockToFile() {
        System.out.println("Stock state was stored!");
    }

    public void showStock(Stock stock) {
        StringBuilder stockRepresantation = new StringBuilder();
        stockRepresantation.append("///////////////////////////////////FLOWERS//////////////////////////////////\n");
        List<Flower> flowers = stock.getFlowers();
        if (flowers.isEmpty()){
            stockRepresantation.append("                                    EMPTY                                     \n");
        }
        else {
            for (Flower flower : stock.getFlowers()
                    ) {
                stockRepresantation.append(flower.toString() + "\n");
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
                stockRepresantation.append(bouquet.toString() + "\n");
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
                stockRepresantation.append(accessory.toString() + "\n");
            }
        }
        stockRepresantation.append("////////////////////////////////////////////////////////////////////////////");

        System.out.println(stockRepresantation);
    }

    public void askFlowerClass() {
        System.out.println("What flower type do you want to create?\nPossible vriants are:\n" +
                "- wild\n-decorative");   //"- rose\n- lilly\n- tulip\nchrisanthemum\n-"

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
}
