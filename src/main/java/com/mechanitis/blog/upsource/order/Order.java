package com.mechanitis.blog.upsource.order;

public abstract class Order {
    public void placeOrder(Warehouse warehouse) {
        warehouse.itemSold(getItemId());
        // do other order-related activities...
    }

    protected abstract int getItemId();
}
