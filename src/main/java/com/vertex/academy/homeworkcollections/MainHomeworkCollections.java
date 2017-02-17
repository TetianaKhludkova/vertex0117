package com.vertex.academy.homeworkcollections;

import com.vertex.academy.homeworkcollections.forlistener.Listener;
import com.vertex.academy.homeworkcollections.forlistener.Listeners;
import com.vertex.academy.homeworkcollections.forlistener.Rogue;
import com.vertex.academy.homeworkcollections.forticket.BoxOffice;
import com.vertex.academy.homeworkcollections.forticket.Ticket;

import java.util.*;

/**
 * Created by Aile (on Valery) on 2/10/2017.
 */
public class MainHomeworkCollections {

    public MainHomeworkCollections() {}

    private static Listeners problem1() {

        ReversedListenersComparator comparator = new ReversedListenersComparator();
        Listeners listeners = new Listeners();
        int i;

        listeners.setComparator(comparator);

        for (i = 0; i < 15; i++) {
            listeners.addRandomListener();
        }

        listeners.setToComparable();

        for (i = 0; i < 15; i++) {
            listeners.addRandomListener();
        }

        return listeners;

    }

    private static HashMap<Ticket, Listener> problem2(Listeners listeners, BoxOffice boxOffice) {

        HashMap<Ticket, Listener> map;
        int minMustacheLength, minPinCount;

        map = boxOffice.GetMap(listeners);

        map.forEach((ticket, listener) -> System.out.println(ticket + " for " + listener));

        minMustacheLength = map.values().stream()
                .filter((listener) -> listener.getGender() == Gender.GENTLEMAN)
                .max(Listener::compareTo)
                .get()
                .getEsteem();

        minPinCount = map.values().stream()
                .filter((listener) -> listener.getGender() == Gender.LADY)
                .max(Listener::compareTo)
                .get()
                .getEsteem();

        map.forEach((ticket, listener) -> {
            int esteem = listener.getEsteem();
            if ((listener.getGender() == Gender.GENTLEMAN && esteem == minMustacheLength)
                    || (listener.getGender() == Gender.LADY && esteem == minPinCount)) {
                ticket.makeWinner();
            }
        });

        map.forEach((ticket, listener) -> {
            if (ticket.Winner()) {
                String esteemText = listener.getGender() == Gender.GENTLEMAN ? "mustache": "pin";
                System.out.println("Winner: " + ticket + "; " + esteemText + ": " + listener.getEsteem());
            }
        });

        return map;

    }

    private static HashSet<Listener> problem3(Collection<Listener> collection) {

        HashSet<Listener> set = new HashSet<>();
        HashSet<Listener> resultSet = new HashSet<>();

        for (Listener listener : collection) {

            if (!set.add(listener)) {
                resultSet.add(listener);
            }

        }

        System.out.println("Half-price for:");
        resultSet.forEach(System.out::println);

        return resultSet;

    }

    private static void problem4(HashSet<Listener> set) {

        Rogue rogue = new Rogue(50, Gender.GENTLEMAN);

        set.add(rogue);

        do {
            rogue.resetEsteem(rogue.getEsteem() + 100);
        } while (!set.add(rogue));

        System.out.println("Half-price for(corrected):");
        set.forEach(System.out::println);

    }

    public static void start() {

        BoxOffice boxOffice = new BoxOffice(2);
        HashMap<Ticket, Listener> map;
        HashSet<Listener> set;

        Listeners listeners = problem1();

        map = problem2(listeners, boxOffice);

        set = problem3(map.values());

        problem4(set);

    }

}
