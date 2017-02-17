package com.vertex.academy.homeworkcollections;

import com.vertex.academy.homeworkcollections.forlistener.Listener;

import java.util.Comparator;

/**
 * Created by Aile (on Valery) on 2/17/2017.
 */
public class ReversedListenersComparator implements Comparator<Listener>
{

    public ReversedListenersComparator() {}

    @Override
    public int compare(Listener o1, Listener o2) {

        int result;

        if (o1 == null) {
            if (o2 == null) {
                result = 0;
            } else {
                result = o2.compareTo(null);
            }
        } else {
            result = - o1.compareTo(o2);
        }

        return result;

    }

}
