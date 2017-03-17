package com.vertex.academy.homeworkgeneric;

import com.vertex.academy.homeworkcollections.Gender;
import com.vertex.academy.homeworkcollections.ReversedListenersComparator;
import com.vertex.academy.homeworkcollections.forlistener.Listener;
import com.vertex.academy.homeworkcollections.forlistener.Rogue;
import com.vertex.academy.homeworkgeneric.listenerexeptions.LackOfBroochesException;
import com.vertex.academy.homeworkgeneric.listenerexeptions.TooShortMustachesException;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

/**
 * Created by Aile (on Valery) on 3/10/2017.
 */
public class MainHomeworkGeneric {

    public MainHomeworkGeneric() {}

    private static void safeAddListenerToList(ListOfListeners<Listener> listOfListeners,
                                              int amountToAdd, Supplier<Listener> supplier) {

        Listener newListener;

        for (int i = 0; i < amountToAdd; i++) {
            newListener = supplier.get();
            try {
                listOfListeners.pushInOrder(newListener);
                listOfListeners.printList();
            } catch (LackOfBroochesException | TooShortMustachesException esteemException) {
                System.out.println("Listener " + newListener + " invokes: " + esteemException);
            }
        }

    }

    public static void start(){

        ReversedListenersComparator comparator = new ReversedListenersComparator();
        ListOfListeners<Listener> listOfListeners = new ListOfListeners<Listener>();
        Listener newListener;
        int i;

        listOfListeners.setComparator(comparator);

        safeAddListenerToList(listOfListeners, 10, Listener::getRandomListener);
        safeAddListenerToList(listOfListeners,
                3,
                () -> new Listener.Builder()
                        .setGender(Gender.GetRandomGender())
                        .setEsteem(0)
                        .Build());

        listOfListeners.setToComparable();

        safeAddListenerToList(listOfListeners, 10, Listener::getRandomListener);
        safeAddListenerToList(listOfListeners,
                3,
                () -> new Listener.Builder()
                        .setGender(Gender.GetRandomGender())
                        .setEsteem(0)
                        .Build());

        safeAddListenerToList(listOfListeners,
                6,
                () -> new Rogue(new Random().nextInt(100), Gender.GENTLEMAN));

    }

}
