package com.livelypower.queuebar.impl;

import com.livelypower.queuebar.domain.Edible;
import com.livelypower.queuebar.domain.FoodType;

import java.util.Objects;

public class Cereal implements Edible {

    private final String name;
    private final FoodType foodType;
    private final double price;

    public Cereal() {
        price = 2.30;
        foodType = FoodType.BREAKFAST;
        name = "Cereal";
    }

    @Override
    public FoodType getFoodType() {
        return foodType;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cereal cereal = (Cereal) o;
        return Double.compare(cereal.price, price) == 0 &&
                Objects.equals(name, cereal.name) &&
                foodType == cereal.foodType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, foodType, price);
    }

    @Override
    public String toString() {
        return "Cereal{" +
                "name='" + name + '\'' +
                ", foodType=" + foodType +
                ", price=" + price +
                '}';
    }
}
