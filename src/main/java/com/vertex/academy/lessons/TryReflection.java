package com.vertex.academy.lessons;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * Created by vertex0007 on 11.03.2017.
 */
public class TryReflection {
    private int privateInt = 0;
    protected int protectedInt = 0;
    int packageInt = 0;
    public int publicInt = 0;

    public static void main(String[] args) throws NoSuchFieldException {
//        printArray(Test.class.getDeclaredAnnotations());
//        System.out.println();
//        printArray(Test.class.getAnnotations());
//
//        Field field = String.class.getDeclaredField("hash");
//        field.setAccessible(true);
//        System.out.println(field.getModifiers());

        Field[] fields = TryReflection.class.getDeclaredFields();

        for(Field field: fields){
            field.setAccessible(true);
            System.out.println(field.getName() + " " + field.getModifiers());
        }
    }

    private static void printArray(Object[] array){
        Arrays.stream(array).forEach(System.out::println);
    }
}
