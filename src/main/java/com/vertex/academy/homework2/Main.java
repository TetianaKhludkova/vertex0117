package com.vertex.academy.homework2;

import com.vertex.academy.homework2.human.Human;
import com.vertex.academy.homework2.human.HumanQueue;
import com.vertex.academy.homework2.human.Man;

import java.util.*;

/**
 * Created by Tanya on 05.02.2017.
 */
public class Main {

    public static ArrayList<Human> listeners = new ArrayList<>();
    private static LinkedHashMap<Ticket, Human> humanWithTicketsMap;
    private static final int INITIAL_COUNT_OF_PEOPLE = 30;

    public static void main(String[] args) {

        HumanQueue humanQueue = new HumanQueue();
        listeners = humanQueue.addHumanToQueue(INITIAL_COUNT_OF_PEOPLE);
        listeners = humanQueue.addHumanToQueue(3);

        new Main().sort();

        humanWithTicketsMap = (new TicketWindow()).sellTicket(listeners);
        System.out.println(humanWithTicketsMap);

        Competition.startCompetitionByTheLeastRespect(humanWithTicketsMap);

        Competition.startCompetitionByTheGreatestNumberOfTickets(humanWithTicketsMap);
    }

    private void sort(){
        listeners.sort(new Human());
        System.out.println("\n========== sortedByGender ============\n"+ listeners);

        new Human().sortByRespect();
        System.out.println("========== sortedByRespect ============\n"+ listeners);
    }

}