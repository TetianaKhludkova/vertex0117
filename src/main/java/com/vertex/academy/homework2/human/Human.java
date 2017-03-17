package com.vertex.academy.homework2.human;

import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static com.vertex.academy.homework2.Main.listeners;

/**
 * Created by Tanya on 10.02.2017.
 */

@Getter
@Setter
public class Human implements Comparator<Human>, Comparable<Human> {

    private int id, respect;
    private int amountOfTickets;
    static final int MAX_AMOUNT_OF_TICKETS = 5;

    LinkedList<Human> sortByRespect() {
        if (listeners.size() > 1) {
            List<Human> ladies = getHumansSorted(Lady.class);
            List<Human> men = getHumansSorted(Man.class);

            listeners.removeAll(listeners);
            listeners.addAll(ladies);
            listeners.addAll(men);
            return listeners;
        }
        return null;
    }

    private List<Human> getHumansSorted(Class clazz) {
        return listeners.stream().filter(listeners->listeners.getClass().equals(clazz))
                .sorted(Human::compareTo)
                .collect(Collectors.toList());
    }

    @Override
    public int compare(Human o1, Human o2) {
        if ((o1.getClass().equals(Man.class)) && (o2.getClass().equals(Lady.class))) {
            return 1;
        } else if ((o1.getClass().equals(Man.class)) && (o2.getClass().equals(Man.class))) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public int compareTo(Human o) {
        if (this.getRespect()<o.getRespect()){
            return 1;
        } else if (this.getRespect()==o.getRespect()){
            return 0;
        } else if (this.getRespect()>o.getRespect()){
            return -1;
        }
        return 0;

    }


}
