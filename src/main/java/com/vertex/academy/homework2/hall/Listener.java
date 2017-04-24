package com.vertex.academy.homework2.hall;

import com.vertex.academy.Tools;
import com.vertex.academy.homework2.people.Human;
import com.vertex.academy.homework2.people.Man;
import com.vertex.academy.homework2.people.PeopleGenerator;
import com.vertex.academy.homework2.people.Woman;
import static com.vertex.academy.Tools.printData;

import java.util.*;

/**
 * Created by andrew_yashin on 2/5/17.
 */
public class Listener {
    private static int counter = 0;
    private final int countListener = ++counter;
    private PriorityQueue<Human> queuePeople;
    private PriorityQueue<Human> queuePeopleGet;
    private Comparator<Human> comparator;
    // TODO: 24.04.17 not used
    private int countOfPeople;

    public Listener(boolean isComparator,int countOfPeople){
        this.countOfPeople = countOfPeople;
        System.out.println(" -- Queue #" + countListener + "\n");

        if(isComparator){
            comparator = (o1, o2) -> {
                if(o1.getClass().equals(o2.getClass())){
                    if (o1.getNumber() < o2.getNumber()){
                        return 1;
                    } else if(o1.getNumber() > o2.getNumber()){
                        return -1;
                    } else return 0;
                } else if( (o1 instanceof Man) && (o2 instanceof Woman)){
                    return 1;
                } else return -1;
            };

            queuePeople = new PriorityQueue<>(comparator);
            fillData(queuePeople, countOfPeople);
            System.out.println(" ---- With Comparator : ---- \n\n");
            queuePeopleGet = new PriorityQueue<>(queuePeople);
            printData(queuePeople);
        } else {
            queuePeople = new PriorityQueue<>();
            fillData(queuePeople, countOfPeople);
            System.out.println(" ---- With Comparable : ---- \n\n");
            queuePeopleGet = new PriorityQueue<>(queuePeople);
            printData(queuePeople);
        }
    }

    public Queue<Human> getQueue(){
        return queuePeopleGet;
    }

    private static Collection<Human> fillData(Collection<Human> collection, int count){
        while (count-- > 0){
            collection.add(PeopleGenerator.next());
        }
        return collection;
    }

}
