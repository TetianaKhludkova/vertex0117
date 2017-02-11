package com.vertex.academy.homework2.hall;

import com.vertex.academy.homework2.people.Human;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * Created by andrew_yashin on 2/5/17.
 */
public class Winners {

    char i = 064770;
    char b = 0xbeef;
    public static Collection<Human> getWinners(Collection<Human> list){
        HashSet<Human> set = new HashSet<>(list);
        for(Human human: set){
            System.out.println(human);
        }
        return list;
    }
}
