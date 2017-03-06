package com.vertex.academy.homework2;

import com.vertex.academy.homework2.human.Human;
import com.vertex.academy.homework2.human.Lady;
import com.vertex.academy.homework2.human.Man;

import java.util.*;
import java.util.stream.Collectors;


/**
 * Created by Tanya on 16.02.2017.
 */
class Competition {

    //methods for competition by the least respect
    private static int[] getTheSmallestRespect(LinkedHashMap<Ticket, Human> humanWithTicketsMap){
        Human theSmallestNumberOfBrooch = humanWithTicketsMap.values().stream()
                .filter(human -> human.getClass().equals(Lady.class))
                .min(Comparator.comparingInt(Human::getRespect))
                .get();

        Human theLeastLengthOfMustache = humanWithTicketsMap.values().stream()
                .filter(human -> human.getClass().equals(Man.class))
                .min(Comparator.comparingInt(Human::getRespect))
                .get();

        return new int[]{theLeastLengthOfMustache.getRespect(), theSmallestNumberOfBrooch.getRespect()};
    }

    private static void markWinTicketsByRespect(LinkedHashMap<Ticket, Human> humanWithTicketsMap){
        int theLeastLengthOfMustache = getTheSmallestRespect(humanWithTicketsMap)[0];
        int theSmallestNumberOfBrooch = getTheSmallestRespect(humanWithTicketsMap)[1];

        Set<Map.Entry<Ticket, Human>> set = humanWithTicketsMap.entrySet();

        set.stream().filter( human ->
                human.getValue().getRespect()== theLeastLengthOfMustache & human.getValue().getRespect()== theSmallestNumberOfBrooch)
                .forEach( human -> human.getKey().setIsWin(true));
    }

    static void startCompetitionByTheLeastRespect(LinkedHashMap<Ticket, Human> humanWithTicketsMap){
        System.out.println("\nCompetition for the least number of respect is started!...\nWinners: ");
        Competition.markWinTicketsByRespect(humanWithTicketsMap);
        Set<Map.Entry<Ticket, Human>> entrySet = humanWithTicketsMap.entrySet();
        entrySet.stream().filter(hum -> hum.getKey().getIsWin())
                .forEach( hum -> System.out.println(hum.getValue()+ ":  "+hum.getKey()));
    }

    //Methods for competition by the greatest number of tickets
    private static int getTheGreatestNumberOfTickets(List<Human> list){
        Human theGreatestNumberOfTickets = list.stream()
                .max(Comparator.comparingInt(Human::getAmountOfTickets))
                .get();
        return theGreatestNumberOfTickets.getAmountOfTickets();
    }

    private static List<Human> findListOfHumanWithTheGreatestNumberOfTickets(List<Human> list){
        int theGreatestNumberOfTickets = getTheGreatestNumberOfTickets(list);
        return list.stream().filter(human -> human.getAmountOfTickets() == theGreatestNumberOfTickets)
                .collect(Collectors.toList());
    }

    static void startCompetitionByTheGreatestNumberOfTickets(LinkedHashMap<Ticket, Human> humanWithTicketsMap) {
        System.out.println("\nCompetition for the greatest number of tickets is started!...\nWinners: ");
        List<Human> listOfWinnersByNumberOfTickets = humanWithTicketsMap.values().stream().distinct().collect(Collectors.toList());
        listOfWinnersByNumberOfTickets = Competition.findListOfHumanWithTheGreatestNumberOfTickets(listOfWinnersByNumberOfTickets);
        for (Human hum : listOfWinnersByNumberOfTickets) {
            System.out.println(hum.getClass().getSimpleName() + hum.getId() + ": amount of tickets: " + hum.getAmountOfTickets());
        }
    }
}
