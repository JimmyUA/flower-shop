package com.sergey.prykhodko;

import com.sergey.prykhodko.controler.MainController;
import com.sergey.prykhodko.model.products.Bouquet;
import com.sergey.prykhodko.model.products.flowers.Flower;
import com.sergey.prykhodko.model.stock.Stock;
import com.sergey.prykhodko.model.stock.stock_exceptions.ItemNotStoredToStockException;
import com.sergey.prykhodko.model.stock.stock_exceptions.StokNotStoredExeption;
import com.sergey.prykhodko.model.stock.stock_exceptions.StoredStokNotFoundException;

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
        } catch (StoredStokNotFoundException e) {
            System.out.println(e.getMessage() + " reason: " + e.getCause().getMessage());
            System.out.println("programm will be continued with empty stock");
            mainController = new MainController(new Stock());
        }

        Scanner in = new Scanner(System.in);
        String command;
        mainController.welcome();
        handleCommands(mainController, in);

        try {
            mainController.saveStockToFile();
        } catch (StokNotStoredExeption e) {
            System.out.println(e.getMessage() + " reason: " + e.getCause().getMessage());
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
                    } catch (ItemNotStoredToStockException e) {
                        mainController.notifyItemNotStored(e.getMessage());
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

                    try {
                    mainController.searchFlowerInBouquetByStemLength(bouquetForSearch, in);
                        }catch (IllegalArgumentException e){
                             mainController.notifyIlligalArgument(e.getMessage());
                            }
                    break;

                    default:
                        mainController.notifyNoSuchCommandAvailable();
            }
        }while (!command.equalsIgnoreCase("exit"));
    }
}
