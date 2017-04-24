package com.vertex.academy.homework2.hall;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by andrew_yashin on 2/5/17.
 */
public class ConcertHall {
    private int countOfRows, countOfSeats, countOfTickets;
    private int checkerOfTickets = 0;
    private boolean[][] seats;
    private Random random;

    public ConcertHall(int countOfRows, int countOfSeats){
        System.out.println("\nTotal seats = " + (this.countOfTickets = countOfRows * countOfSeats));
        this.countOfRows = countOfRows;
        this.countOfSeats = countOfSeats;

        seats = new boolean[countOfRows][countOfSeats];

        for(int i = 0; i < countOfRows; i++){
            Arrays.fill(seats[i], false);
        }
        random = new Random();
    }

    public Ticket nextTicket(){
        if (checkerOfTickets < countOfTickets) {
            checkerOfTickets++;

            while (true) {
                int row = random.nextInt(countOfRows);
                int seat = random.nextInt(countOfSeats);

                // TODO: 24.04.17 it will not return unique tickets (you don't mark them as sold)
                // TODO: 24.04.17 and it could take a lot of time to heat a correct ticket
                if(!seats[row][seat]) {
                    return new Ticket(row, seat);
                }
            }
        } else {
            System.out.println(" --- There are no available tickets in the TICKET WINDOW --- ");
            return null;
        }
    }
}
