package com.vertex.academy.homework2;

/**
 * Created by Tanya on 10.02.2017.
 */
public enum HumanEnum {
    MAN, Lady;

    public static HumanEnum getRandomHuman(){
        int random = (int)Math.round(Math.random());
        switch (random){
            case 0: return MAN;
            case 1: return Lady;
        }
        return null;
    }
}
