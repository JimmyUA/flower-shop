package com.sergey.prykhodko;

import com.sergey.prykhodko.controler.MainController;
import com.sergey.prykhodko.model.stock.Stok;
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
            System.out.println("Can't find stored stok, programm will be continued with empty stok");
        }
        mainController = new MainController(new Stok());
        ConsolePrinter printer = new ConsolePrinter();
        Scanner in = new Scanner(System.in);
        String command;
        do {
            command = in.nextLine();
            switch (command.toLowerCase()){
                case "exit":
                    break;
                case "show stok":
                    mainController.showStok();
                    break;
                case "add flowers to stok":
                    mainController.addFlowersToStok(in);

            }
        }while (!command.equalsIgnoreCase("exit"));
        try {
            mainController.saveStokToFile();
        } catch (IOException e) {
            System.out.println("Can't save changes!");
            return;
        }
        mainController.notifySavingStokToFile();

    }
}
