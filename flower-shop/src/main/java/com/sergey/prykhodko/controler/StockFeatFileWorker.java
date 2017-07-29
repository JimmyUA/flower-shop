package com.sergey.prykhodko.controler;

import com.sergey.prykhodko.model.stock.Stock;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


import java.io.*;


public class StockFeatFileWorker {
    private XStream xStream;

    public StockFeatFileWorker() {
        xStream = new XStream(new DomDriver());
    }

    public void storeStockToFile(Stock stock, File file) throws IOException {
        xStream.toXML(stock, new FileWriter(file));
    }

    public Stock getStockFromFile(File file) throws FileNotFoundException {
        Stock result = new Stock();
        FileInputStream inputStream = new FileInputStream(file);
        xStream.fromXML(inputStream, result);
        return result;
    }

}
