package com.vertex.academy.homeworkcollections.forticket;

/**
 * Created by Aile (on Valery) on 2/17/2017.
 */
public class Ticket {

    private int number, row, seat;
    private boolean isWinner;

    private static int lastNumber = 0;

    public Ticket(int row, int seat) {

        lastNumber = lastNumber + 1;
        this.number = lastNumber;
        this.row = row;
        this.seat = seat;
        this.isWinner = false;

    }

    public void makeWinner() {
        this.isWinner = true;
    }

    public boolean Winner() {
        return this.isWinner;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o instanceof Ticket) return false;

        Ticket ticket = (Ticket) o;

        if (number != ticket.number) return false;
        if (row != ticket.row) return false;
        return seat == ticket.seat;

    }

    @Override
    public int hashCode() {

        int result = number;

        result = 31 * result + row;
        result = 31 * result + seat;

        return result;

    }

    @Override
    public String toString() {
        return "Ticket{" +
                "number=" + number +
                ", row=" + row +
                ", seat=" + seat +
                '}';
    }

}
