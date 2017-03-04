package com.vertex.academy.homework2;

import com.vertex.academy.homework2.hall.Listener;
import com.vertex.academy.homework2.hall.Ticket;
import com.vertex.academy.homework2.hall.TicketWindow;
import com.vertex.academy.homework2.hall.Winners;
import com.vertex.academy.homework2.people.Human;

import java.util.Map;

/**
 * Created by andrew_yashin on 2/5/17.
 */
public class Test {
    public static void main(String... args){
        Map<Ticket, Human> map = TicketWindow
                .getMap(new Listener(false,100).getQueue(),
                        10,
                        50);


        map.forEach((ticket, human) -> System.out.println(ticket + " = " + human));


        System.out.println(Winners.getWinners(map.values()));


    }


}
