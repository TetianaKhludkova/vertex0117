package com.vertex.academy.homeworkcollections.forlistener;

import com.vertex.academy.homeworkcollections.Gender;

import java.util.*;
import java.util.function.Supplier;

/**
 * Created by Aile (on Valery) on 2/15/2017.
 */
public class Listeners {

    private ArrayList<Listener> listenersList;
    private Comparator<Listener> comparator;

    public Listeners() {
        this.listenersList = new ArrayList<Listener>();
    }

    public Listener removeFirst() {

        if (this.listenersList.isEmpty()) {
            throw new IndexOutOfBoundsException("Listeners is empty!");
        } else {
            return listenersList.remove(0);
        }

    }

    public boolean isEmpty() {
        return this.listenersList.isEmpty();
    }

    public void setComparator(Comparator<Listener> comparator) {
        this.comparator = comparator;
        (this.listenersList).sort(this.comparator);
    }

    public void setToComparable() {
        this.comparator = null;
        Collections.sort(this.listenersList);
    }

    public Listener addRandomListener(Supplier<Listener> supplier) {

        Listener listener;

        listener = supplier.get();

        this.addListener(listener);

        return listener;

    }

    public boolean addListener(Listener listener) {

        boolean result = true;
        int index;

        if (listener == null) {
            result = false;
        } else if (this.listenersList.isEmpty()) {
            this.listenersList.add(listener);
        } else {
            index = searchInsertIndex(listener);
            this.listenersList.add(index, listener);
        }

        if (result) {
            this.printListeners();
        }

        return result;

    }

    private int searchInsertIndex(Listener listener) {

        int result;
        int startIndex = 0;
        int endIndex = listenersList.size() - 1;

        if (compareWithCurrentComparator(listener, this.listenersList.get(startIndex)) <= 0) {
            result = startIndex;
        } else if (compareWithCurrentComparator(listener, this.listenersList.get(endIndex)) >= 0) {
            result = endIndex + 1;
        } else {
            while (startIndex < endIndex) {
                if (compareWithCurrentComparator(listener, this.listenersList.get((startIndex + endIndex) / 2)) < 0) {
                    endIndex = (startIndex + endIndex) / 2;
                } else {
                    startIndex = (startIndex + endIndex) / 2 + 1;
                }
            }
            result = startIndex;
        }

        return result;

    }

    private int compareWithCurrentComparator(Listener listener1, Listener listener2) {

        int result;

        if (this.comparator == null) {
            result = listener1.compareTo(listener2);
        } else {
            result = comparator.compare(listener1, listener2);
        }

        return result;

    }

    private void printListeners() {

        System.out.println("Listeners List(" + this.listenersList.size() + "):");

        listenersList.forEach(System.out::println);

    }

}
