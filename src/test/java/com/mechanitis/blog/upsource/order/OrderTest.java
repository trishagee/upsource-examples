package com.mechanitis.blog.upsource.order;

import com.mechanitis.blog.upsource.customer.Customer;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class OrderTest {
    private static final int ITEM_ID = 1;
    private static final Customer CUSTOMER = new Customer(2, "first", "last");
    private static final BigDecimal PRICE = new BigDecimal(10);

    @Test
    public void shouldRemoveItemFromInventory() {
        List<Order> allOrderTypes = asList(new BookOrder(ITEM_ID),
                                           new ElectronicsOrder(ITEM_ID),
                                           new GiftCardOrder(CUSTOMER, PRICE));

        for (Order order : allOrderTypes) {
            Warehouse warehouse = mock(Warehouse.class);
            order.placeOrder(warehouse);

            verify(warehouse).itemSold(ITEM_ID);
        }
    }

}