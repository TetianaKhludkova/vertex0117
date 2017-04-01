package com.vertex.academy.homework3;

import com.vertex.academy.homework2.people.Human;
import com.vertex.academy.homework2.people.PeopleGenerator;
import com.vertex.academy.homework3.exceptions.LackOfBroochesException;
import com.vertex.academy.homework3.exceptions.TooShortMustashesException;

import java.lang.reflect.Field;
import java.util.stream.Stream;

/**
 * Created by andrew_yashin on 4/1/17.
 */
public class Test {
    public static void main(String[] args) {
        MyDoubleLinkedList<Human> list =
                new MyDoubleLinkedList<>(3,4);


        hackIt(list);
        for(int i = 0; i < 10; i++){
            try{
                list.add(PeopleGenerator.next());
            } catch (TooShortMustashesException e){
                System.err.println(e.getMessage() + " in " + i);
            } catch (LackOfBroochesException e){
                System.err.println(e.getMessage() + " in " + i);
            }
        }

        for (int i = 0; i < list.size(); i++){
            System.out.println(list.popFirst());
        }


    }

    public static void hackIt(MyDoubleLinkedList linkedList){
        try {
            Field minimalCount = linkedList.getClass().getDeclaredField("minimalCount");
            Field minimalLength = linkedList.getClass().getDeclaredField("minimalLength");

            minimalCount.setAccessible(true);
            minimalLength.setAccessible(true);

            minimalCount.set(linkedList, -1);
            minimalLength.set(linkedList, -1);
        } catch (NoSuchFieldException e){
            e.printStackTrace();
        } catch (IllegalAccessException e){
            e.printStackTrace();
        }
    }
}
