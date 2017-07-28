package com.sergey.prykhodko.controler;

import com.sergey.prykhodko.model.products.flowers.DecorativeFlowerFactory;
import com.sergey.prykhodko.model.products.flowers.Flower;
import com.sergey.prykhodko.model.products.flowers.FlowerFactory;
import com.sergey.prykhodko.model.products.flowers.WildFlowerFactory;
import com.sergey.prykhodko.model.stock.Stok;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MainController {
    private StokManager stokManager;
    private ConsolePrinter consolePrinter;

    public MainController() throws FileNotFoundException {
        StokFeatFileWorker stokFeatFileWorker = new StokFeatFileWorker();
        stokManager = new StokManager(stokFeatFileWorker);
        consolePrinter = new ConsolePrinter();
    }

    public MainController(Stok stok) {
        StokFeatFileWorker stokFeatFileWorker = new StokFeatFileWorker();
        stokManager = new StokManager(stokFeatFileWorker, stok);
        consolePrinter = new ConsolePrinter();
    }

    public void saveStokToFile() throws IOException {
        stokManager.storeStok();
    }

    public void setEmptyStok() {
        stokManager.setEmptyStok();
    }

    public void showStok(){
        Stok stok = stokManager.getStok();
        consolePrinter.showStok(stok);
    }

    public void notifySavingStokToFile(){
        consolePrinter.notifySavingStokToFile();
    }

    public void addFlowersToStok(Scanner scanner) throws IllegalArgumentException{
        consolePrinter.askFlowerClass();
        String requiredFlowerClass = scanner.nextLine();
        FlowerFactory flowerFactory = choseFactoryType(requiredFlowerClass);
        consolePrinter.askFlowerType();
        String requiredFlowerType = scanner.nextLine();
        Flower flower = choseFlowerType(requiredFlowerType);

    }

    private FlowerFactory choseFactoryType(String requiredFlowerClass) {
        FlowerFactory flowerFactory;
        switch (requiredFlowerClass.toLowerCase()){
            case "wild":
                flowerFactory = new WildFlowerFactory();
                break;
            case "decorative":
                flowerFactory = new DecorativeFlowerFactory();
                default:
                    throw new IllegalArgumentException("No such flower class");
        }
        return flowerFactory;
    }

    private Flower choseFlowerType(String requiredFlowerType) {
    }


}
