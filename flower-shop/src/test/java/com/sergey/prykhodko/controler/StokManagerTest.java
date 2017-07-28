package com.sergey.prykhodko.controler;

import com.sergey.prykhodko.model.stock.Stok;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class StokManagerTest {
    StokFeatFileWorker workerMock = mock(StokFeatFileWorker.class);
    StokManager stokManager = new StokManager(workerMock);

    public StokManagerTest() throws FileNotFoundException {
    }


    @Test
    public void methodStoreStokToFileShouldBeInvokedAfterInvokingStoreStokeMethod(){
        stokManager.stok = new Stok();
        try {
            stokManager.storeStok();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        try {
            verify(workerMock).storeStokToFile(any(Stok.class), any(File.class));
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
            stokManager.recreateStoredStok();
            } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        assertEquals(stokManager.stok, etalonStok);
    }

    @Test
    public void flowerShouldBePutIntoStockFlowerListAfterItWasAddedToStokByStokManager(){

    }

}