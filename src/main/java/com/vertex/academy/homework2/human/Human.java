package com.vertex.academy.homework2.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static com.vertex.academy.homework2.Main.listeners;

/**
 * Created by Tanya on 10.02.2017.
 */
public class Human implements Comparator<Human>, Comparable<Human> {

    private int id;
    private int amountOfTickets;
    static final int MAX_AMOUNT_OF_Tickets = 5;

    public int getId() {
        return id;
    }

    public int getAmountOfTickets() {
        return amountOfTickets;
    }

    public void setAmountOfTickets(int amountOfTickets) {
        this.amountOfTickets = amountOfTickets;
    }

    public int getRespect() {
        return 0;
    }

    public ArrayList<Human> createHumanQueue(int countOfPeople){
        HumanEnum randomHuman;
        for (int i = 0; i<countOfPeople; i++){
            randomHuman = HumanEnum.getRandomHuman();
            assert randomHuman != null;
            switch (randomHuman){
                case MAN:  listeners.add(new Man());
                case Lady: listeners.add(new Lady());
                    //default: listeners.add(new Lady());
            }
        }
        return listeners;
    }

    public ArrayList<Human> sortByRespect() {
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

    @Override
    public int compare(Human o1, Human o2) {
        if ((o1.getClass().equals(Man.class)) && (o2.getClass().equals(Lady.class))) {
            return 1;
        } else if ((o1.getClass().equals(Man.class)) && (o2.getClass().equals(Man.class))) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public int compareTo(Human o) {
        if (this.getRespect()<o.getRespect()){
            return 1;
        } else if (this.getRespect()==o.getRespect()){
            return 0;
        } else if (this.getRespect()>o.getRespect()){
            return -1;
        }
        return 0;

    }


}
