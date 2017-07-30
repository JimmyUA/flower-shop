package com.sergey.prykhodko.controler;

import com.sergey.prykhodko.model.products.flowers.DecorativeFlower;
import com.sergey.prykhodko.model.products.flowers.Flower;
import com.sergey.prykhodko.model.products.flowers.WildFlower;
import com.sergey.prykhodko.model.stock.Stock;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class StockManager {
    private StockFeatFileWorker worker;
    protected Stock stock;
    private File stockStorage;


    public StockManager(StockFeatFileWorker worker) throws FileNotFoundException {
        this.worker = worker;
        stockStorage = new File("stock.xml");
        recreateStoredStock();
    }

    public StockManager(StockFeatFileWorker worker, Stock stock) {
        this.worker = worker;
        stockStorage = new File("stock.xml");
        this.stock = stock;
    }

    public void storeStock() throws IOException {

        worker.storeStockToFile(stock, stockStorage);

    }

    public void recreateStoredStock() throws FileNotFoundException {
        stock = worker.getStockFromFile(stockStorage);

    }

    public void putDecorativeFlowerToStock(DecorativeFlower flower){
        stock.storeDecorativeFlower(flower);
    }

    public void putWildFlowerToStock(WildFlower flower){
        stock.storeWildFlower(flower);
    }

    public void setEmptyStock() {
        stock = new Stock();
    }

    public Stock getStock() {
        return stock;
    }

    public WildFlower[] getAllWildFlowersFromStok() {
        List<WildFlower> wildFlowerList = stock.getWildFlowers();
        WildFlower[] wildFlowers = new WildFlower[wildFlowerList.size()];
        wildFlowerList.toArray(wildFlowers);

        return wildFlowers;
    }
}
