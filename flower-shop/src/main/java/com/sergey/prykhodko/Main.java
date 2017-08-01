package com.sergey.prykhodko;

import com.sergey.prykhodko.controler.MainController;
import com.sergey.prykhodko.model.products.Bouquet;
import com.sergey.prykhodko.model.products.flowers.Flower;
import com.sergey.prykhodko.model.stock.Stock;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        MainController mainController = null;

        try {
            mainController = new MainController();
        } catch (FileNotFoundException e) {
            System.out.println("Can't find stored stock, programm will be continued with empty stock");
            mainController = new MainController(new Stock());
        }

        Scanner in = new Scanner(System.in);
        String command;
        mainController.welcome();
        handleCommands(mainController, in);
        try {
            mainController.saveStockToFile();
        } catch (IOException e) {
            System.out.println("Can't save changes!");
            return;
        }
        mainController.notifySavingStockToFile();

    }

    private static void handleCommands(MainController mainController, Scanner in) {
        String command;
        do {
            command = in.nextLine();
            switch (command.toLowerCase().trim()){
                case "exit":
                    break;

                case "h":
                case "help":
                    mainController.showHelpList();
                    break;

                case "show stock":
                    mainController.showStock();
                    break;

                case "add flowers":
                    try{
                    mainController.addFlowersToStock(in);
                    }catch (IllegalArgumentException e){
                        mainController.notifyIlligalArgument(e.getMessage());
                    }
                    break;

                case "create bouquet":
                    mainController.createBouquet(in);
                    break;

                case "add accessories":
                    Bouquet<Flower> bouquet = null;
                    try {
                        bouquet = mainController.choseBouquet(in);
                    }catch (NoSuchElementException e){
                        mainController.notifyNoSuchElementFound(e.getMessage());
                        continue;
                    }

                    try {
                        mainController.addAccessoriesToBouquet(in, bouquet);
                    }catch (IllegalArgumentException e){
                        mainController.notifyIlligalArgument(e.getMessage());
                    }
                    break;

                case "sort":
                    Bouquet<Flower> bouquetToSort = null;
                    try {
                        bouquetToSort = mainController.choseBouquet(in);
                    }catch (NoSuchElementException e){
                        mainController.notifyNoSuchElementFound(e.getMessage());
                        continue;
                    }
                    mainController.sortInFreshnessOrder(bouquetToSort);
                    break;

                case "search by stem":
                    Bouquet<Flower> bouquetForSearch = mainController.choseBouquet(in);
                    mainController.searchFlowerInBouquetByStemLength(bouquetForSearch, in);
                    break;

                    default:
                        mainController.notifyNoSuchCommandAvailable();
            }
        }while (!command.equalsIgnoreCase("exit"));
    }
}
