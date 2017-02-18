package com.vertex.academy.homework2.people;

import java.util.Random;

/**
 * Created by a on 10.02.17.
 */
public class Man implements People {

    private String[] names = {"Tom", "John", "Peter", "Mark", "Arnold"};
    private Random r = new Random();
    private final int mustacheLength;
    private final String name;

    public Man() {
        this.mustacheLength = r.nextInt(100);
        this.name = names[r.nextInt(names.length)];
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getProperties() {
        return mustacheLength;
    }

    @Override
    public String toString() {
        return "Man{" +
                "mustacheLength=" + getProperties() +
                ", name='" + getName() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Man)) return false;

        Man man = (Man) o;

        return mustacheLength == man.mustacheLength;
    }

    @Override
    public int hashCode() {
        return mustacheLength;
    }
}
