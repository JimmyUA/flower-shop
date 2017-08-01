package com.sergey.prykhodko.controler;

import com.sergey.prykhodko.model.products.Bouquet;
import com.sergey.prykhodko.model.products.accessories.*;
import com.sergey.prykhodko.model.products.flowers.*;
import com.sergey.prykhodko.model.stock.Stock;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
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
        bouquetManager = new BouquetManager();
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
                stockManager.putWildFlowerToStock((WildFlower) flower);
                break;
            case "decorative":
                flowerFactory = new DecorativeFlowerFactory();
                flower = choseDecorativelowerType(flowerFactory, scanner);
                stockManager.putDecorativeFlowerToStock((DecorativeFlower) flower);
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
        choseAndCreateRequiredBouquetType(requiredBouquetType);
    }

    private void choseAndCreateRequiredBouquetType(String requiredBouquetType) {
        switch (requiredBouquetType){
            case "wild":
                WildFlower[] wildFlowers = stockManager.getAllWildFlowersFromStok();
                Bouquet<WildFlower> wildFlowerBouquet = bouquetManager.createNewWildFlowersBouquet(wildFlowers);
                stockManager.putBouquetToStok(wildFlowerBouquet);
                consolePrinter.notifySavingBouquetToStock(wildFlowerBouquet);
                break;
            case "decorative":
                DecorativeFlower[] decorativeFlowers = stockManager.getAllDecorativeFlowersFromStok();
                Bouquet<DecorativeFlower> decorativeFlowerBouquet =
                        bouquetManager.createNewDecorativeFlowersBouquet(decorativeFlowers);
                stockManager.putBouquetToStok(decorativeFlowerBouquet);
                consolePrinter.notifySavingBouquetToStock(decorativeFlowerBouquet);
                break;
            case "mixed":
                Flower[] flowers = stockManager.getAllFlowersFromStok();
                Bouquet<Flower> mixedFlowerBouquet = bouquetManager.createNewMixedFlowersBouquet(flowers);
                stockManager.putBouquetToStok(mixedFlowerBouquet);
                consolePrinter.notifySavingBouquetToStock(mixedFlowerBouquet);
                break;
                default:
                    throw new IllegalArgumentException("There is no such bouquet type");
        }
    }

    public void addAccessoriesToBouquet(Scanner scanner, Bouquet bouquet) {
        consolePrinter.askAccessoryType();
        String requiredAccessoryType = scanner.nextLine();
        switch (requiredAccessoryType.toLowerCase().trim()){
            case "wrapper":
                Wrapper wrapper = choseWrapperType(scanner);
                bouquet.addAccessory(wrapper);
                consolePrinter.notifyAddingAccessoryToBouquet(wrapper);
                break;
            case "tape":
                Tape tape = new Tape();
                bouquet.addAccessory(tape);
                consolePrinter.notifyAddingAccessoryToBouquet(tape);
                break;
            case "bow-knot":
                BowKnot bowKnot = new BowKnot();
                bouquet.addAccessory(bowKnot);
                consolePrinter.notifyAddingAccessoryToBouquet(bowKnot);
                break;
            default:
                throw new IllegalArgumentException("There is no such accessory type");
        }
    }

    private Wrapper choseWrapperType(Scanner scanner) {
        consolePrinter.askWrapperType();
        String requiredWrapperType = scanner.nextLine();
        switch (requiredWrapperType.toLowerCase().trim()){
            case "cellophane":
                return new CellophaneWrapper();
            case "paper":
                return new PaperWrapper();
            case "textile":
                return new TextileWrapper();
            default:
                throw new IllegalArgumentException("There is no such wrapper type");
        }
    }

    public Bouquet<Flower> choseBouquet(Scanner scanner) {
        List<Bouquet<Flower>> availableBouquets = stockManager.getBouquetsList();
        if (availableBouquets.isEmpty()){
            throw new NoSuchElementException("No bouquets are available");
        }
        consolePrinter.showAvailableBouquets(availableBouquets);
        consolePrinter.askBouquetNumber();
        int requeredBouquetNumber = 1;
        try {
            requeredBouquetNumber = Integer.parseInt(scanner.nextLine());
        }catch (NumberFormatException e){
            System.out.println("Incorrect input, first bouquet is chosen by default");
            return availableBouquets.get(0);
        }
        try{
            return availableBouquets.get(requeredBouquetNumber - 1);
        }catch (IndexOutOfBoundsException e){
            System.out.println("There are no bouquets with such number, first one is " +
                    "chosen by default");
        }
        return availableBouquets.get(0);
    }

    public void sortInFreshnessOrder(Bouquet<Flower> bouquetToSort) {
        bouquetToSort.sortByFreshness();
        consolePrinter.showBouquetComponents(bouquetToSort);
    }
}
