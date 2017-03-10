package com.vertex.academy.homework2.human;

import java.util.LinkedList;
import static com.vertex.academy.homework2.Main.listeners;

/**
 * Created by Tanya on 22.02.2017.
 */
public class HumanQueue<T extends Human> implements HumanObserver{

    private Observers<HumanQueue> observers = null;

    public static Human getHuman(){
        HumanEnum randomHuman;
        randomHuman = HumanEnum.getRandomHuman();
        assert randomHuman != null;
        switch (randomHuman) {
            case MAN:
                return new Man();
            case Lady:
                return new Lady();
            default: return null;
        }
    }

    public LinkedList<Human> addHumanToQueue(int countOfPeople) {

        for (int i = 0; i < countOfPeople; i++) {
            listeners.add(getHuman());
            listeners.sort(new Human());
            new Human().sortByRespect();
        }

        if (observers == null) {
            observers = new Observers<>();
            observers.add(new HumanQueue());
            observers.notifyObjectCreated(this);
        }else{
            observers.notifyObjectModified(this);
        }
        return listeners;
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
