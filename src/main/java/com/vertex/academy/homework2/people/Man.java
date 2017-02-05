package com.vertex.academy.homework2.people;

import com.vertex.academy.homework2.people.Human;

import java.util.Random;

/**
 * Created by andrew_yashin on 2/5/17.
 */
public class Man implements Human, Comparable<Human> {
    private final int length;
    private final String name;
    private Random random = new Random();
    private String[] names = { "John", "Steve", "Andrew", "Mike" };

    public Man(int length, String name) {
        this.length = length;
        this.name = name;
    }

    public Man(){
        this.length = random.nextInt(50);
        this.name = names[random.nextInt(names.length)];
    }

    public int getNumber() {
        return length;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Human o) {
        if (o instanceof Man)
            if (((Man) o).getNumber() < this.getNumber()) {
                return -1;
            } else if(((Man) o).getNumber() == this.getNumber()){
                return 0;
            } else return 1;
        else return 1;
    }

    @Override
    public String toString() {
        return " " + this.getClass().getSimpleName() + " --- " +
                "(" + this.getName()  +
                " ," + this.getNumber() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Man man = (Man) o;

        return length == man.length;
    }

    @Override
    public int hashCode() {
        return length;
    }
}
