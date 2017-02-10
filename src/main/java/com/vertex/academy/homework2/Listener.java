package com.vertex.academy.homework2;


import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Tanya on 05.02.2017.
 */
public class Listener{

    private static ArrayList<Human> listeners = new ArrayList<>();

    public static void main(String[] args){
        Listener listener = new Listener();
        listener.createHumanQueue(30);
        System.out.println("============ no sorted ==============");
        System.out.println(listeners);
        System.out.println("========== sortedByGender ============");
        Collections.sort(listeners, new Human());
        System.out.println(listeners);
        System.out.println("========== sortedByRespect ============");
        listener.sortByRespect();
        System.out.println(listeners);

    }

    private ArrayList<Human> createHumanQueue(int countOfPeople){
        HumanEnum randomHuman;
        for (int i=0; i<countOfPeople; i++){
            randomHuman = HumanEnum.getRandomHuman();
            switch (randomHuman){
                case MAN:  listeners.add(new Man());
                case Lady: listeners.add(new Lady());
                default: listeners.add(new Lady());
            }
        }
        return listeners;
    }

    private ArrayList<Human> sortByRespect() {
        if (listeners.size() > 1) {
            ArrayList<Lady> ladies = new ArrayList<>();
            ArrayList<Man> men = new ArrayList<>();
            for (int i = 0; i < listeners.size() - 1; i++) {
                if (listeners.get(i).getClass().equals(Lady.class)) {
                    ladies.add((Lady) listeners.get(i));
                }
                if (listeners.get(i).getClass().equals(Man.class)) {
                    men.add((Man) listeners.get(i));
                }
            }
            listeners.removeAll(listeners);

            Collections.sort(ladies);
            Collections.sort(men);
            listeners.addAll(ladies);
            listeners.addAll(men);

        }
        return listeners;


    }

}
