package com.vertex.academy.homework2;

import java.util.Random;

/**
 * Created by a on 10.02.17.
 */
public class Man implements People, Comparable<People> {

    private String[] names = {"Tom", "John", "Peter", "Mark", "Arnold"};
    private Random r = new Random();
    private final int length;
    private final String name; 

    public Man() {
        this.length = r.nextInt(100);
        this.name = names[r.nextInt(names.length)];
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getProperties() {
        return length;
    }

    @Override
    public String toString() {
        return "Man{" +
                "length=" + getProperties() +
                ", name='" + getName() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Man)) return false;

        Man man = (Man) o;

        return length == man.length;
    }

    @Override
    public int hashCode() {
        return length;
    }

    @Override
    public int compareTo(People o) {
        if (o instanceof Man) {
            if (o.getProperties() < this.getProperties()) {
                return -1;
            } else if (o.getProperties() == this.getProperties()) {
                return 0;
            } else return 1;
        } else return 1;
    }
}
