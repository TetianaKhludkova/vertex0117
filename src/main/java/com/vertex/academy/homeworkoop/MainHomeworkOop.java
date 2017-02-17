package com.vertex.academy.homeworkoop;

import com.vertex.academy.homeworkoop.forartist.ArtistProxy;

/**
 * Created by Aile (on Valery) on 2/10/2017.
 */
public class MainHomeworkOop {

    public MainHomeworkOop() {}

    public static void start(){

        ArtistProxy artist = new ArtistProxy(100, 5000, 5000);

        artist.paint(120);

    }
}
