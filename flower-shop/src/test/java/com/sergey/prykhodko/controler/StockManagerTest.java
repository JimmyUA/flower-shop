package com.sergey.prykhodko.controler;

import com.sergey.prykhodko.model.stock.Stock;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class StockManagerTest {
    StockFeatFileWorker workerMock = mock(StockFeatFileWorker.class);
    StockManager stockManager = new StockManager(workerMock);

    public StockManagerTest() throws FileNotFoundException {
    }


    @Test
    public void methodStoreStokToFileShouldBeInvokedAfterInvokingStoreStokeMethod(){
        stockManager.stock = new Stock();
        try {
            stockManager.storeStock();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        try {
            verify(workerMock).storeStockToFile(any(Stock.class), any(File.class));
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void methodGetStokFromFileShouldBeInvokedAfterInvokingRecreateStoredStok(){
        Stock etalonStock = new Stock();
        try {
            when(workerMock.getStockFromFile(any(File.class))).thenReturn(etalonStock);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            stockManager.recreateStoredStock();
            } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        assertEquals(stockManager.stock, etalonStock);
    }

    @Test
    public void flowerShouldBePutIntoStockFlowerListAfterItWasAddedToStokByStokManager(){

    }

}