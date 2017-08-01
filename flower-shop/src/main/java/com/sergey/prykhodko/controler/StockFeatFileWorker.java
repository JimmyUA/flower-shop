package com.sergey.prykhodko.controler;

import com.sergey.prykhodko.model.products.Bouquet;
import com.sergey.prykhodko.model.products.accessories.Accessory;
import com.sergey.prykhodko.model.products.flowers.DecorativeFlower;
import com.sergey.prykhodko.model.products.flowers.Flower;
import com.sergey.prykhodko.model.products.flowers.WildFlower;
import com.sergey.prykhodko.model.stock.Stock;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class StockFeatFileWorker {
    private XStream xStream;

    public StockFeatFileWorker() {
        xStream = new XStream();
    }

    public void storeStockToFile(Stock stock, File file) throws IOException {
        FileWriter writer = new FileWriter(file);
        xStream = new XStream(new DomDriver());
        xStream.toXML(stock, writer);
//        xStream.toXML(stock.getWildFlowers(), writer);
//        xStream.toXML(stock.getDecorativeFlowers(), writer);
//        xStream.toXML(stock.getBouquets(), writer);
//        xStream.toXML(stock.getAccessories(), writer);

    }

    public Stock getStockFromFile(File file) throws FileNotFoundException {
        xStream = new XStream(new DomDriver());
        Stock result = new Stock();
        FileInputStream inputStream = new FileInputStream(file);
        xStream.fromXML(inputStream, result);
//        List<WildFlower> wildFlowers = new ArrayList<>();
//        xStream.fromXML(inputStream, wildFlowers);
//        List<DecorativeFlower> decorativeFlowers = new ArrayList<>();
//        xStream.fromXML(inputStream, decorativeFlowers);
//        List<Bouquet<Flower>> bouquets = new ArrayList<>();
//        xStream.fromXML(inputStream, bouquets);
//        List<Accessory> accessories = new ArrayList<>();
//        xStream.fromXML(inputStream, accessories);
//        result.setWildFlowers(wildFlowers);
//        result.setDecorativeFlowers(decorativeFlowers);
//        result.setBouquets(bouquets);
//        result.setAccessories(accessories);
        return result;
    }

}
