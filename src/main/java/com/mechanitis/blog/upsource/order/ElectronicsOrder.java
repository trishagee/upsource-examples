package com.mechanitis.blog.upsource.order;

public class ElectronicsOrder implements Order {
    private int itemId;

    public ElectronicsOrder(int itemId) {

        this.itemId = itemId;
    }

    @Override
    public void placeOrder(Warehouse warehouse) {
        warehouse.itemSold(itemId);
    }
}
