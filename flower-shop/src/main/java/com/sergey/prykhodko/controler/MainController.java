package com.sergey.prykhodko.controler;

import com.sergey.prykhodko.model.products.flowers.*;
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
        do {
            consolePrinter.askFlowerClass();
            String requiredFlowerClass = scanner.nextLine();
            if(requiredFlowerClass.equalsIgnoreCase("stop")){
                return;
            }
            choseFactoryType(requiredFlowerClass, scanner);
        }while (true);
    }

    private void choseFactoryType(String requiredFlowerClass, Scanner scanner) {
        FlowerFactory flowerFactory;
        Flower flower;
        switch (requiredFlowerClass.toLowerCase()){
            case "wild":
                flowerFactory = new WildFlowerFactory();
                flower = choseWildFlowerType(flowerFactory, scanner);
                stokManager.putFlowerToStok(flower);
                break;
            case "decorative":
                flowerFactory = new DecorativeFlowerFactory();
                flower = choseDecorativelowerType(flowerFactory, scanner);
                stokManager.putFlowerToStok(flower);
                break;
                default:
                    throw new IllegalArgumentException("No such flower class");
        }
        consolePrinter.notifySavingFlowerToStok(flower);
    }

    private WildFlower choseWildFlowerType(FlowerFactory factory, Scanner scanner) { //TODO resolve problem when no color entered
        consolePrinter.askFlowerTypeAndColor();
        String requiredFlowerTypeAndColor = scanner.nextLine();
        String[] typeAndColor = requiredFlowerTypeAndColor.split(" ");
        String requiredColor;
        if (typeAndColor.length > 1){
            requiredColor = typeAndColor[1];}
            else {
            requiredColor = "white";
        }
        String requiredFlowerType = typeAndColor[0];

        return (WildFlower) factory.createFlower(requiredFlowerType, requiredColor);
    }

    private DecorativeFlower choseDecorativelowerType(FlowerFactory factory, Scanner scanner) {
        consolePrinter.askFlowerTypeAndColor();
        String requiredFlowerTypeAndColor = scanner.nextLine();
        String[] typeAndColor = requiredFlowerTypeAndColor.split(" ");
        String requiredColor;
        if (typeAndColor.length > 1){
            requiredColor = typeAndColor[1];}
        else {
            requiredColor = "white";
        }
        String requiredFlowerType = typeAndColor[0];
        return (DecorativeFlower) factory.createFlower(requiredFlowerType, requiredColor);
    }


}
