package com.vertex.academy.homework2;

import com.vertex.academy.homework2.people.People;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by a on 17.02.17.
 */
public class Contest {

    public Collection<People> getWinners(Map<Ticket, People> philharmonicMap) {
        final Set<People> res = new HashSet<>();
        philharmonicMap.values().stream().sorted(Listener.getComparator())
                .collect(Collectors.partitioningBy(people -> people.getClass().getName().equals("com.vertex.academy.homework2.people.Man")))
                .values().forEach(list -> res.add(list.get(list.size() - 1)));
        return res;
    }
}
