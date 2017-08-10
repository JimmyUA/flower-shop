package com.sergey.prykhodko.controler;

import com.sergey.prykhodko.model.products.Bouquet;
import com.sergey.prykhodko.model.products.flowers.DecorativeFlower;
import com.sergey.prykhodko.model.products.flowers.Flower;
import com.sergey.prykhodko.model.products.flowers.WildFlower;
import com.sergey.prykhodko.model.stock.Stock;
import com.sergey.prykhodko.model.stock.stock_exceptions.ItemNotStoredToStockException;
import com.sergey.prykhodko.model.stock.stock_exceptions.StokNotStoredExeption;
import com.sergey.prykhodko.model.stock.stock_exceptions.StoredStokNotFoundException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class StockManager {
    private StockFeatFileWorker worker;
    Stock stock;
    private File stockStorage;


    StockManager(StockFeatFileWorker worker) throws StoredStokNotFoundException {
        this.worker = worker;
        String fileName = "stock.xml";
        stockStorage = new File(fileName);
        try {
            recreateStoredStock();
        } catch (FileNotFoundException e) {
            throw new StoredStokNotFoundException("Stored stok was not found", e);
        }
    }

    // this constructor is used in case first one have thrown exception
    StockManager(StockFeatFileWorker worker, Stock stock) {
        this.worker = worker;
        stockStorage = new File("resources/stock.xml");
        this.stock = stock;
    }

    void setEmptyStock() {
        stock = new Stock();
    }

    void storeStock() throws StokNotStoredExeption {
        try {
            worker.storeStockToFile(stock, stockStorage);
        } catch (IOException e) {
            throw new StokNotStoredExeption("Stock was not stored", e);
        }
    }

    void recreateStoredStock() throws FileNotFoundException {
        stock = worker.getStockFromFile(stockStorage);

    }


    void putDecorativeFlowerToStock(DecorativeFlower flower) throws ItemNotStoredToStockException {
        stock.storeDecorativeFlower(flower);
        if (isNotInStock(flower)){
           throw new ItemNotStoredToStockException("Flower was not added");
        }

    }

    private boolean isNotInStock(DecorativeFlower flower) {
        List<DecorativeFlower> flowers = stock.getDecorativeFlowers();
        if (flowers.get(flowers.size() - 1).equals(flower)){
            return false;
        }
        else {
            return true;
        }
    }

    private boolean isNotInStock(WildFlower flower) {
        List<WildFlower> flowers = stock.getWildFlowers();
        if (flowers.get(flowers.size() - 1).equals(flower)){
            return false;
        }
        else {
            return true;
        }
    }

    void putWildFlowerToStock(WildFlower flower) throws ItemNotStoredToStockException {
        stock.storeWildFlower(flower);
        if (isNotInStock(flower)){
            throw new ItemNotStoredToStockException("Flower was not added");
        }
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
