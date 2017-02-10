package com.vertex.academy.homework2;

/**
 * Created by a on 08.02.17.
 */


import java.util.*;

public class Listener {

    public static void main(String[] args) {


        PriorityQueue<People> customerPriorityQueue = new PriorityQueue<>(10,comparator);
       addDataToQueue(customerPriorityQueue);

        System.out.println(customerPriorityQueue);
    }

    public static Comparator<People> comparator = new Comparator<People>() {

        @Override
        public int compare(People p1, People p2) {
            if(p1.getClass().equals(p2.getClass())){
                if (p1.getProperties() < p2.getProperties()){
                    return 1;
                } else if(p1.getProperties() > p2.getProperties()){
                    return -1;
                } else return 0;
            } else if( (p1 instanceof Man) && (p2 instanceof Woman)){
                return 1;
            } else return -1;
        }
    };



    private static Collection<People> addDataToQueue(Collection<People> collection){
        for (int i=0; i<5;i++){
            collection.add(new Man());
collection.add(new Woman());
        }
        return collection;
    }




}

