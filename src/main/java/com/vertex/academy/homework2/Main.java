package com.vertex.academy.homework2;

import com.vertex.academy.homework2.human.Human;
import com.vertex.academy.homework2.human.HumanQueue;

import java.util.*;


/**
 * Created by Tanya on 05.02.2017.
 */
public class Main {

    public static ArrayList<Human> listeners = new ArrayList<>();
    private static LinkedHashMap<Ticket, Human> humanWithTicketsMap;

    public static void main(String[] args) {

        HumanQueue humanQueue = new HumanQueue();
        listeners = humanQueue.addHumanToQueue(30);
        listeners = humanQueue.addHumanToQueue(3);

        Collections.sort(listeners, new Human());
        System.out.println("\n========== sortedByGender ============\n"+ listeners);

        new Human().sortByRespect();
        System.out.println("========== sortedByRespect ============\n"+ listeners);

        System.out.println("\nListeners bought tickets: ");
        humanWithTicketsMap = (new TicketWindow()).sellTicket(listeners);
        System.out.println(humanWithTicketsMap);

        Competition.startCompetitionByTheLeastRespect(humanWithTicketsMap);

        Competition.startCompetitionByTheGreatestNumberOfTickets(humanWithTicketsMap);
    }
}