package com.sergey.prykhodko.model.stock;

import com.sergey.prykhodko.model.products.flowers.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StockTest {

    Stock stok = new Stock();

    @Test
    public void methodStoreWildFlowerShouldAddWildFlowerToCorrecpondingList(){
        WildFlower sun = new WildFlower(WildFlowersTypes.SUNFLOWER, "black");
        List<WildFlower> wildFlowers = stok.getWildFlowers();

        stok.storeWildFlower(sun);

        assertTrue(wildFlowers.contains(sun));
    }

    @Test
    public void methodStoreDecorativeFlowerShouldAddDecorativeFlowerToCorrecpondingList(){
        DecorativeFlower rose = new DecorativeFlower(DecorativeFlowersTypes.ROSE, "black");
        List<DecorativeFlower> decorativeFlowers = stok.getDecorativeFlowers();

        stok.storeDecorativeFlower(rose);

        assertTrue(decorativeFlowers.contains(rose));
    }
}