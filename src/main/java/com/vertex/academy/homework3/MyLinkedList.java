package com.vertex.academy.homework3;

import com.vertex.academy.homework2.human.*;
import com.vertex.academy.homework3.Exceptions.LackOfBroochesException;
import com.vertex.academy.homework3.Exceptions.TooShortMustachesException;

import lombok.AllArgsConstructor;
import lombok.Data;

public class MyLinkedList<T extends Human>  {
    private Holder next;
    private Holder head;
    private Holder first;
    private int size = 0;
    private static final int MIN_RESPECT = 1;

    @Data
    @AllArgsConstructor
    private class Holder {
        Holder previous;
        T instance;
        Holder next;
    }

    private void add(T element) throws TooShortMustachesException, LackOfBroochesException {

        Class clazz = element.getClass();

        if(clazz.isInstance(Man.class)){
            if (element.getRespect() < MIN_RESPECT) {
                throw new TooShortMustachesException();
            }
        } else {
            if (element.getRespect() < MIN_RESPECT){
                throw new LackOfBroochesException();
            }
        }

        size++;
        Holder holder = new Holder(head, element, next);

        if(first == null){
            first = holder;
        }
        if(head != null) {
            head.next = holder;
        }

        head = holder;
        next = holder.previous;
    }

    private T popFirst(){
        T element = first.getInstance();
        first = first.next;

        return element;
    }

    private int size(){
        return size;
    }


    public void addAndPrintListeners() {
        MyLinkedList<Human> list = new MyLinkedList<>();

        for(int i = 0; i < 10; i++){
            try{
                list.add(HumanQueue.getHuman());
            } catch (TooShortMustachesException | LackOfBroochesException e){
                System.out.println(e.getMessage() + " in " + i);
            }
        }

        System.out.println("\n Listeners from myLinkedList:\n");
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.popFirst());
        }
    }

}