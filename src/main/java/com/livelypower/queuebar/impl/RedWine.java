package com.livelypower.queuebar.impl;

import com.livelypower.queuebar.domain.DrinkType;
import com.livelypower.queuebar.domain.Drinkable;

import java.util.Objects;

public class RedWine implements Drinkable {

    private final String name;
    private final double price;
    private final DrinkType drinkType;

    public RedWine() {
        name = "Red Wine";
        price = 5.40;
        drinkType = DrinkType.ALCOHOLIC;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public DrinkType getDrinkType() {
        return drinkType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RedWine redWine = (RedWine) o;
        return Double.compare(redWine.price, price) == 0 &&
                Objects.equals(name, redWine.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "RedWine{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
