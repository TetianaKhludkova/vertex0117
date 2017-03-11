package com.vertex.academy.lessons;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by vertex0007 on 11.03.2017.
 */
public class TryReflection {
    public static void main(String[] args){
        Arrays.stream(ArrayList.class.getClasses()).forEach(System.out::println);
        Arrays.stream(ArrayList.class.getDeclaredClasses()).forEach(System.out::println);
        Arrays.stream(ArrayList.class.getAnnotations()).forEach(System.out::println);
        Arrays.stream(ArrayList.class.getDeclaredAnnotations()).forEach(System.out::println);
    }
}
