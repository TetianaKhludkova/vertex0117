package com.vertex.academy.homework2.hall;

import com.vertex.academy.homework2.people.Human;
import com.vertex.academy.homework2.people.Man;
import org.omg.CORBA.MARSHAL;

import java.util.*;

/**
 * Created by andrew_yashin on 2/5/17.
 */
public class Winners {
    public static Collection<Human> getWinners(Collection<Human> list){
        Comparator<Human> comparator =
                (o1, o2) -> {
                    if (o1.getNumber() > o2.getNumber()) return -1;
                    else if(o1.getNumber() < o2.getNumber()) return 1;
                    else return 0;
                };

        List<Human>
                listMen = new ArrayList<>(),
                listWomen = new ArrayList<>();

        for (Human human: list){
            if(human instanceof Man){
                listMen.add(human);
            } else listWomen.add(human);
        }

        Collections.sort(listMen, comparator);
        Collections.sort(listWomen, comparator);

        for(Human human: listMen){
            System.out.println(human);
        }





        return null;
    }
}
