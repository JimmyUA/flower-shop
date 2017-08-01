package com.sergey.prykhodko.controler;

import com.sergey.prykhodko.model.products.accessories.Accessory;
import com.sergey.prykhodko.model.products.Bouquet;
import com.sergey.prykhodko.model.products.flowers.DecorativeFlower;
import com.sergey.prykhodko.model.products.flowers.Flower;
import com.sergey.prykhodko.model.products.flowers.WildFlower;
import com.sergey.prykhodko.model.stock.Stock;

import java.util.List;

 class ConsolePrinter {

     /*************************************************************************
      *************************SHOW STOCK ITEMS********************************
      *************************************************************************/

     void showStock(Stock stock) { //TODO divide for smaller methods
         StringBuilder stockRepresantation = new StringBuilder();
         stockRepresantation.append("///////////////////////////////////FLOWERS//////////////////////////////////\n");
         List<WildFlower> wildFlowers = stock.getWildFlowers();
         List<DecorativeFlower> decorativeFlowers = stock.getDecorativeFlowers();
         if (wildFlowers.isEmpty() && decorativeFlowers.isEmpty()){
             stockRepresantation.append("                                    EMPTY                                     \n");
         }
         else {
             for (Flower flower : wildFlowers
                     ) {
                 stockRepresantation.append(flower.toString()).append("\n");
             }
             for (Flower flower : decorativeFlowers
                     ) {
                 stockRepresantation.append(flower.toString()).append("\n");
             }

         }
         stockRepresantation.append("///////////////////////////////////BOUQUETS//////////////////////////////////\n");
         List<Bouquet<Flower>> bouquets = stock.getBouquets();
         if(bouquets.isEmpty()){
             stockRepresantation.append("                                    EMPTY                                     \n");
         }
         else {
             for (Bouquet bouquet : bouquets
                     ) {
                 stockRepresantation.append(bouquet.toString()).append("\n");
             }
         }
         stockRepresantation.append("////////////////////////////////////////////////////////////////////////////");

         System.out.println(stockRepresantation);
     }

     void showFlowers(List<Flower> flowers) {
         for (Flower flower : flowers
                 ) {
             System.out.println(flower);
             String stemLength = "Stem length: " + flower.getStemLength() + "mm";
             System.out.println("\033[0;1m" + stemLength + "\033[0m");
         }
     }

     void showAvailableBouquets(List<Bouquet<Flower>> availableBouquets) {
         System.out.println("\033[0;1mThere are next bouquets available:\033[0m");
         for (int i = 1; i <= availableBouquets.size(); i++) {
             System.out.println(i  + ". " + availableBouquets.get(i - 1));
         }

     }

     void showBouquetComponents(Bouquet<Flower> bouquet) {
         System.out.println(bouquet + "consist of:");
         System.out.println("\033[0;1mFlowers: \033[0m");
         for (Flower flower:bouquet.getFlowers()
                 ) {
             System.out.println(flower);
         }
         System.out.println("\033[0;1mAccessories:\033[0m");
         if (bouquet.getAccessories().isEmpty()){
             System.out.println("No accessories!");
         }
         for (Accessory accessory:bouquet.getAccessories()
                 ) {
             System.out.println(accessory);
         }
     }

     void notifySavingStockToFile() {
        System.out.println("Stock state was stored!");
    }

     void notifySavingFlowerToStock(Flower flower) {
         System.out.println(flower.toString() + " were put to stock\n");
     }

     void notifySavingBouquetToStock(Bouquet<? extends Flower> bouquet) {
         System.out.println(bouquet.toString() + " were put to stock\n");
     }

     void notifyAddingAccessoryToBouquet(Accessory accessory) {
         System.out.println(accessory.toString() + " were put to current bouquet\n");
     }

     /*************************************************************************
      *************************QUESTIONS TO USER*******************************
      *************************************************************************/

     void askFlowerClass() {
        System.out.println("What flower type do you want to create?\nPossible vriants are:\n" +
                "- wild\n- decorative\n- stop (to stop addition)");

    }

     void askFlowerTypeAndColor() {
        System.out.println("What flower do you want to create?" +
                "\nPossible vriants are:\n");
    }

     void askBouquetType() {
        System.out.println("What flower type do you want to create?\nPossible vriants are:\n" +
                "- wild\n- decorative\n- mixed");
    }

     void askAccessoryType() {
        System.out.println("What accessory type do you want to add?\nPossible vriants are:\n" +
                "- wrapper\n- tape\n- bow-knot");
    }

     void askWrapperType() {
        System.out.println("What wrapper type do you want to add?\nPossible vriants are:\n" +
                "- cellopane\n- paper\n- textile");
    }

     void askBouquetNumber() {
        System.out.println("Please chose bouquet number:");
    }

     void askStemLengthRange() {
        System.out.println("please enter bottom and top limits for flower stem length:");
    }

     /*************************************************************************
      *************************EXCEPTION NOTIFICATIONS*************************
      *************************************************************************/


     void printNoSuchClassExist() {
        System.out.println("\n\u001B[31mNo such flowers class found!\u001B[0m\n");
    }

     void printIlligalArgumentWarning(String message) {
        System.out.println("\n\u001B[31m"+ message +"\u001B[0m\nEntering main menu...\n");
    }

     void printNoSuchElementWarning(String message) {
        System.out.println("\n\u001B[31m"+ message +"\u001B[0m\nEntering main menu...\n");
    }

     void printNoSuchCommandAvailable() {
         System.out.println("\n\u001B[31mNo such command!!!\u001B[0m \nPlease check \"h\" or \"help\"\n");
     }

     /*************************************************************************
      *****************************SYSTEM MESSAGES*****************************
      *************************************************************************/

     void printHelpList() {
         System.out.println("\033[0;1m///////////////////////////////FLOWER SHOP//////////////////////////////////\033[0m");
         System.out.println("Programm for storing and managing flower shop data, such as flowers," +
                 " bouquets and accessories.");
         System.out.println("You are welcome to use next commands:");
         System.out.println("\033[0;1m\"h\"\033[0m or \033[0;1m\"help\"\033[0m");
         System.out.println("     -to check commands and instructions");
         System.out.println("\033[0;1m\"add flowers\"\033[0m");
         System.out.println("     -to add flowers to stock");
         System.out.println("\033[0;1m\"create bouquet\"\033[0m");
         System.out.println("     -to create a bouquet");
         System.out.println("\033[0;1m\"add accessories\"\033[0m");
         System.out.println("     -to add accessories to existing bouquet");
         System.out.println("\033[0;1m\"sort\"\033[0m");
         System.out.println("     -to sort flowers in existing bouquet by freshness");
         System.out.println("\033[0;1m\"search by stem\"\033[0m");
         System.out.println("     -to search flowers in existing bouquet by stem length");
     }

     void printWelcome() {
         System.out.println("\033[0;1m///////////////////////////WELCOME TO FLOWER SHOP//////////////////////////////\033[0m");
         System.out.println("Please check \"h\" or \"-help\" to see available commands");
     }

 }
