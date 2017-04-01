package com.vertex.academy.homework2.people;

import com.vertex.academy.homework2.people.Human;

import java.util.Random;

/**
 * Created by andrew_yashin on 2/5/17.
 */
public class Man implements Human, Comparable<Human> {
    private static int countMan = 0;
    private final int id = ++countMan;
    private int length;
    private final String name;
    private Random random = new Random();
    private String[] names = { "John", "Steve", "Andrew", "Mike" };
    private String[] surnames = {"Black", "White", "Kashpirovskiy", "Yashin", "Rudyka"};

    public Man(int length, String name) {
        this.length = length;
        this.name = (name == null) ? "James" : name;
    }

    public Man(){
        this.length = random.nextInt(10);
        this.name = names[random.nextInt(names.length)] + " "
                + surnames[random.nextInt(surnames.length)];
    }

    public int getNumber() {
        return length;
    }

    public String getName() {
        return name;
    }

    public int getId() { return id; }

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
        return "#" + String.format("%2d",id) + " " + this.getClass().getSimpleName() + " --- " +
                "(" + this.getName()  +
                " ," + this.getNumber() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Man man = (Man) o;

        if (id != man.id) return false;
        if (length != man.length) return false;
        return name != null ? name.equals(man.name) : man.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + length;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
