package com.vertex.academy.homework2.human;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Tanya on 22.02.2017.
 */
class Observers<T extends HumanObserver> extends ArrayList<T> {
    void notifyObjectCreated(Object obj) {
        for (T t : this) t.objectCreated(obj);
    }
    void notifyObjectModified(Object obj) {
        for (T t : this) t.objectModified(obj);
    }
}