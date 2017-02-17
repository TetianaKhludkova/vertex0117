package com.vertex.academy.homeworkcollections.forticket;

import com.vertex.academy.homeworkcollections.forlistener.Listener;
import com.vertex.academy.homeworkcollections.forlistener.Listeners;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by Aile (on Valery) on 2/17/2017.
 */
public class BoxOffice {

    private static final int SEATS_IN_ROW = 8;
    private static final int ROWS = 1000;
    private int maxTicketsPerListener;

    public BoxOffice(int maxTicketsPerListener) {
        if (maxTicketsPerListener > 0) {
            this.maxTicketsPerListener = maxTicketsPerListener;
        } else {
            this.maxTicketsPerListener = 1;
        }
    }

    public HashMap<Ticket, Listener> GetMap(Listeners listeners) {

        HashMap<Ticket, Listener> map = new HashMap<>();
        Random randomizer = new Random();
        int row, seat, ticketsQuantity, i;
        Listener listener;

        while (!listeners.isEmpty()) {

            listener = listeners.removeFirst();

            ticketsQuantity = randomizer.nextInt(maxTicketsPerListener) + 1;

            for (i = 0; i < ticketsQuantity; i++) {

                row = randomizer.nextInt(ROWS) + 1;
                seat = randomizer.nextInt(SEATS_IN_ROW) + 1;
                map.put(new Ticket(row, seat), listener);

            }

        }

        return map;

    }

}
