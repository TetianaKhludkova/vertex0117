package com.vertex.academy.homework2;

import com.vertex.academy.homework2.people.People;

import java.util.Random;

/**
 * Created by a on 20.02.17.
 */
public class RogueDecorator implements People {

    People people;

    public RogueDecorator(People people) {
        this.people = people;
    }


    @Override
    public String getName() {
        return people.getName();
    }

    @Override
    public String toString() {
        return "(cheater)" + people +
                '}';
    }

    @Override
    public int getProperties() {
        return people.getProperties();
    }

}
