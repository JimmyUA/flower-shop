package com.sergey.prykhodko.controler;

import com.sergey.prykhodko.model.stock.Stok;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class StokeManagerTest {
    StokFeatFileWorker workerMock = mock(StokFeatFileWorker.class);
    StokeManager stokeManager = new StokeManager(workerMock);


    @Test
    public void methodStoreStokToFileShouldBeInvokedAfterInvokingStoreStokeMethod(){
        try {
            stokeManager.storeStok();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        try {
            verify(workerMock,atLeastOnce()).storeStokToFile(any(Stok.class), any(File.class));
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void methodGetStokFromFileShouldBeInvokedAfterInvokingRecreateStoredStok(){
        Stok etalonStok = new Stok();
        try {
            when(workerMock.getStokFromFile(any(File.class))).thenReturn(etalonStok);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            stokeManager.recreateStoredStok();
            } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        assertEquals(stokeManager.stok, etalonStok);
    }

    @Test
    public void flowerShouldBePutIntoStockFlowerListAfterItWasAddedToStokByStokManager(){

    }

}