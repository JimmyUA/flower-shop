package com.sergey.prykhodko.model.products;

import com.sergey.prykhodko.model.products.flowers.Flower;
import com.sergey.prykhodko.model.products.flowers.WildFlower;
import org.junit.Test;

import static com.sergey.prykhodko.model.products.flowers.WildFlowersTypes.CHAMOMILE;
import static org.junit.Assert.assertEquals;

public class WildFlowerTest {

    @Test
    public void flowerShouldReturnPriceAccordingTOItsTypePrice(){
        Flower flower = new WildFlower(CHAMOMILE, "blue");
        int flowerPrice = flower.price();
        int typePrice = CHAMOMILE.getPrice();

        assertEquals(flowerPrice, typePrice);

    }

}