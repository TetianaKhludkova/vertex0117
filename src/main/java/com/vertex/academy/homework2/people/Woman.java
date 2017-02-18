package com.vertex.academy.homework2.people;

import java.util.Random;

/**
 * Created by a on 10.02.17.
 */
public class Woman implements People {
    private String[] names = {"Jessika", "Anastasia", "Miranda", "Anetta", "Julie"};
    private Random r = new Random();
    private final int broachQuantity;
    private final String name;


    public Woman() {
        this.broachQuantity = r.nextInt(100);
        this.name = names[r.nextInt(names.length)];
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getProperties() {
        return broachQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Woman)) return false;

        Woman woman = (Woman) o;

        return broachQuantity == woman.broachQuantity;
    }

    @Override
    public String toString() {
        return "Woman{" +
                "broachQuantity=" + getProperties() +
                ", name='" + getName() + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return broachQuantity;
    }
}