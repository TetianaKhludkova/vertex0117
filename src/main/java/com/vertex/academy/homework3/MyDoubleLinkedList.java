package com.vertex.academy.homework3;

import com.vertex.academy.homework2.people.Human;
import com.vertex.academy.homework2.people.Man;
import com.vertex.academy.homework3.exceptions.LackOfBroochesException;
import com.vertex.academy.homework3.exceptions.TooShortMustashesException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Iterator;
import java.util.List;

/**
 * Created by andrew_yashin on 3/9/17.
 */
public class MyDoubleLinkedList<T extends Human> implements Iterable<T> {
    private Node prev;
    private Node head;
    private Node first;
    private int size = 0;

    private int minimalLength, minimalCount;

    public MyDoubleLinkedList(int minimalLength, int minimalCount) {
        this.minimalLength = minimalLength;
        this.minimalCount = minimalCount;
    }

    @Data
    @AllArgsConstructor
    @Getter
    @Setter
    private class Node {
        Node next;
        T instance;
        Node prev;
    }

    public void add(T element) throws TooShortMustashesException, LackOfBroochesException{

        Class clazz = element.getClass();

        if(clazz == Man.class) {
            if (element.getNumber() < minimalLength) {
                throw new TooShortMustashesException();
            }
        } else {
            if (element.getNumber() < minimalCount){
                throw new LackOfBroochesException();
            }
        }
        size++;
        Node node = new Node(head, element, prev);

        if(first == null){
            first = node;
        }

        if(head != null) {
            head.prev = node;
        }

        head = node;
        prev = node.next;
        head = node;
    }

    public T popLast(){
        T element = head.getInstance();
        head = head.next;

        return element;
    }

    public T popFirst(){
        T element = first.getInstance();
        first = first.prev;

        return element;
    }

    public T peekFirst(){
        return first.getInstance();
    }

    public T peekLast(){
        return head.getInstance();
    }

    public int size(){
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyListIterator();
    }

    private class MyListIterator implements Iterator<T>{
        private Node element = first;

        @Override
        public boolean hasNext() {
            return (element != null);
        }

        @Override
        public T next() {
            T value = element.instance;
            element = element.next;
            return value;
        }
    }
}

