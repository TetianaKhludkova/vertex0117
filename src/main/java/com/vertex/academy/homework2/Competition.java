package com.vertex.academy.homework2;

import com.vertex.academy.homework2.human.Human;
import com.vertex.academy.homework2.human.Lady;
import com.vertex.academy.homework2.human.Man;

import java.util.ArrayList;
import java.util.LinkedHashMap;


/**
 * Created by Tanya on 16.02.2017.
 */
public class Competition {

    public static int startCompetition(LinkedHashMap<Ticket, Human> humanWithTicketsMap) {

         return (int)humanWithTicketsMap.values().stream().filter(human -> human.getClass().equals(Man.class))
                .filter( human -> human.getRespect()< getTheSmallestNumbers(humanWithTicketsMap)[1])
                .count();
        }


    private static int[] getTheSmallestNumbers(LinkedHashMap<Ticket, Human> humanWithTicketsMap){
        ArrayList<Human> humans = (ArrayList<Human>) humanWithTicketsMap.values();
        int theLeastLengthOfMustache= humans.get(0).getRespect();
        int theSmallestNumberOfBrooch = humans.get(0).getRespect();
        for (Human human: humans){
            if (human.equals(Man.class)){
                if (human.getRespect()<theLeastLengthOfMustache){
                    theLeastLengthOfMustache = human.getRespect();
                }
            }
            if (human.equals(Lady.class)){
                if (human.getRespect()<theSmallestNumberOfBrooch){
                    theSmallestNumberOfBrooch = human.getRespect();
                }
            }
        }
        int[] theSmallestNumbers = {theLeastLengthOfMustache, theSmallestNumberOfBrooch};
        return theSmallestNumbers;
    }
}
