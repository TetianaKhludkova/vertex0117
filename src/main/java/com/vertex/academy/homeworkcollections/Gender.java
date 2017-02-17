package com.vertex.academy.homeworkcollections;

import java.util.Random;

/**
 * Created by Aile (on Valery) on 2/10/2017.
 */
public enum Gender{
    GENTLEMAN, LADY;

    public static Gender GetRandomGender() {

        Random randomizer = new Random();
        Gender newGender = Gender.GENTLEMAN;

        if (randomizer.nextInt(2) != 0) {
            newGender = Gender.LADY;
        }

        return newGender;

    }
}
