package com.vertex.academy.homework2;

import java.util.Random;

/**
 * Created by Tanya on 16.02.2017.
 */
class Ticket {
    private int numberOfTicket = 0;
    private static int number = 0;
    private int numberOfPlace;
    private int numberOfRow;
    private boolean isWin;
    private static final int COUNT_OF_PLACES = 15;
    private static final int COUNT_OF_ROWS = 20;


    Ticket(){
        Random random = new Random();
        this.setNumberOfTicket(++number);
        this.setNumberOfPlace(random.nextInt(COUNT_OF_PLACES)+1);
        this.setNumberOfRow(random.nextInt(COUNT_OF_ROWS)+1);
        this.isWin = false;
    }

    public int getNumberOfTicket() {
        return numberOfTicket;
    }

    private void setNumberOfTicket(int numberOfTicket) {
        this.numberOfTicket = numberOfTicket;
    }

    public int getNumberOfPlace() {
        return numberOfPlace;
    }

    private void setNumberOfPlace(int numberOfPlace) {
        this.numberOfPlace = numberOfPlace;
    }

    public int getNumberOfRow() {
        return numberOfRow;
    }

    private void setNumberOfRow(int numberOfRow) {
        this.numberOfRow = numberOfRow;
    }

    public boolean getIsWin() {
        return isWin;
    }

    public void setIsWin(boolean win) {
        isWin = win;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (numberOfTicket != ticket.numberOfTicket) return false;
        return numberOfPlace == ticket.numberOfPlace && numberOfRow == ticket.numberOfRow;

    }

    @Override
    public int hashCode() {
        int result = numberOfTicket;
        result = 31 * result + numberOfPlace;
        result = 31 * result + numberOfRow;
        return result;
    }

    @Override
    public String toString() {
        return "Ticket " + numberOfTicket +
                "{ numberOfPlace=" + numberOfPlace +
                ", numberOfRow=" + numberOfRow +
                '}';
    }


}
