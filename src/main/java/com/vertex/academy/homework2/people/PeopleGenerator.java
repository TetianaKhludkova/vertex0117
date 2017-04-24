package com.vertex.academy.homework2.people;

import java.util.Random;

/**
 * Created by andrew_yashin on 2/5/17.
 */
public class PeopleGenerator {
    // TODO: 24.04.17 they are not used. Please delete them 
    private static final int MAN_IND = 0;
    private static final int WOMAN_IND = 1;
    private static Random random = new Random();

    public static Human next(){
        switch (random.nextInt(2)){
            case 0: return new Man();
            default: return new Woman();
        }
    }
}
