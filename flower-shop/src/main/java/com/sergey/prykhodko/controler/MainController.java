package com.sergey.prykhodko.controler;

import com.sergey.prykhodko.model.products.Bouquet;
import com.sergey.prykhodko.model.products.accessories.*;
import com.sergey.prykhodko.model.products.flowers.*;
import com.sergey.prykhodko.model.stock.Stock;
import com.sergey.prykhodko.model.stock.stock_exceptions.StokNotStoredExeption;
import com.sergey.prykhodko.model.stock.stock_exceptions.StoredStokNotFoundException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MainController {
    private StockManager stockManager;
    private ConsolePrinter consolePrinter;
    private BouquetManager bouquetManager;

    public MainController() throws StoredStokNotFoundException {
        StockFeatFileWorker stockFeatFileWorker = new StockFeatFileWorker();
        stockManager = new StockManager(stockFeatFileWorker);
        consolePrinter = new ConsolePrinter();
        bouquetManager = new BouquetManager();

    }

    // this constructor is used when first one had thrown exception
    public MainController(Stock stock) {
        StockFeatFileWorker stockFeatFileWorker = new StockFeatFileWorker();
        stockManager = new StockManager(stockFeatFileWorker, stock);
        consolePrinter = new ConsolePrinter();
        bouquetManager = new BouquetManager();
    }

    /*************************************************************************
     *************************WORK WITH STOCK MANAGER*************************
     *************************************************************************/
    public void saveStockToFile() throws StokNotStoredExeption {
        stockManager.storeStock();
    }

    public void showStock(){
        Stock stock = stockManager.getStock();
        consolePrinter.showStock(stock);
    }

    /*************************************************************************
     *******************************NOTIFIERS*********************************
     *************************************************************************/

    public void notifySavingStockToFile(){
        consolePrinter.notifySavingStockToFile();
    }

    public void showHelpList() {
        consolePrinter.printHelpList();
    }

    public void welcome() {
        consolePrinter.printWelcome();
    }

    public void notifyNoSuchCommandAvailable() {
        consolePrinter.printNoSuchCommandAvailable();
    }

    public void notifyIlligalArgument(String message) {
        consolePrinter.printIlligalArgumentWarning(message);
    }

    public void notifyNoSuchElementFound(String message) {
        consolePrinter.printNoSuchElementWarning(message);
    }

    /*************************************************************************
     *******************************FLOWER ADDING METHODS*********************
     *************************************************************************/

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
                    consolePrinter.printNoSuchClassExist();
                    return;
        }
        consolePrinter.notifySavingFlowerToStock(flower);
    }

    private WildFlower choseWildFlowerType(FlowerFactory factory, Scanner scanner) {
        consolePrinter.askFlowerTypeAndColor("wild");
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
        consolePrinter.askFlowerTypeAndColor("decorative");
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

    /*************************************************************************
     *******************************BOUQUET CREATION METHODS*********************
     *************************************************************************/

    public void createBouquet(Scanner scanner) {
        consolePrinter.askBouquetType();
        String requiredBouquetType = scanner.nextLine();
        choseAndCreateRequiredBouquetType(requiredBouquetType);
    }

    private void choseAndCreateRequiredBouquetType(String requiredBouquetType) {
        switch (requiredBouquetType){
            case "wild":
                createWildFlowerBouquet();
                break;
            case "decorative":
                createDecorativeFlowerBouquet();
                break;
            case "mixed":
                createMixedBouquet();
                break;
                default:
                    notifyIlligalArgument("No such bouquet types!");
        }
    }

    private void createMixedBouquet() {
        Flower[] flowers = stockManager.getAllFlowersFromStok();
        Bouquet<Flower> mixedFlowerBouquet = bouquetManager.createNewMixedFlowersBouquet(flowers);
        stockManager.putBouquetToStok(mixedFlowerBouquet);
        stockManager.clearFlowers("both");
        consolePrinter.notifySavingBouquetToStock(mixedFlowerBouquet);
    }

    private void createDecorativeFlowerBouquet() {
        DecorativeFlower[] decorativeFlowers = stockManager.getAllDecorativeFlowersFromStok();
        Bouquet<DecorativeFlower> decorativeFlowerBouquet =
                bouquetManager.createNewDecorativeFlowersBouquet(decorativeFlowers);
        stockManager.putBouquetToStok(decorativeFlowerBouquet);
        stockManager.clearFlowers("decorative");
        consolePrinter.notifySavingBouquetToStock(decorativeFlowerBouquet);
    }

    private void createWildFlowerBouquet() {
        WildFlower[] wildFlowers = stockManager.getAllWildFlowersFromStok();
        Bouquet<WildFlower> wildFlowerBouquet = bouquetManager.createNewWildFlowersBouquet(wildFlowers);
        stockManager.putBouquetToStok(wildFlowerBouquet);
        stockManager.clearFlowers("wild");
        consolePrinter.notifySavingBouquetToStock(wildFlowerBouquet);
    }

    /*************************************************************************
     *******************************ACCESSORIES ADDING METHODS*********************
     *************************************************************************/

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

    /*************************************************************************
     *******************************BOUQUETS SORTING METHODS*********************
     *************************************************************************/

    public Bouquet<Flower> choseBouquet(Scanner scanner) {
        List<Bouquet<Flower>> availableBouquets = stockManager.getBouquetsList();
        if (availableBouquets.isEmpty()){
            throw new NoSuchElementException("No bouquets are available");
        }
        consolePrinter.showAvailableBouquets(availableBouquets);
        consolePrinter.askBouquetNumber();
        int requeredBouquetNumber;
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
        bouquetToSort.sortFlowersByFreshness();
        consolePrinter.showBouquetComponents(bouquetToSort);
    }

    public void searchFlowerInBouquetByStemLength(Bouquet<Flower> bouquetForSearch,
                                                  Scanner scanner) throws IllegalArgumentException{
        consolePrinter.askStemLengthRange();
        String lengthLimits = scanner.nextLine().trim();
        String[] limits = lengthLimits.split(" ");
        int bottomLimit;
        int topLimit;
        if (limits.length == 1) {
            bottomLimit = topLimit = Integer.parseInt(limits[0]);
        } else if (limits.length == 2) {
            bottomLimit = Integer.parseInt(limits[0]);
            topLimit = Integer.parseInt(limits[1]);
        } else {
            throw new IllegalArgumentException("Limits were not entered correctly");
        }
        if (topLimit < bottomLimit) {
            throw new IllegalArgumentException("Limits were not entered correctly");
        }
        List<Flower> flowersWithStemLengthInRange = bouquetForSearch.
                getFlowersWithStemInRange(bottomLimit, topLimit);
        consolePrinter.showFlowers(flowersWithStemLengthInRange);
    }


}
