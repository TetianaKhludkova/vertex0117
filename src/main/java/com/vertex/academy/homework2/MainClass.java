package com.vertex.academy.homework2;

import com.vertex.academy.homework2.people.People;

import java.util.Map;
import java.util.Set;

/**
 * 11.02.2017.
 */
public class MainClass {
    public static void main(String[] args) throws Exception {

        Listener listener = new Listener();      // task 1
        System.out.println("PRINTING THE LISTENERS QUEUE...\n");
        listener.listen();


        CashBox cashBox = new CashBox();         // task2.0
        Map<Ticket, People> listenerMap = cashBox.getTicket(listener.getSortedQueue());
        System.out.println("\nPRINTING THE LISTENERS'S LOCATION IN THE HALL...\n");
        listenerMap.entrySet().forEach(System.out::println);

        Contest contest = new Contest();        // task 2.1
        System.out.println("\nOUR PRISE WINNERS ARE....\n");
        System.out.println(contest.getWinners(listenerMap));

        MoreThanOne moreThanOne = new MoreThanOne();   //task 3, task 4
        System.out.println("\nTHOSE, WHO HAS GOT MORE, THAN ONE SEAT, ARE...\n");
        Set<People> moreThanOneListener = moreThanOne.getMoreThanOneListener(listenerMap);
        if (!moreThanOneListener.isEmpty())
            System.out.println(moreThanOneListener);
        else System.out.println("Unfortunately there is no people, who have bought more, than one.");


    }
}
