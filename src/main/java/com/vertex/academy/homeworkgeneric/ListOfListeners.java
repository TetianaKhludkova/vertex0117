package com.vertex.academy.homeworkgeneric;

import com.oracle.jrockit.jfr.Producer;
import com.vertex.academy.homeworkcollections.Gender;
import com.vertex.academy.homeworkcollections.forlistener.Listener;
import com.vertex.academy.homeworkgeneric.listenerexeptions.LackOfBroochesException;
import com.vertex.academy.homeworkgeneric.listenerexeptions.TooShortMustachesException;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * Created by Aile (on Valery) on 3/10/2017.
 */
public class ListOfListeners<T extends Listener> {

    private Node<T> top;
    private Comparator<Listener> comparator;

    private static Integer minPinCount = 0;
    private static Integer minMustacheLength = 0;

    public ListOfListeners() {
        top = null;
    }

    public void setComparator(Comparator<Listener> comparator) {
        this.comparator = comparator;
        this.sort();
    }

    public void setToComparable() {
        this.comparator = null;
        this.sort();
    }

    public void pushInOrder(T item) throws LackOfBroochesException, TooShortMustachesException {

        Node<T> current = top;
        boolean inserted = false;
        boolean firstRound = true;

        if (item == null) {
            return;
        }

        int esteem = item.getEsteem();

//        if (item.getGender() == Gender.LADY) {
//            if (esteem <= minPinCount) {
//                throw new LackOfBroochesException();
//            }
//        } else {
//            if (esteem <= minMustacheLength) {
//                throw new TooShortMustachesException();
//            }
//        }

        if (item.getGender() == Gender.LADY) {
            if (item.compareTo(new Listener.Builder()
                                    .setGender(Gender.LADY)
                                    .setEsteem(minPinCount)
                                    .Build()) >= 0) {
                throw new LackOfBroochesException();
            }
        } else {
            if (item.compareTo(new Listener.Builder()
                                    .setGender(Gender.GENTLEMAN)
                                    .setEsteem(minMustacheLength)
                                    .Build()) >= 0) {
                throw new TooShortMustachesException();
            }
        }

        if (top == null) {
            top = new Node<T>(item, null, null);
        } else {

            do {

                if (firstRound){
                    firstRound = false;
                } else {
                    current = current.next;
                }

                if (CompareItems(item, current.item) <= 0) {

                    insertBefore(current, item);
                    inserted = true;
                    break;

                }

            } while (!current.end());

            if (!inserted) {
                insertAfter(current, item);
            }

        }

    }

    public T pop() {

        T result;

        if (top == null) {
            result = null;
        } else {

            result = top.item;

            if (!top.end()) {
                top = top.next;
                top.previous = null;
            } else {
                top = null;
            }

        }

        return result;

    }

    public void printList() {

        Node<T> current = top;

        System.out.println("List of listeners:");

        while (!current.end()) {
            System.out.println(current.item);
            current = current.next;
        }

        System.out.println(current.item);

    }

    private void insertAfter(Node<T> node, T itemToInsertAfter) {

        Node<T> oldNext = node.next;

        if (!node.end()) {
            oldNext.previous = node.next;
        }

        node.next = new Node<T>(itemToInsertAfter, node, oldNext);

    }

    private void insertBefore(Node<T> node, T itemToInsertBefore) {

        Node<T> oldPrevious = node.previous;

        node.previous = new Node<T>(itemToInsertBefore, oldPrevious, node);

        if (node == top) {
            top = node.previous;
        } else {
            oldPrevious.next = node.previous;
        }

    }

    private int CompareItems(T item1, T item2) {

        int result;

        if (this.comparator == null) {
            result = item1.compareTo(item2);
        } else {
            result = comparator.compare(item1, item2);
        }

        return result;

    }

    private void sort() {

        Node<T> oldTop = top;
        boolean firstRound = true;

        top = null;

        if (!(oldTop == null)) {
            do {

                if (firstRound) {
                    firstRound = false;
                } else {
                    oldTop = oldTop.next;
                }

                try {
                    this.pushInOrder(oldTop.item);
                } catch (LackOfBroochesException|TooShortMustachesException esteemException) {
                    System.out.println("Listener " + oldTop.item + " invokes(in sort): " + esteemException);
                }

            } while (!oldTop.end());
        }

    }

    private static class Node<U> {

        U item;
        Node<U> next;
        Node<U> previous;

        Node(U item, Node<U> previous, Node<U> next) {

            this.item = item;
            this.previous = previous;
            this.next = next;

        }

        boolean end() {
            return next == null;
        }

    }

}
