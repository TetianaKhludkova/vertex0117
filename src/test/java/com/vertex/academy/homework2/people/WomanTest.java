package com.vertex.academy.homework2.people;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by andrew_yashin on 4/1/17.
 */
public class WomanTest {
    private static Woman woman;
    @Before
    public void initWoman(){
        woman = new Woman(3, "Hello");
    }

    @Test
    public void getNameTest(){
        assertEquals("Hello", woman.getName());
    }

    @Test
    public void getNameForNullTest(){
        woman = new Woman(3, null);
        assertEquals("Kitty", woman.getName());
    }

    @Test
    public void getCountTest(){
        assertEquals(3, woman.getNumber());
    }

}