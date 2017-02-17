package com.vertex.academy.homework2;

/**
 * Created by a on 17.02.17.
 */
public class Ticket {

    private int ticketNumber;
    private int rowNumber;
    private int seatNumber;


    private static int numberCounter = 1;

    public Ticket() {
        this.ticketNumber = numberCounter++;
        this.rowNumber = (int) (Math.random() * 100);
        this.seatNumber = (int) (Math.random() * 100);
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }


    public int getSeatNumber() {
        return seatNumber;

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;

        Ticket ticket = (Ticket) o;

        if (getTicketNumber() != ticket.getTicketNumber()) return false;
        if (getRowNumber() != ticket.getRowNumber()) return false;
        return getSeatNumber() == ticket.getSeatNumber();
    }

    @Override
    public int hashCode() {
        int result = getTicketNumber();
        result = 31 * result + getRowNumber();
        result = 31 * result + getSeatNumber();
        return result;
    }


    @Override
    public String toString() {
        return "Ticket{" +
                "ticketNumber=" + ticketNumber +
                ", rowNumber=" + rowNumber +
                ", seatNumber=" + seatNumber +
                '}';
    }

}