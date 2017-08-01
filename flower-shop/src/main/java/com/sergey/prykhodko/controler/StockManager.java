package com.sergey.prykhodko.controler;

import com.sergey.prykhodko.model.products.Bouquet;
import com.sergey.prykhodko.model.products.flowers.DecorativeFlower;
import com.sergey.prykhodko.model.products.flowers.Flower;
import com.sergey.prykhodko.model.products.flowers.WildFlower;
import com.sergey.prykhodko.model.stock.Stock;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class StockManager {
    private StockFeatFileWorker worker;
    Stock stock;
    private File stockStorage;


    StockManager(StockFeatFileWorker worker) throws FileNotFoundException {
        this.worker = worker;
        stockStorage = new File("stock.xml");
        recreateStoredStock();
    }

    // this constructor is used in case first one have thrown exception
    StockManager(StockFeatFileWorker worker, Stock stock) {
        this.worker = worker;
        stockStorage = new File("stock.xml");
        this.stock = stock;
    }

    void setEmptyStock() {
        stock = new Stock();
    }

    void storeStock() throws IOException {
        worker.storeStockToFile(stock, stockStorage);
    }

    void recreateStoredStock() throws FileNotFoundException {
        stock = worker.getStockFromFile(stockStorage);

    }


    void putDecorativeFlowerToStock(DecorativeFlower flower){
        stock.storeDecorativeFlower(flower);
    }

    void putWildFlowerToStock(WildFlower flower){
        stock.storeWildFlower(flower);
    }


    Stock getStock() {
        return stock;
    }


    WildFlower[] getAllWildFlowersFromStok() {
        List<WildFlower> wildFlowerList = stock.getWildFlowers();
        WildFlower[] wildFlowers = new WildFlower[wildFlowerList.size()];
        wildFlowerList.toArray(wildFlowers);

        return wildFlowers;
    }

    DecorativeFlower[] getAllDecorativeFlowersFromStok() {
        List<DecorativeFlower> decorativeFlowerList = stock.getDecorativeFlowers();
        DecorativeFlower[] decorativeFlowers = new DecorativeFlower[decorativeFlowerList.size()];
        decorativeFlowerList.toArray(decorativeFlowers);

        return decorativeFlowers;
    }

    Flower[] getAllFlowersFromStok() {
        List<DecorativeFlower> decorativeFlowerList = stock.getDecorativeFlowers();
        List<WildFlower> wildFlowerList = stock.getWildFlowers();
        Flower[] flowers = new Flower[decorativeFlowerList.size() + wildFlowerList.size()];
        Flower[] decorativeFlowers = new Flower[decorativeFlowerList.size()];
        Flower[] wildFlowers = new Flower[wildFlowerList.size()];
        decorativeFlowerList.toArray(decorativeFlowers);
        wildFlowerList.toArray(wildFlowers);
//        for (int i = 0; i < decorativeFlowers.length; i++) {
//            flowers[i] = decorativeFlowers[i];
//        }
//        for (int i = 0; i < wildFlowers.length; i++) {
//            flowers[i + decorativeFlowers.length] = wildFlowers[i];
//        }
        System.arraycopy(decorativeFlowers,0, flowers, 0, decorativeFlowers.length);
        System.arraycopy(wildFlowers,0, flowers, decorativeFlowers.length, wildFlowers.length);

        return flowers;
    }

    void putBouquetToStok(Bouquet bouquet) {
        stock.storeBouquet(bouquet);
    }

    List<Bouquet<Flower>> getBouquetsList() {
        return stock.getBouquets();
    }

    // method is used to clear stock from files which now are in a bouquets
    void clearFlowers(String list) {
        switch (list){
            case "wild":
                stock.setWildFlowers(new ArrayList<>());
                break;
            case "decorative":
                stock.setDecorativeFlowers(new ArrayList<>());
                break;
            case "both":
                stock.setWildFlowers(new ArrayList<>());
                stock.setDecorativeFlowers(new ArrayList<>());
                break;
        }
    }
}
