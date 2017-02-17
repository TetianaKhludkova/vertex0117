package com.vertex.academy.homework2;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by a on 17.02.17.
 */
public class Contest {

    public Collection<People> getWinners(Map<Ticket, People> filarmonyMap) {

        final Set<People> res = new HashSet<>();
        filarmonyMap.values().stream().sorted(Listener.getComparator())
                .collect(Collectors.partitioningBy(people -> people.getClass().getName().equals("")))
                .values().forEach(list -> res.add(list.get(list.size() - 1)));

        return res;
//        return filarmonyMap.values().stream().sorted(Listener.getComparator())
//                .collect(Collectors.partitioningBy(people -> true))
//                .values().stream().collect(C);
    }
}
