package com.livelypower.queuebar.impl;

import com.livelypower.queuebar.domain.Order;
import com.livelypower.queuebar.domain.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class DefaultOrder implements Order {

    private final List<Product> products;

    public DefaultOrder(List<OrderLine> products) {
        final List<Product> rawProcuducts = new ArrayList<>();
        products.forEach(orderLine -> IntStream.range(1, orderLine.getAmount()).forEach(i ->
                rawProcuducts.add(orderLine.getProduct())));

        this.products = rawProcuducts;
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultOrder that = (DefaultOrder) o;
        return Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products);
    }

    @Override
    public String toString() {
        return "DefaultOrder{" +
                "products=" + products +
                '}';
    }
}
