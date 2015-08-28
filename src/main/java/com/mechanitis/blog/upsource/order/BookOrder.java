package com.mechanitis.blog.upsource.order;

public class BookOrder extends Order {
    private int customerId;
    private int bookId;

    public BookOrder(int bookId) {
        this.bookId = bookId;
    }

    public int getCustomerId() {
        return customerId;
    }

    @Override
    protected int getItemId() {
        return bookId;
    }
}
