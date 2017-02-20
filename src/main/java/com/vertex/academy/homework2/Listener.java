package com.vertex.academy.homework2;

/**
 * Created by a on 08.02.17.
 */

import com.vertex.academy.homework2.people.Man;
import com.vertex.academy.homework2.people.People;
import com.vertex.academy.homework2.people.Woman;

import java.util.*;

import static java.lang.Math.*;

public class Listener {


    private PriorityQueue<People> sortedQueue;


    public void listen() {
        sortedQueue = new PriorityQueue<>(getComparator());
        PriorityQueue<People> customerQueue = new PriorityQueue<>(getComparator());
        Random r = new Random();
        for (int i = 0; i < random() * 100; i++) {

            switch (r.nextInt(2)) {
                case 0:
                    customerQueue.add(new Woman());
                case 1:
                    customerQueue.add(new Man());
            }


        }
        sortedQueue.addAll(customerQueue); // this is made for passing our queue to another queue, since the first one will have been polled out to console
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

