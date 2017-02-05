package com.vertex.academy.homework2.hall;

import com.vertex.academy.homework2.people.Human;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

/**
 * Created by andrew_yashin on 2/5/17.
 */
public class TicketWindow {

    public static Map<Ticket, Human> getMap(Queue<Human> queue, int countRows, int countSeats) {
        Map<Ticket, Human> map = new
                HashMap<>();

        Random random = new Random();
        ConcertHall hall = new ConcertHall(countRows, countSeats);

        while (!queue.isEmpty()) {
            switch (random.nextInt(2)) {
                case 0:
                    Ticket ticket = hall.nextTicket();
                    if (ticket == null) {
                        return map;
                    } else {
                        map.put(ticket, queue.peek());
                        break;
                    }

                case 1:
                    Ticket ticket1 = hall.nextTicket();
                    if (ticket1 == null) {
                        return map;
                    } else {
                        map.put(ticket1, queue.remove());
                        break;
                    }
            }
        }
        return map;
    }
}
