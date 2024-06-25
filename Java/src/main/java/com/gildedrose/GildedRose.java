package com.gildedrose;

class GildedRose {
    Item[] items;

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
    
            switch (item.name) {
                case "Aged Brie":
                    if (item.quality < 50) {
                        item.quality++;
                    }
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    if (item.quality < 50) {
                        item.quality++;
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality++;
                            }
                        }
                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality++;
                            }
                        }
                    }
                    if (item.sellIn < 0) {
                        item.quality = 0;
                    }
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    // Sulfuras never decreases in quality or sellIn
                    break;
                default:
                    if (item.quality > 0) {
                        if (item.name.contains("Conjured")) {
                            item.quality -= 2;
                        } else {
                            item.quality--;
                        }
                    }
                    break;
            }
    
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn--;
            }
    
            if (item.sellIn < 0) {
                if (item.name.equals("Aged Brie")) {
                    if (item.quality < 50) {
                        item.quality++;
                    }
                } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    item.quality = 0;
                } else {
                    if (item.quality > 0) {
                        if (item.name.contains("Conjured")) {
                            item.quality -= 2;
                        } else {
                            item.quality--;
                        }
                    }
                }
            }
        }
    }
    
}
