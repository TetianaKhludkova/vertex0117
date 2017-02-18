package com.vertex.academy.homework2;

import com.vertex.academy.homework2.people.People;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

/**
 * Created by vertex0007 on 11.02.2017.
 */
public class MainClass {
    public static void main(String[] args) {

        Listener listener = new Listener();      // task 1
        System.out.println("PRINTING THE LISTENERS QUEUE...\n");
        listener.listen();


        CashBox cashBox = new CashBox();         // task2.0
        Map<Ticket, People> listenerMap = cashBox.getTicket(listener.getSortedQueue());
        System.out.println("\nPRINTING THE LISTENERS'S LOCATION IN THE HALL...\n");
        listenerMap.entrySet().forEach(System.out::println);

        Contest contest = new Contest();        // task 2.1
        System.out.println("\nOUR WINNERS ARE....\n");
        System.out.println(contest.getWinners(listenerMap));

    }
}
