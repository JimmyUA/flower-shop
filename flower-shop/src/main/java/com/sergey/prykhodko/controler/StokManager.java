package com.sergey.prykhodko.controler;

import com.sergey.prykhodko.model.products.flowers.Flower;
import com.sergey.prykhodko.model.stock.Stok;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StokManager {
    private StokFeatFileWorker worker;
    protected Stok stok;
    private File stokStorage;


    public StokManager(StokFeatFileWorker worker) throws FileNotFoundException {
        this.worker = worker;
        stokStorage = new File("stok.xml");
        recreateStoredStok();
    }

    public StokManager(StokFeatFileWorker worker, Stok stok) {
        this.worker = worker;
        stokStorage = new File("stok.xml");
        this.stok = stok;
    }

    public void storeStok() throws IOException {

        worker.storeStokToFile(stok, stokStorage);

    }

    public void recreateStoredStok() throws FileNotFoundException {
        stok = worker.getStokFromFile(stokStorage);

    }

    public void putFlowerToStok(Flower flower){
        stok.storeFlower(flower);
    }

    public void setEmptyStok() {
        stok = new Stok();
    }

    public Stok getStok() {
        return stok;
    }
}
