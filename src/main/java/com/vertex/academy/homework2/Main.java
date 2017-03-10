package com.vertex.academy.homework2;

import com.vertex.academy.homework2.human.Crock;
import com.vertex.academy.homework2.human.Human;
import com.vertex.academy.homework2.human.HumanQueue;
import com.vertex.academy.homework3.Exceptions.LackOfBroochesException;
import com.vertex.academy.homework3.Exceptions.TooShortMustachesException;
import com.vertex.academy.homework3.MyLinkedList;

import java.util.*;

/**
 * Created by Tanya on 05.02.2017.
 */
public class Main {

    public static LinkedList<Human> listeners = new LinkedList<>();
    private static LinkedHashMap<Ticket, Human> humanWithTicketsMap;
    private static final int INITIAL_COUNT_OF_PEOPLE = 30;

    public static void main(String[] args) {

        HumanQueue humanQueue = new HumanQueue();
        listeners = humanQueue.addHumanToQueue(INITIAL_COUNT_OF_PEOPLE);
        listeners = humanQueue.addHumanToQueue(3);

       MyLinkedList<Human> myLinkedList = new MyLinkedList<>();
       myLinkedList.addAndPrintListeners();

        new Main().sort();

        humanWithTicketsMap = (new TicketWindow()).sellTicket(listeners);
        System.out.println(humanWithTicketsMap);

        Competition.startCompetitionByTheLeastRespect(humanWithTicketsMap);
        Competition.printCompetitionByTheGreatestNumberOfTickets(humanWithTicketsMap);

        HashSet<Crock> crockHashSet = Competition.startCompetitionByTheGreatestNumberOfTicketsForCrocks(humanWithTicketsMap);
        if (crockHashSet.size()!=0) {
            System.out.println("\nCrocks: \n" + crockHashSet);
        }else {
            System.out.printf("There are no crocks!)");
        }
    }

    private void sort(){
        listeners.sort(new Human());
        System.out.println("\n========== sortedByGender ============\n"+ listeners);

        new Human().sortByRespect();
        System.out.println("========== sortedByRespect ============\n"+ listeners);
    }

}