package com.vertex.academy.homework2;

/**
 * Created by a on 08.02.17.
 */

import java.util.*;

public class Listener {


    private PriorityQueue<People> sortedQueue;


    public void listen() {
        sortedQueue = new PriorityQueue<>(getComparator());
        PriorityQueue<People> customerQueue = new PriorityQueue<>(getComparator());
        for (int i = 0; i < Math.random() * 50; i++) {
            customerQueue.add(new Man());
            customerQueue.add(new Woman());
        }
        sortedQueue.addAll(customerQueue); // this is made for passing our queue to another queue, since the first will have been polled out to console
        while (!customerQueue.isEmpty()) {

            System.out.println(customerQueue.poll());
        }

    }

    public PriorityQueue<People> getSortedQueue() {
        return sortedQueue;
    }


    public static Comparator<People> getComparator() {
        return (o1, o2) -> {
            if ((o1 instanceof Man) && (o2 instanceof Man) || (o1 instanceof Woman) && (o2 instanceof Woman)) {
                if (o1.getProperties() < o2.getProperties()) {
                    return 1;
                } else if (o1.getProperties() > o2.getProperties()) {
                    return -1;
                } else return 0;
            } else if ((o1 instanceof Man) && (o2 instanceof Woman)) {
                return 1;
            } else return -1;
        };
    }

}

