package com.vertex.academy.homework2;

import com.vertex.academy.homework2.human.Human;

import java.util.*;

/**
 * Created by Tanya on 16.02.2017.
 */
class TicketWindow{

    LinkedHashMap<Ticket, Human> sellTicket(ArrayList<Human> listeners){
        LinkedHashMap<Ticket, Human> humanWithTicketsMap = new LinkedHashMap<>();

        for (Human listener: listeners){
            for (int i = 0; i < listener.getAmountOfTickets(); i++) {
                Ticket ticket = new Ticket();
                humanWithTicketsMap.put(ticket, listener);
            }
        }

        return humanWithTicketsMap;
    }
}
