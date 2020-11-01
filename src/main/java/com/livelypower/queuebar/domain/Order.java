package com.livelypower.queuebar.domain;

import java.util.List;

public interface Order {

    List<Product> getProducts();

    default double getTotalPrice() {
        if (getProducts().size() > 0) {
            return getProducts().stream().mapToDouble(Product::getPrice).reduce(Double::sum).orElseThrow();
        }
        return 0;
    }
}
