package com.vertex.academy.homework2;

import com.vertex.academy.homework2.human.Human;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;


/**
 * Created by Tanya on 05.02.2017.
 */
public class Main {

    public static ArrayList<Human> listeners = new ArrayList<>();
    private static LinkedHashMap<Ticket, Human> humanWithTicketsMap;

    public static void main(String[] args){
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

        System.out.println("Listeners bought tickets: \n");
        TicketWindow ticketWindow = new TicketWindow();
        humanWithTicketsMap = ticketWindow.sellTicket(listeners);
        System.out.println(humanWithTicketsMap);

        System.out.println("\n Competition is started!\n...");
       // System.out.println(Competition.startCompetition((LinkedHashMap<Ticket, Human>) humanWithTicketsMap));

    }


}
