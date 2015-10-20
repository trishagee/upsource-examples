package com.mechanitis.blog.upsource;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class Java8 {
    private final List<Item> receipt = new ArrayList<>();
    private final Map<Long, List<Item>> itemsById = new HashMap<>();
    private final Set<Long> threeForTwoItems = new HashSet<>();


    @Test
    public void shouldComputeThreeForTwo() {
        threeForTwoItems.add(2L);

        Stream<Integer> items = Stream.of(2, 3, 5, 2, 1, 2, 1, 2);
        items.forEach(this::addItemNoStream);

        System.out.println(receipt);
    }

    private void addItem(long itemId) {
        Item item = getItemById(itemId);
        receipt.add(item);

        if (threeForTwoItems.contains(itemId)) {
            long count = receipt.stream()
                                .filter(item1 -> item1.getId() == itemId)
                                .count();
            if (count % 3 == 0) {
                item.setPrice(new BigDecimal("0.00"));
            }
        }

    }

    private void addItemNoStream(long itemId) {
        Item item = getItemById(itemId);
        receipt.add(item);
        itemsById.compute(itemId, (aLong, items) -> {
            if (items == null) {
                items = new ArrayList<>();
            }
            items.add(item);
            return items;
        });

        if (threeForTwoItems.contains(itemId)) {
            if (itemsById.containsKey(itemId)
                && itemsById.get(itemId).size() % 3 == 0) {
                item.setPrice(new BigDecimal("0.00"));
            }
        }

    }

    private Item getItemById(long itemId) {
        //let's assume the price is also populated
        return new Item(itemId);
    }

    private class Item {
        private long id;
        private BigDecimal price = new BigDecimal("1.00");

        private Item(long id) {
            this.id = id;
        }

        public long getId() {
            return id;
        }

        public boolean isThreeForTwo() {
            return true;
        }

        @Override
        public String toString() {
            return "Item{" +
                   "id=" + id +
                   ", price=" + price +
                   '}';
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }
    }


}
