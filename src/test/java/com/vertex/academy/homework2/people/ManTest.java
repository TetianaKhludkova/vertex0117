package com.vertex.academy.homework2.people;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by andrew_yashin on 4/1/17.
 */
public class ManTest {
    private Man man;
    @Before
    public void setUp() throws Exception {
        man = new Man(21, "John");
    }

    @Test
    public void getNameTest(){
        assertEquals("John", man.getName());
    }

    @Test
    public void getNameForNullTest(){
        man = new Man(0, null);
        assertEquals("James", man.getName());
    }

    @Test
    public void getCountTest(){
        assertEquals(21, man.getNumber());
    }

}