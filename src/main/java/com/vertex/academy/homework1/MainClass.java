package com.vertex.academy.homework1;

/**
 * Created by Tanya on 25.01.2017.
 */
public class MainClass {

    public static void main(String[] args){
        ArtistProxy artist = new ArtistProxy();
//        todo: if i call getFiguresArray twice without printing the first call would be useless
        artist.getFiguresArray(150);
        artist.printFiguresArray();
    }
}
