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

     static void setWinTicketsByRespect(LinkedHashMap<Ticket, Human> humanWithTicketsMap){
        int theLeastLengthOfMustache = getTheSmallestNumbers(humanWithTicketsMap)[0];
        int theSmallestNumberOfBrooch = getTheSmallestNumbers(humanWithTicketsMap)[1];

        Set<Map.Entry<Ticket, Human>> set = humanWithTicketsMap.entrySet();

        set.stream().filter(human -> human.getValue().getClass().equals(Man.class))
                .filter( human -> human.getValue().getRespect()== theLeastLengthOfMustache)
                .forEach( human -> human.getKey().setIsWin(true));
        set.stream().filter(human -> human.getValue().getClass().equals(Lady.class))
                .filter( human -> human.getValue().getRespect()== theSmallestNumberOfBrooch)
                .forEach( human -> human.getKey().setIsWin(true));
    }

     static List<Human> startCompetitionByGreatestNumberOfTickets(List<Human> list){
        int theGreatestNumberOfTickets = getTheGreatestNumberOfTickets(list);
        return list.stream().filter(human -> human.getAmountOfTickets() == theGreatestNumberOfTickets)
                .collect(Collectors.toList());
    }

    private static int[] getTheSmallestNumbers(LinkedHashMap<Ticket, Human> humanWithTicketsMap){
        Collection<Human> humans = humanWithTicketsMap.values();
        int theLeastLengthOfMustache = humans.iterator().next().getRespect();
        int theSmallestNumberOfBrooch = humans.iterator().next().getRespect();
        for (Human human: humans){
            if (human.getClass().equals(Man.class)){
                if (human.getRespect()<theLeastLengthOfMustache){
                    theLeastLengthOfMustache = human.getRespect();
                }
            }
            if (human.getClass().equals(Lady.class)){
                if (human.getRespect()<theSmallestNumberOfBrooch){
                    theSmallestNumberOfBrooch = human.getRespect();
                }
            }
        }
        return new int[]{theLeastLengthOfMustache, theSmallestNumberOfBrooch};
    }

    private static int getTheGreatestNumberOfTickets(List<Human> list){

        int theGreatestNumberOfTickets = list.iterator().next().getAmountOfTickets();
        for (Human human: list){
                if (human.getAmountOfTickets()>theGreatestNumberOfTickets){
                    theGreatestNumberOfTickets = human.getAmountOfTickets();
                }
        }
        return theGreatestNumberOfTickets;
    }

}
