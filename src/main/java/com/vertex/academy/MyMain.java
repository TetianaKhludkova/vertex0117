package com.vertex.academy;

import com.vertex.academy.homeworkcollections.MainHomeworkCollections;
import com.vertex.academy.homeworkgeneric.MainHomeworkGeneric;
import com.vertex.academy.homeworkoop.MainHomeworkOop;

/**
 * Created by Valery on 1/28/2017.
 */
public class MyMain {

    private static final int HOMEWORK_NUMBER = 3;

    public static void main(String[] args){
        if (HOMEWORK_NUMBER == 1) {
            MainHomeworkOop.start();
        } else if (HOMEWORK_NUMBER == 2) {
            MainHomeworkCollections.start();
        } else if (HOMEWORK_NUMBER == 3) {
            MainHomeworkGeneric.start();
        }
    }
}