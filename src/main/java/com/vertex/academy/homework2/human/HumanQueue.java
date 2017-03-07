package com.vertex.academy.homework2.human;

import com.vertex.academy.homework2.MyLinkedList;

import java.util.LinkedList;

import static com.vertex.academy.homework2.Main.listeners;

/**
 * Created by Tanya on 22.02.2017.
 */
public class HumanQueue<Human> implements HumanObserver{

    private Observers<HumanQueue> observers = null;

    public LinkedList<Human> addHumanToQueue(int countOfPeople) {
        HumanEnum randomHuman;
        for (int i = 0; i < countOfPeople; i++) {
            randomHuman = HumanEnum.getRandomHuman();
            assert randomHuman != null;
            switch (randomHuman) {
                case MAN:
                    listeners.add(new Man());
                    break;
                case Lady:
                    listeners.add(new Lady());
                    break;
                default: return null;
            }
        }

        if (observers == null) {
            observers = new Observers<>();
            observers.add(new HumanQueue());
            observers.notifyObjectCreated(this);
        }else{
            observers.notifyObjectModified(this);
        }
        return (LinkedList<Human>) listeners;
    }


    public MyLinkedList addHumanToMyLinkedList(int countOfPeople) {
        HumanEnum randomHuman;
        MyLinkedList myLinkedList = new MyLinkedList<>();
        for (int i = 0; i < countOfPeople; i++) {
            randomHuman = HumanEnum.getRandomHuman();
            assert randomHuman != null;
            switch (randomHuman) {
                case MAN:
                    myLinkedList.add( new Man());
                    break;
                case Lady:
                    myLinkedList.add( new Lady());
                    break;
                default: return null;
            }
        }

        return myLinkedList;
    }

    @Override
    public void objectCreated(Object obj) {
        System.out.println("Human queue is created. Size: "+listeners.size()+". Queue:\n"+ listeners);
    }

    @Override
    public void objectModified(Object obj) {
        System.out.println("Human queue is modified. Size: "+listeners.size()+". Queue:\n"+listeners);
    }

}
