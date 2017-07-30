package com.sergey.prykhodko.controler;

import com.sergey.prykhodko.model.products.flowers.*;
import com.sergey.prykhodko.model.stock.Stock;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MainController {
    private StockManager stockManager;
    private ConsolePrinter consolePrinter;
    private BouquetManager bouquetManager;

    public MainController() throws FileNotFoundException {
        StockFeatFileWorker stockFeatFileWorker = new StockFeatFileWorker();
        stockManager = new StockManager(stockFeatFileWorker);
        consolePrinter = new ConsolePrinter();
        bouquetManager = new BouquetManager();
    }

    public MainController(Stock stock) {
        StockFeatFileWorker stockFeatFileWorker = new StockFeatFileWorker();
        stockManager = new StockManager(stockFeatFileWorker, stock);
        consolePrinter = new ConsolePrinter();
    }

    public void saveStockToFile() throws IOException {
        stockManager.storeStock();
    }

    public void setEmptyStock() {
        stockManager.setEmptyStock();
    }

    public void showStock(){
        Stock stock = stockManager.getStock();
        consolePrinter.showStock(stock);
    }

    public void notifySavingStockToFile(){
        consolePrinter.notifySavingStockToFile();
    }

    public void addFlowersToStock(Scanner scanner) throws IllegalArgumentException{
        do {
            consolePrinter.askFlowerClass();
            String requiredFlowerClass = scanner.nextLine();
            if(requiredFlowerClass.equalsIgnoreCase("stop")){
                return;
            }
            choseFlowerFactoryType(requiredFlowerClass, scanner);
        }while (true);
    }

    private void choseFlowerFactoryType(String requiredFlowerClass, Scanner scanner) {
        FlowerFactory flowerFactory;
        Flower flower;
        switch (requiredFlowerClass.toLowerCase()){
            case "wild":
                flowerFactory = new WildFlowerFactory();
                flower = choseWildFlowerType(flowerFactory, scanner);
                stockManager.putFlowerToStock(flower);
                break;
            case "decorative":
                flowerFactory = new DecorativeFlowerFactory();
                flower = choseDecorativelowerType(flowerFactory, scanner);
                stockManager.putFlowerToStock(flower);
                break;
                default:
                    throw new IllegalArgumentException("No such flower class");
        }
        consolePrinter.notifySavingFlowerToStock(flower);
    }

    private WildFlower choseWildFlowerType(FlowerFactory factory, Scanner scanner) {
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


    public void createBouquet(Scanner scanner) {
        consolePrinter.askBouquetType();
        String requiredBouquetType = scanner.nextLine();
        switch (requiredBouquetType){
            case "wild":
                WildFlower[] wildFlowers = stockManager.getAllWildFlowersFromStok();
        }
    }
}
