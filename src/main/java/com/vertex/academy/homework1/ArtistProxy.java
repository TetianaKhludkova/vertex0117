package com.vertex.academy.homework1;

import java.util.List;

/**
 * Created by Tanya on 27.01.2017.
 */
public class ArtistProxy implements ArtistInterface{
    //todo: Idea writes that access could be private. I am agree
    Artist instance;


    public List<FigureInterface> getInitialFiguresArray(){
        if (instance == null){
            instance = getArtist();
        }
        return instance.getInitialFiguresArray();
    }

    public List<FigureInterface> getFiguresArray(){
        if (instance == null){
            instance = getArtist();
        }
        return instance.getFiguresArray();
    }


    public List<FigureInterface> getFiguresArray(int number) {
        if (instance == null){
            instance = getArtist();
        }
        return instance.getFiguresArray(number);
    }

    public void printFiguresArray(){
        if (instance == null){
            instance = getArtist();
        }
        instance.printFiguresArray();
    }

    private Artist getArtist() {
        return new Artist();
    }

}
