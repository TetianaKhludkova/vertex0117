package com.vertex.academy.homework2.hall;

/**
 * Created by andrew_yashin on 2/5/17.
 */
public class Ticket {
    private static int idCounter = 0;
    private final int id = idCounter++;
    private int seat;
    private int row;
    private boolean isWinner = false;

    public Ticket(int row, int seat) {
        this.seat = seat;
        this.row = row;
    }

    public int getId() {
        return id;
    }

    public int getSeat() {
        return seat;
    }

    public int getRow() {
        return row;
    }

    public boolean getWinner() {
        return isWinner;
    }

    public void setWinner() {
        isWinner = true;
    }


    @Override
    public String toString() {
        return  String.format("Ticket #%2d (R=%2d, S=%3d)", id, row, seat);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (id != ticket.id) return false;
        if (seat != ticket.seat) return false;
        return row == ticket.row;
    }



    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + seat;
        result = 31 * result + row;
        return result;
    }
}
