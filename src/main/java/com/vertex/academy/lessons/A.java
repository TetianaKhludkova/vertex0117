package com.vertex.academy.lessons;

import java.sql.SQLClientInfoException;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by andrew_yashin on 2/18/17.
 */
public class A {
    protected List<Integer> getList(Collection<Integer> collection) throws Exception {
        return Collections.emptyList();
    }
}

class B extends A{
    @Override
    public ArrayList<Integer> getList(Collection<Integer> collection) {
        return new ArrayList<>();
    }

    public static void main(String[] args) {


        new B().getList(new ArrayList<>());
    }
}
