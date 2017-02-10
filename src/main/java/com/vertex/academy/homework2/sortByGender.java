package com.vertex.academy.homework2;

import java.util.Comparator;


/**
 * Created by Tanya on 10.02.2017.
 */
class sortByGender implements Comparator<HumanInterface> {

    @Override
    public int compare(HumanInterface o1, HumanInterface o2) {
        if ((o1.getClass().equals(Man.class)) && (o2.getClass().equals(Lady.class))) {
            return 1;
        } else if ((o1.getClass().equals(Man.class)) && (o2.getClass().equals(Man.class))) {
            return 0;
        } else {
            return -1;
        }
    }
}
