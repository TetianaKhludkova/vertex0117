package com.vertex.academy;

import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by andrew_yashin on 2/5/17.
 */
public class Tools {
    public static <T> void printData(Queue<T> queue){
        int count = 0;
        while (!queue.isEmpty()){
            System.out.println(++count + ": " + queue.poll());
        }
    }

    public static <T> void printData(List<T> list){
        for(T item: list){
            System.out.println(list.indexOf(item) + ": " + item);
        }
    }

    public static <T> void printData(Set<T> set){
        int count = 0;
        for(T item: set){
            System.out.println(++count + ": " + item);
        }
    }
}
