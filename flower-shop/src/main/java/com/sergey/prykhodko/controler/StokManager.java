package com.sergey.prykhodko.controler;

import com.sergey.prykhodko.model.products.flowers.Flower;
import com.sergey.prykhodko.model.stock.Stok;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StokeManager {
    private StokFeatFileWorker worker;
    protected Stok stok;
    private File stokStorage;


    public StokeManager(StokFeatFileWorker worker) {
        this.worker = worker;

        stokStorage = new File("stok.xml");
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
}
