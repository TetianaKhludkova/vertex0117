package com.vertex.academy.homework2;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by vertex0007 on 11.02.2017.
 */
public class MainClass {
    public static void main(String[] args) {

        Listener listener = new Listener();    // task 1
        listener.listen();


        CashBox cashBox = new CashBox();         // task2.0
        Map<Ticket, People> map = cashBox.getTicket(listener.getSortedQueue());
        map.entrySet().forEach(System.out::println);

    }
}
