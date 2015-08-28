package com.mechanitis.blog.upsource.order;

public class BookOrder implements Order {
    private int customerId;
    private int bookId;

    public BookOrder(int bookId) {
        this.bookId = bookId;
    }

    public int getCustomerId() {
        return customerId;
    }

    @Override
    public void placeOrder(Warehouse warehouse) {
        warehouse.itemSold(bookId);
    }
}
