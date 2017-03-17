package com.vertex.academy.homework2;

import lombok.Data;

import java.util.Random;

/**
 * Created by Tanya on 16.02.2017.
 */

@Data
class Ticket {

    private int numberOfTicket;
    private static int number = 0;
    private int numberOfPlace;
    private int numberOfRow;
    private boolean isWin;
    private static final int COUNT = 15;

    Ticket(){
        Random random = new Random();
        this.setNumberOfTicket(++number);
        this.setNumberOfPlace(random.nextInt(COUNT)+1);
        this.setNumberOfRow(random.nextInt(COUNT)+1);
        this.setWin(false);
    }

    boolean getIsWin() {
        return isWin;
    }

    @Override
    public String toString() {
        return "Ticket " + numberOfTicket +
                "{ numberOfPlace=" + numberOfPlace +
                ", numberOfRow=" + numberOfRow +
                ", isWin=" + isWin +
                "} ";
    }

}
