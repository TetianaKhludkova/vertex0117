package com.vertex.academy.homework3;

import com.vertex.academy.homework2.human.*;
import com.vertex.academy.homework3.Exceptions.LackOfBroochesException;
import com.vertex.academy.homework3.Exceptions.TooShortMustachesException;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Field;

public class MyLinkedList<T extends Human>  {
    private Holder next;
    private Holder head;
    private Holder first;
    private int size = 0;
    private static final int MIN_RESPECT = 1;
    private static final int NUMBER_OF_Listeners = 10;

    @Data
    @AllArgsConstructor
    private class Holder {
        Holder previous;
        T instance;
        Holder next;
    }

    private void add(T element) throws TooShortMustachesException, LackOfBroochesException {

        Class clazz = element.getClass();

        if(clazz == Man.class){
            if (element.getRespect() < MIN_RESPECT) {
                throw new TooShortMustachesException();
            }
        } else if (clazz == Lady.class){
            if (element.getRespect() < MIN_RESPECT){
                throw new LackOfBroochesException();
            }
        }

        if(clazz == Crock.class) {
            try {
                Field fieldOfRespect = clazz.getField("respect");
                fieldOfRespect.setAccessible(true);
                int newRespect = 10;
                fieldOfRespect.set(element, newRespect);
            } catch (NoSuchFieldException e) {
                System.out.println("NoSuchFieldException "+e);
            } catch (IllegalAccessException e) {
                System.out.println("IllegalAccessException "+e);
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


    public MyLinkedList<? extends Human> addListeners() {
        MyLinkedList<Human> humanMyLinkedList = new MyLinkedList<>();

        for(int i = 0; i < NUMBER_OF_Listeners/2; i++){
            try{
                humanMyLinkedList.add(HumanQueue.getHuman());
            } catch (TooShortMustachesException | LackOfBroochesException e){
                System.out.println(e.getMessage());
            }
        }

        for(int i = 0; i < NUMBER_OF_Listeners/2; i++){
            try{
                String gender = "Crock "+HumanEnum.getRandomHuman();
                humanMyLinkedList.add(new Crock(i, 0, gender, Crock.MIN_RESPECT));
            } catch (TooShortMustachesException | LackOfBroochesException e){
                System.out.println(e.getMessage());
            }
        }

        return humanMyLinkedList;
    }

    public void printListeners(MyLinkedList list) {
        System.out.println("\n Listeners from myLinkedList:\n");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.popFirst());
        }
    }

}