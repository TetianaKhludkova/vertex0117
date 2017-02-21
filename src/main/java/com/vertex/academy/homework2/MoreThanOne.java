package com.vertex.academy.homework2;

import com.vertex.academy.homework2.people.People;

import java.lang.reflect.Field;
import java.util.*;

/**
 * 20.02.17.
 */
public class MoreThanOne {

    public Set<People> getMoreThanOneListener(Map<Ticket, People> listenerMap) throws Exception {
        List<Ticket> ticketList = new ArrayList<>(listenerMap.keySet());
        List<People> peopleList = new ArrayList<>(listenerMap.values());
        Set<People> peopleSet = new HashSet<>();
        for (int i = 0; i < ticketList.size() - 1; i++) {
            for (int j = i + 1; j < ticketList.size(); j++) {
                if ((ticketList.get(i).getSeatNumber()) == (ticketList.get(j).getSeatNumber())) {
                    peopleSet.add(peopleList.get(i));
                    break;
                }
            }
        }

        // ADDING CHEATERS TO SET (our cheaters use reflection to falsify the private ticket fields)
        Random r = new Random();
        People rogue = new RogueDecorator(peopleList.get(r.nextInt(peopleList.size())));
        peopleSet.add(rogue);
        System.out.println(rogue);
        Field field = RogueDecorator.class.getDeclaredField("people");
        field.setAccessible(true);
        field.set(rogue, peopleList.get(r.nextInt(peopleList.size())));

        System.out.println("same cheater falsified the ticket and got twice under the other name:" + rogue.getName() + ", " + rogue.getProperties() + "\n\n");
        peopleSet.add(rogue);


        return peopleSet;

    }
}
