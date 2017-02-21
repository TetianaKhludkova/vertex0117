package com.vertex.academy.homework2;

import com.vertex.academy.homework2.human.Human;

import java.util.*;
import java.util.stream.Collectors;


/**
 * Created by Tanya on 05.02.2017.
 */
public class Main {

    public static ArrayList<Human> listeners = new ArrayList<>();
    private static LinkedHashMap<Ticket, Human> humanWithTicketsMap;

    public static void main(String[] args) {

        Human human = new Human();
        listeners = human.createHumanQueue(30);
        System.out.println("============ no sorted ==============");
        System.out.println(listeners);
        System.out.println("========== sortedByGender ============");
        Collections.sort(listeners, new Human());
        System.out.println(listeners);
        System.out.println("========== sortedByRespect ============");
        human.sortByRespect();
        System.out.println(listeners);

        System.out.println("\nListeners bought tickets: ");
        TicketWindow ticketWindow = new TicketWindow();
        humanWithTicketsMap = ticketWindow.sellTicket(listeners);
        System.out.println(humanWithTicketsMap);

        System.out.println("\nCompetition for the least number of respect is started!...\nWinners: ");
        Competition.setWinTicketsByRespect(humanWithTicketsMap);
        Set<Map.Entry<Ticket, Human>> entrySet = humanWithTicketsMap.entrySet();
        entrySet.stream().filter(hum -> hum.getKey().getIsWin())
                .forEach( hum -> System.out.println(hum.getValue()+ ":  "+hum.getKey()));

        System.out.println("\nCompetition for the greatest number of tickets is started!...\nWinners: ");
        List<Human> listOfWinnersByNumberOfTickets = humanWithTicketsMap.values().stream().distinct().collect(Collectors.toList());
        listOfWinnersByNumberOfTickets =  Competition.startCompetitionByGreatestNumberOfTickets(listOfWinnersByNumberOfTickets);
        for (Human hum: listOfWinnersByNumberOfTickets) {
            System.out.println(hum.getClass().getSimpleName()+hum.getId()+": amount of tickets: "+hum.getAmountOfTickets());
        }
    }
}