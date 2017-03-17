package com.vertex.academy.homeworkcollections.forlistener;

import com.vertex.academy.homeworkcollections.Gender;
import com.vertex.academy.homeworkgeneric.ListOfListeners;

import java.lang.reflect.Field;

/**
 * Created by Aile (on Valery) on 2/17/2017.
 */
public class Rogue extends Listener {

    private int esteem;

    @Override
    public String toString() {
        return "Rogue{ " + this.getGender() +
                ", esteem=" + this.getEsteem() +
                ", realEsteem=" + super.getEsteem() +
                '}';
    }

    public Rogue(int esteem, Gender gender) {

        this.esteem = esteem;
        super.gender = gender;

    }

    public void resetEsteem(int esteem) {

        this.esteem = esteem;

    }

    @Override
    public int compareTo(Listener listener) {

        Class<?> listOfListenersClass = ListOfListeners.class;

        try {

            Field field = listOfListenersClass.getDeclaredField("minPinCount");
            field.setAccessible(true);
            if ((int)field.get(null) != -1) {
                field.set(null, -1);
            }

            field = listOfListenersClass.getDeclaredField("mustacheLength");
            field.setAccessible(true);
            if ((int)field.get(null) != -1) {
                field.set(null, -1);

            }
        } catch (NoSuchFieldException|IllegalAccessException e) {
            //suppress all
        }

        return -3;

    }

    @Override
    public int getEsteem() {
        return this.esteem;
    }
}
