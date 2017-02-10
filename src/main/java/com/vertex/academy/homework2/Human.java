package com.vertex.academy.homework2;

import java.util.Comparator;

/**
 * Created by Tanya on 10.02.2017.
 */
class Human implements Comparator<Human>, Comparable<Human> {
    @Override
    public int compareTo(Human o) {
            if (this.getRespect()<o.getRespect()){
                return 1;
            } else if (this.getRespect()==o.getRespect()){
                return 0;
            } else if (this.getRespect()>o.getRespect()){
                return -1;
            }
            return 0;

        }


    public void buyTicket() {

    }


    public int getRespect() {
        return 0;
    }

    @Override
    public int compare(Human o1, Human o2) {
        if ((o1.getClass().equals(Man.class)) && (o2.getClass().equals(Lady.class))) {
            return 1;
        } else if ((o1.getClass().equals(Man.class)) && (o2.getClass().equals(Man.class))) {
            return 0;
        } else {
            return -1;
        }
    }
}
