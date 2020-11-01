package com.livelypower.queuebar.impl;

import com.livelypower.queuebar.domain.Product;

import java.util.Objects;

public class OrderLine {

    private final Product product;
    private final int amount;

    public OrderLine(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLine orderLine = (OrderLine) o;
        return amount == orderLine.amount &&
                Objects.equals(product, orderLine.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, amount);
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "product=" + product +
                ", amount=" + amount +
                '}';
    }
}
