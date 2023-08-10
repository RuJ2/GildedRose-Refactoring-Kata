package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            doUpdateItemQuality(items[i]);
        }
    }

    private void doUpdateItemQuality(Item item) {
        if (item.name.equals("Aged Brie")) {
            doUpdateAgedBrie(item);
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            doUpdateBackStage(item);
        } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            doUpdateSulfras();
        } else if (item.name.equals("Conjured Mana Cake")) {
            doUpdateConjured(item);
        } else {
            doUpdateDefault(item);
        }
    }

    private static void doUpdateConjured(Item item) {
        item.quality = item.quality - 2;
        if (item.sellIn < 1) {
            item.quality = item.quality - 2;
        }
        item.quality = Math.max(item.quality, 0);
        item.sellIn = item.sellIn - 1;
    }

    private static void doUpdateSulfras() {
    }

    private static void doUpdateDefault(Item item) {
        item.quality = item.quality - 1;
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            item.quality = item.quality - 1;
        }
        item.quality = Math.max(item.quality, 0);
    }

    private static void doUpdateBackStage(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
            if (item.sellIn < 11 && item.quality < 50) {
                item.quality = item.quality + 1;
            }
            if (item.sellIn < 6 && item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            item.quality = item.quality - item.quality;
        }
    }

    private static void doUpdateAgedBrie(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0 && item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}
