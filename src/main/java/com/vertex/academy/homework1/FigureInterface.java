package com.vertex.academy.homework1;


/**
 * Created by Tanya on 23.01.2017.
 */
public interface FigureInterface {

    default void draw(){
        System.out.println(this);
    }
}
