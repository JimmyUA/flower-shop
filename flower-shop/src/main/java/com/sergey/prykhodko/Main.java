package com.sergey.prykhodko;

import com.sergey.prykhodko.controler.MainController;
import com.sergey.prykhodko.model.products.Bouquet;
import com.sergey.prykhodko.model.products.flowers.Flower;
import com.sergey.prykhodko.model.stock.Stock;
import com.sergey.prykhodko.controler.ConsolePrinter;

import java.io.FileNotFoundException;
import java.io.IOException;
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
        }
        mainController = new MainController(new Stock());
        ConsolePrinter printer = new ConsolePrinter();
        Scanner in = new Scanner(System.in);
        String command;
        do {
            command = in.nextLine();
            switch (command.toLowerCase().trim()){
                case "exit":
                    break;
                case "show stock":
                    mainController.showStock();
                    break;
                case "add flowers":
                    mainController.addFlowersToStock(in);
                    break;
                case "create bouquet":
                    mainController.createBouquet(in);
                    break;
                case "add accessories":
                    Bouquet<Flower> bouquet = mainController.choseBouquet(in);
                    mainController.addAccessoriesToBouquet(in, bouquet);
                    break;
                case "sort":
                    Bouquet<Flower> bouquetToSort = mainController.choseBouquet(in);
                    mainController.sortInFreshnessOrder(bouquetToSort);
                    

            }
        }while (!command.equalsIgnoreCase("exit"));
        try {
            mainController.saveStockToFile();
        } catch (IOException e) {
            System.out.println("Can't save changes!");
            return;
        }
        mainController.notifySavingStockToFile();

    }
}
