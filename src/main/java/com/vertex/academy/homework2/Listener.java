package com.vertex.academy.homework2;

/**
 * Created by a on 08.02.17.
 */

import java.util.*;

public class Listener {
    public static void main(String[] args) {

        Comparator<People> comparator = (o1, o2) -> {
            if (o1.getClass().equals(o2.getClass())) {
                if (o1.getProperties() < o2.getProperties()) {
                    return 1;
                } else if (o1.getProperties() > o2.getProperties()) {
                    return -1;
                } else return 0;
            } else if ((o1 instanceof Man) && (o2 instanceof Woman)) {
                return 1;
            } else return -1;
        };
        PriorityQueue<People> customerPriorityQueue = new PriorityQueue<>(comparator);
        for (int i = 0; i < 5; i++) {
            customerPriorityQueue.add(new Man());
            customerPriorityQueue.add(new Woman());
        }

        int count = 0;
        while (!customerPriorityQueue.isEmpty()) {
            System.out.println(++count + ": " + customerPriorityQueue.poll());
        }

    }


}

