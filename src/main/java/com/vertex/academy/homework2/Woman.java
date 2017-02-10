package com.vertex.academy.homework2;

import java.util.Random;

/**
 * Created by a on 10.02.17.
 */
public class Woman implements People, Comparable<People> {
    private String[] names = {"Jessika", "Anastasia", "Miranda", "Anetta", "Julie"};
    private Random r = new Random();
    private final int quantity;
    private final String name;


    public Woman() {
        this.quantity = r.nextInt(100);
        this.name = names[r.nextInt(names.length)];
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getProperties() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Woman)) return false;

        Woman woman = (Woman) o;

        return quantity == woman.quantity;
    }

    @Override
    public String toString() {
        return "Woman{" +
                "quantity=" + getProperties() +
                ", name='" + getName() + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return quantity;
    }

    @Override
    public int compareTo(People o) {
        if (o instanceof Woman) {
            if (this.getProperties() < (o).getProperties()) {
                return 1;
            } else if (this.getProperties() > (o).getProperties()) {
                return -1;
            } else return 0;
        } else return -1;

    }
}