package com.mechanitis.blog.upsource.order;

public class ElectronicsOrder extends Order {
    private int itemId;

    public ElectronicsOrder(int itemId) {
        this.itemId = itemId;
    }

    @Override
    protected int getItemId() {
        return itemId;
    }
}
