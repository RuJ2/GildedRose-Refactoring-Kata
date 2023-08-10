/**
 * @(#)ApprovalTest.java, 8月 09, 2023.
 * <p>
 * Copyright 2023 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

/**
 * @author rujiapei
 */
public class ApprovalTest {

    @Test
    public void updateQuality(){
        CombinationApprovals.verifyAllCombinations(
            this::callUpdateQuality,
            new String[]{"a common item", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros", "Conjured Mana Cake"},
            new Integer[]{0, 11, -1},
            new Integer[]{0, 1, -1, 49, 50, 55}
        );
    }

    @Test
    public String callUpdateQuality(String name, int sellIn, int quality){
        Item[] items = new Item[]{new Item(name, sellIn, quality)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return app.items[0].toString();
    }
}
