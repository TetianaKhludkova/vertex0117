package com.vertex.academy.homework2;

import com.vertex.academy.homework2.people.Man;
import com.vertex.academy.homework2.people.People;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by a on 17.02.17.
 */
public class Contest {

    public Collection<People> getWinners(Map<Ticket, People> philharmonicMap) {
        try {
            return philharmonicMap.values().stream()
                    .sorted(Listener.getComparator())
                    .collect(Collectors.partitioningBy(Man.class::isInstance))
                    .values().stream().map(list -> Collections.singletonList(list.get(list.size() - 1))).collect(ArrayList::new, ArrayList::addAll, ArrayList::addAll);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("There is only one gender, who presents in the queue, so no prise for another.");
            return Collections.EMPTY_LIST;
        }
    }
}
