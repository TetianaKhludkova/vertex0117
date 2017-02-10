package com.vertex.academy.homework2;

import java.util.*;

/**
 * Created by Tanya on 05.02.2017.
 */
public class Listener{

    public static ArrayList<HumanInterface> listeners = new ArrayList<>();

    public static void main(String[] args){
        Listener listener = new Listener();
        listener.createHumanQueue(30);
        System.out.println("============ no sorted ==============");
        System.out.println(listeners);
        System.out.println("========== sortedByGender ============");
        Collections.sort(listeners, new sortByGender());
        System.out.println(listeners);
        System.out.println("========== sortedByRespect ============");
        listeners = listener.sortByRespect();
        System.out.println(listeners);

    }

    public ArrayList<HumanInterface> createHumanQueue(int countOfPeople){
        HumanEnum randomHuman;
        for (int i=0; i<countOfPeople; i++){
            randomHuman = HumanEnum.getRandomHuman();
            switch (randomHuman){
                case MAN:  listeners.add(new Man());
                case Lady: listeners.add(new Lady());
            }
        }
        return listeners;
    }

    public ArrayList<HumanInterface> sortByRespect() {
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

            for (int i = 0; i < ladies.size() - 1; i++) {
                ladies.get(i).compareTo(ladies.get(i + 1));
                listeners.add(ladies.get(i));
            }
            for (int i = 0; i < men.size() - 1; i++) {
                men.get(i).compareTo(men.get(i + 1));
                listeners.add(men.get(i));
            }

//            listeners.addAll(ladies);
//            listeners.addAll(men);
        }
        return listeners;
    }

}
