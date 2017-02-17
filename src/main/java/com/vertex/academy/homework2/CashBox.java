package com.vertex.academy.homework2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by a on 17.02.17.
 */
public class CashBox {

   private Map<Ticket,People> map;
    Map<Ticket, People> getTicket(PriorityQueue<People> people){
           map = new LinkedHashMap<>();

         people.forEach( (People p)-> map.put(new Ticket(),p));
        return map;
    }

    public Map<Ticket, People> getMap() {
        return map;
    }
}
