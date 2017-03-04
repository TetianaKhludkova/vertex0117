package com.vertex.academy.homework2.people;

import com.vertex.academy.homework2.people.Human;

import java.util.Random;

/**
 * Created by andrew_yashin on 2/5/17.
 */
public class Woman implements Human, Comparable<Human> {
    private static int countWoman = 0;
    private final int id = ++countWoman;
    private final int count;
    private final String name;
    private Random random = new Random();
    private String[] names = { "Kate", "Nicky", "Veron", "Sasha"};
    private String[] surnames = {"Black", "White", "Kashpirovskiy", "Yashin", "Rudyka"};


    public Woman(int count, String name) {
        this.count = count;
        this.name = name;
    }

    public Woman(){
        this.count = random.nextInt(10);
        this.name = names[random.nextInt(names.length)] + " "
                + surnames[random.nextInt(surnames.length)];
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return count;
    }

    public int getId() { return id; }
    @Override
    public int compareTo(Human o) {
        if(o instanceof Woman){
            if(this.getNumber() < ((Woman) o).getNumber()){
                return 1;
            } else if (this.getNumber() > ((Woman) o).getNumber()){
                return -1;
            } else return 0;
        } else return -1;
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

        Woman woman = (Woman) o;

        if (id != woman.id) return false;
        if (count != woman.count) return false;
        return name != null ? name.equals(woman.name) : woman.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + count;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
