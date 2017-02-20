package com.vertex.academy.homework2;

import com.vertex.academy.homework2.people.People;

import java.util.*;

/**
 * Created by a on 20.02.17.
 */
public class MoreThanOne {

    public Set<People> getMoreThanOneListener(Map<Ticket, People> listenerMap) {
        List<Ticket> ticketList = new ArrayList<>(listenerMap.keySet());
        List<People> peopleList = new ArrayList<>(listenerMap.values());
        Set<People> peopleSet = new HashSet<>();
        for (int i = 0; i < ticketList.size() - 1; i++) {
            for (int j = i + 1; j < ticketList.size(); j++) {
                if ((ticketList.get(i).getSeatNumber())==(ticketList.get(j).getSeatNumber())) {
                    peopleSet.add(peopleList.get(i));
                    break;
                }
            }
        }
        return peopleSet;
    }
}
